package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThat;
import static ro.contezi.conway.Cells.adiacentOnX;
import static ro.contezi.conway.Cells.adiacentOnXandY;
import static ro.contezi.conway.Cells.adiacentOnY;
import static ro.contezi.conway.Cells.origin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.junit.Test;

public class PatternReaderTest {
    @Test
    public void readsEmptyPattern() throws Exception {
        assertThat(PatternReader.read("", 1, 1)).isEqualTo(Collections.emptySet());
    }

    @Test
    public void readsOneCellPattern() throws Exception {
        assertThat(PatternReader.read("o", 1, 1)).isEqualTo(Collections.singleton(origin()));
    }

    @Test
    public void readsTwoCellsOnTheSameLine() throws Exception {
        assertThat(PatternReader.read("oo", 2, 1)).isEqualTo(new HashSet<>(Arrays.asList(origin(), adiacentOnX())));
    }
    
    @Test
    public void readsTwoCellsOnTheSameRow() throws Exception {
        assertThat(PatternReader.read("oo", 1, 2)).isEqualTo(new HashSet<>(Arrays.asList(origin(), adiacentOnY())));
    }
    
    @Test
    public void readsTwoDiagonalCells() throws Exception {
        assertThat(PatternReader.read("o."+
                        ".o", 2, 2)).isEqualTo(new HashSet<>(Arrays.asList(origin(), adiacentOnXandY())));
    }
    
    @Test
    public void readsRPentomino() throws Exception {
        Collection<Cell> rPentomino =
                PatternReader.read(
                     ".0."+
                     "00."+
                     ".00", 3, 3);
        assertThat(Evolver.evolveFor(1103, rPentomino).size()).isEqualTo(116);
    }
}
