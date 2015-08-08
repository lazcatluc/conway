package ro.contezi.conway;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class NeighborhoodTest {
    @Test
    public void cellIsNeighborOfAdiacentCells() throws Exception {
        Cell cell = new Cell(0, 0);
        Cell neighbor = new Cell(1, 0);
        
        assertThat(neighbors(cell, neighbor)).isTrue();
    }

    private boolean neighbors(Cell cell, Cell neighbor) {
        return cell.getX() - neighbor.getX() == -1;
    }
}
