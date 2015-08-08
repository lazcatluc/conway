package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;
import static ro.contezi.conway.Cells.adiacentOnX;
import static ro.contezi.conway.Cells.adiacentOnXandY;
import static ro.contezi.conway.Cells.adiacentOnY;
import static ro.contezi.conway.Cells.origin;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class CellEvolutionTest {
    @Test
    public void squareEvolvesToItself() throws Exception {
        assertThat(Evolver.evolve(origin(), adiacentOnX(), adiacentOnY(), adiacentOnXandY()))
                .isEqualTo(new HashSet<>(Arrays.asList(origin(), adiacentOnX(), adiacentOnY(), adiacentOnXandY())));
    }
}
