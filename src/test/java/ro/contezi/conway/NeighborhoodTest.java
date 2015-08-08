package ro.contezi.conway;

import static org.assertj.core.api.StrictAssertions.assertThat;

import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

public class NeighborhoodTest {
    private Cell origin;
    private Cell adiacentOnX;
    private Cell adiacentOnY;
    
    @Before
    public void setUp() {
        origin = new Cell(0, 0);
        adiacentOnX = new Cell(1, 0);
        adiacentOnY = new Cell(0, 1);
    }
    
    @Test
    public void cellIsNeighborOfAdiacentCellsOnX() throws Exception {
        assertThat(neighbors(origin, adiacentOnX)).isTrue();
    }
    
    @Test
    public void adiacentCellOnXIsNeighborOfCell() throws Exception {
        assertThat(neighbors(adiacentOnX, origin)).isTrue();
    }
    
    @Test
    public void cellIsNeighborOfAdiacentCellsOnY() throws Exception {
        assertThat(neighbors(origin, adiacentOnY)).isTrue();
    }
    
    @Test
    public void adiacentCellOnYIsNeighborOfCell() throws Exception {
        assertThat(neighbors(adiacentOnY, origin)).isTrue();
    }

    private boolean neighbors(Cell cell, Cell neighbor) {
        return adiacentOn(Cell::getX, cell, neighbor) ||
                adiacentOn(Cell::getY, cell, neighbor);
    }
    
    private boolean adiacentOn(Function<Cell, Integer> coordinate, Cell cell, Cell possibleNeighbor) {
        return Math.abs(coordinate.apply(cell) - coordinate.apply(possibleNeighbor)) == 1;
    }
}
