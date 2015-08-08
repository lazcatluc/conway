package ro.contezi.conway;

import static org.assertj.core.api.StrictAssertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class NeighborhoodTest {
    private Cell origin;
    private Cell adiacentOnX;
    
    @Before
    public void setUp() {
        origin = new Cell(0, 0);
        adiacentOnX = new Cell(1, 0);
    }
    
    @Test
    public void cellIsNeighborOfAdiacentCellsOnX() throws Exception {
        assertThat(neighbors(origin, adiacentOnX)).isTrue();
    }
    
    @Test
    public void adiacentCellIsOnXNeighborOfCell() throws Exception {
        assertThat(neighbors(adiacentOnX, origin)).isTrue();
    }

    private boolean neighbors(Cell cell, Cell neighbor) {
        return Math.abs(cell.getX() - neighbor.getX()) == 1;
    }
}
