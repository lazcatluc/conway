package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import static ro.contezi.conway.Cells.*;

import org.junit.Test;

public class CellEvolutionTest {
    @Test
    public void singleCellDies() throws Exception {
        assertThat(evolve(origin())).isEmpty();
    }

    @Test
    public void cellWithTwoNeighborsSurvives() throws Exception {
        assertThat(evolve(origin(), adiacentOnX(), adiacentOnY())).contains(origin());
    }
    
    @Test
    public void cellWithThreeNeighborsSurvives() throws Exception {
        assertThat(evolve(origin(), adiacentOnX(), adiacentOnY(), adiacentOnXandY())).contains(origin());
    }

    private Collection<Cell> evolve(Cell... cells) {
        return Arrays.asList(cells).stream().filter(cell -> {
            long neighborsCount = neighborsCount(cell, cells);
            return neighborsCount == 2 || neighborsCount == 3;
        }).collect(Collectors.toList());
    }

    private long neighborsCount(Cell cell, Cell[] cells) {
        return Arrays.asList(cells).stream().filter(possibleNeighbor -> Neighbors.neighbors(cell, possibleNeighbor))
                .count();
    }
}
