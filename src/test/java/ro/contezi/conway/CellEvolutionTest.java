package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

public class CellEvolutionTest {
    @Test
    public void singleCellDies() throws Exception {
        assertThat(evolve(new Cell(0, 0))).isEmpty();
    }

    private Collection<Cell> evolve(Cell... cell) {
        return Collections.emptyList();
    }
}
