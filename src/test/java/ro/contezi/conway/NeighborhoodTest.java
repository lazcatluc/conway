package ro.contezi.conway;

import static org.assertj.core.api.StrictAssertions.assertThat;

import org.junit.Test;

public class NeighborhoodTest {
    @Test
    public void cellIsNeighborOfAdiacentCells() throws Exception {
        Cell cell = new Cell(0, 0);
        Cell neighbor = new Cell(1, 0);
        
        assertThat(neighbors(cell, neighbor)).isTrue();
    }
    
    @Test
    public void adiacentCellIsNeighborOfCell() throws Exception {
        Cell cell = new Cell(0, 0);
        Cell neighbor = new Cell(1, 0);
        
        assertThat(neighbors(neighbor, cell)).isTrue();
    }

    private boolean neighbors(Cell cell, Cell neighbor) {
        return Math.abs(cell.getX() - neighbor.getX()) == 1;
    }
}
