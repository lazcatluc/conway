package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;
import static ro.contezi.conway.Cells.adiacentOnX;
import static ro.contezi.conway.Cells.adiacentOnXandY;
import static ro.contezi.conway.Cells.adiacentOnY;
import static ro.contezi.conway.Cells.origin;

import org.junit.Test;

public class CellRevivalTest {
    @Test
    public void cellWithThreeNeighborsIsRevived() throws Exception {
        assertThat(Revivor.revived(adiacentOnX(), adiacentOnY(), adiacentOnXandY())).contains(origin());
    }
    
    @Test
    public void cellWithTwoNeighborsIsNotRevived() throws Exception {
        assertThat(Revivor.revived(adiacentOnX(), adiacentOnY())).doesNotContain(origin());
    }
}
