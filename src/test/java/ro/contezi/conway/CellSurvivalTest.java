package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;
import static ro.contezi.conway.Cells.adiacentOnX;
import static ro.contezi.conway.Cells.adiacentOnXandY;
import static ro.contezi.conway.Cells.adiacentOnY;
import static ro.contezi.conway.Cells.origin;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.Test;

public class CellSurvivalTest {
    @Test
    public void singleCellDies() throws Exception {
        assertThat(survivors(origin())).isEmpty();
    }

    @Test
    public void cellWithTwoNeighborsSurvives() throws Exception {
        assertThat(survivors(origin(), adiacentOnX(), adiacentOnY())).contains(origin());
    }
    
    @Test
    public void cellWithThreeNeighborsSurvives() throws Exception {
        assertThat(survivors(origin(), adiacentOnX(), adiacentOnY(), adiacentOnXandY())).contains(origin());
    }

    private Collection<Cell> survivors(Cell... cells) {
        return Arrays.asList(cells).stream().filter(cell -> {
            int neighborsCount = neighborsCount(cell, cells);
            return neighborsCount == 2 || neighborsCount == 3;
        }).collect(Collectors.toList());
    }

    private int neighborsCount(Cell cell, Cell[] cells) {
        Collection<Cell> neighbors = Neighbors.of(cell);
        neighbors.retainAll(Arrays.asList(cells));
        return neighbors.size();
    }
}
