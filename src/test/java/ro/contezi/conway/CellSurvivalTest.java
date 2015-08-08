package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;
import static ro.contezi.conway.Cells.adiacentOnX;
import static ro.contezi.conway.Cells.adiacentOnXandY;
import static ro.contezi.conway.Cells.adiacentOnY;
import static ro.contezi.conway.Cells.origin;

import org.junit.Test;

public class CellSurvivalTest {
    @Test
    public void singleCellDies() throws Exception {
        assertThat(Surviver.survivors(origin())).isEmpty();
    }

    @Test
    public void cellWithTwoNeighborsSurvives() throws Exception {
        assertThat(Surviver.survivors(origin(), adiacentOnX(), adiacentOnY())).contains(origin());
    }
    
    @Test
    public void cellWithThreeNeighborsSurvives() throws Exception {
        assertThat(Surviver.survivors(origin(), adiacentOnX(), adiacentOnY(), adiacentOnXandY())).contains(origin());
    }
}
