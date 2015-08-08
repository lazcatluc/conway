package ro.contezi.conway;

import static org.assertj.core.api.StrictAssertions.assertThat;

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
        assertThat(Neighbors.neighbors(origin, adiacentOnX)).isTrue();
    }
    
    @Test
    public void adiacentCellOnXIsNeighborOfCell() throws Exception {
        assertThat(Neighbors.neighbors(adiacentOnX, origin)).isTrue();
    }
    
    @Test
    public void cellIsNeighborOfAdiacentCellsOnY() throws Exception {
        assertThat(Neighbors.neighbors(origin, adiacentOnY)).isTrue();
    }
    
    @Test
    public void adiacentCellOnYIsNeighborOfCell() throws Exception {
        assertThat(Neighbors.neighbors(adiacentOnY, origin)).isTrue();
    }
    
    @Test
    public void farCellOnXIsNotNeighborOfCell() throws Exception {
        assertThat(Neighbors.neighbors(farOnX, origin)).isFalse();
    }
    
    @Test
    public void farCellOnYIsNotNeighborOfCell() throws Exception {
        assertThat(Neighbors.neighbors(farOnY, origin)).isFalse();
    }
}
