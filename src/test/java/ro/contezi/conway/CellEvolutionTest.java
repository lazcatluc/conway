package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.Test;

public class CellEvolutionTest {
    @Test
    public void singleCellDies() throws Exception {
        assertThat(evolve(new Cell(0, 0))).isEmpty();
    }

    @Test
    public void cellWithTwoNeighborsSurvives() throws Exception {
        Cell origin = new Cell(0, 0);
        Cell neighborOnX = new Cell(1, 0);
        Cell neighborOnY = new Cell(0, 1);

        assertThat(evolve(origin, neighborOnX, neighborOnY)).contains(origin);
    }

    private Collection<Cell> evolve(Cell... cells) {
        return Arrays.asList(cells).stream().filter(cell -> neighborsCount(cell, cells) == 2)
                .collect(Collectors.toList());
    }

    private long neighborsCount(Cell cell, Cell[] cells) {
        return Arrays.asList(cells).stream().filter(possibleNeighbor -> Neighbors.neighbors(cell, possibleNeighbor))
                .count();
    }
}
