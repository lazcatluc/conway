package ro.contezi.conway;

import static org.assertj.core.api.StrictAssertions.assertThat;

import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

public class NeighborhoodTest {
    private Cell origin;
    private Cell adiacentOnX;
    private Cell adiacentOnY;
    private Cell farOnX;
    private Cell farOnY;
    
    @Before
    public void setUp() {
        origin = new Cell(0, 0);
        adiacentOnX = new Cell(1, 0);
        adiacentOnY = new Cell(0, 1);
        farOnX = new Cell(10, 1);
        farOnY = new Cell(-1, 10);
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
    
    @Test
    public void farCellOnXIsNotNeighborOfCell() throws Exception {
        assertThat(neighbors(farOnX, origin)).isFalse();
    }
    
    @Test
    public void farCellOnYIsNotNeighborOfCell() throws Exception {
        assertThat(neighbors(farOnY, origin)).isFalse();
    }

    private boolean neighbors(Cell cell, Cell neighbor) {
        if (farOn(Cell::getX, cell, neighbor) || farOn(Cell::getY, cell, neighbor)) {
            return false;
        }
        return adiacentOn(Cell::getX, cell, neighbor) ||
                adiacentOn(Cell::getY, cell, neighbor);
    }
    
    private boolean farOn(Function<Cell, Integer> coordinate, Cell cell, Cell possibleNeighbor) {
        return distanceOn(coordinate, cell, possibleNeighbor) > 1;
    }

    private boolean adiacentOn(Function<Cell, Integer> coordinate, Cell cell, Cell possibleNeighbor) {
        return distanceOn(coordinate, cell, possibleNeighbor) == 1;
    }
    
    private int distanceOn(Function<Cell, Integer> coordinate, Cell cell, Cell possibleNeighbor) {
        return Math.abs(coordinate.apply(cell) - coordinate.apply(possibleNeighbor));
    }
}
