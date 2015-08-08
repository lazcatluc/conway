package ro.contezi.conway;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.conway.Neighbors.neighbors;
import static ro.contezi.conway.Cells.*;

import org.junit.Test;

public class NeighborhoodTest {
    
    @Test
    public void cellIsNeighborOfAdiacentCellsOnX() throws Exception {
        assertThat(neighbors(origin(), adiacentOnX())).isTrue();
    }

    @Test
    public void adiacentCellOnXIsNeighborOfCell() throws Exception {
        assertThat(neighbors(adiacentOnX(), origin())).isTrue();
    }

    @Test
    public void cellIsNeighborOfAdiacentCellsOnY() throws Exception {
        assertThat(neighbors(origin(), adiacentOnY())).isTrue();
    }

    @Test
    public void adiacentCellOnYIsNeighborOfCell() throws Exception {
        assertThat(neighbors(adiacentOnY(), origin())).isTrue();
    }

    @Test
    public void farCellOnXIsNotNeighborOfCell() throws Exception {
        assertThat(neighbors(farOnX(), origin())).isFalse();
    }

    @Test
    public void farCellOnYIsNotNeighborOfCell() throws Exception {
        assertThat(neighbors(farOnY(), origin())).isFalse();
    }
}
