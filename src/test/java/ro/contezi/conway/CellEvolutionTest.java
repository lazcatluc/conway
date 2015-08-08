package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;
import static ro.contezi.conway.Cells.adiacentOnX;
import static ro.contezi.conway.Cells.adiacentOnXandY;
import static ro.contezi.conway.Cells.adiacentOnY;
import static ro.contezi.conway.Cells.origin;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CellEvolutionTest {
    @Test
    public void squareEvolvesToItself() throws Exception {
        assertThat(evolve(origin(), adiacentOnX(), adiacentOnY(), adiacentOnXandY()))
                .isEqualTo(new HashSet<>(Arrays.asList(origin(), adiacentOnX(), adiacentOnY(), adiacentOnXandY())));
    }

    private Collection<Cell> evolve(Cell... cells) {
        Set<Cell> evolved = new HashSet<>();
        evolved.addAll(Surviver.survivors(cells));
        evolved.addAll(Revivor.revived(cells));
        return evolved;
    }
}
