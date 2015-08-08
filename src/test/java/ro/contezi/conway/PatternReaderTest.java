package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static ro.contezi.conway.Cells.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PatternReaderTest {
    @Test
    public void readsEmptyPattern() throws Exception {
        assertThat(read("", 1, 1)).isEqualTo(Collections.emptySet());
    }

    @Test
    public void readsOneCellPattern() throws Exception {
        assertThat(read("o", 1, 1)).isEqualTo(Collections.singleton(origin()));
    }

    @Test
    public void readsTwoCellsOnTheSameLine() throws Exception {
        assertThat(read("oo", 2, 1)).isEqualTo(new HashSet<>(Arrays.asList(origin(), adiacentOnX())));
    }
    
    @Test
    public void readsTwoCellsOnTheSameRow() throws Exception {
        assertThat(read("oo", 1, 2)).isEqualTo(new HashSet<>(Arrays.asList(origin(), adiacentOnY())));
    }
    
    @Test
    public void readsTwoDiagonalCells() throws Exception {
        assertThat(read("o."+
                        ".o", 2, 2)).isEqualTo(new HashSet<>(Arrays.asList(origin(), adiacentOnXandY())));
    }
    
    @Test
    public void readsRPentomino() throws Exception {
        Collection<Cell> rPentomino =
                read(".o."+
                     "oo."+
                     ".oo", 3, 3);
        assertThat(Evolver.evolveFor(1103, rPentomino).size()).isEqualTo(116);
        
    }

    private Collection<Cell> read(String pattern, int xColumns, int yRows) {
        Set<Cell> cells = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if ('o' == ch) {
                int x = i % xColumns;
                int y = (i / xColumns) % yRows;
                cells.add(new Cell(x, y));
            }
        }

        return cells;
    }
}
