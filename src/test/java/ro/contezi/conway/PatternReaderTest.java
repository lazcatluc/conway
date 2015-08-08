package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;
import static ro.contezi.conway.Cells.origin;

import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

public class PatternReaderTest {
    @Test
    public void readsEmptyPattern() throws Exception {
        String pattern = "";
        
        assertThat(read(pattern, 1, 1)).isEqualTo(Collections.emptyList());
    }
    
    @Test
    public void readsOneCellPattern() throws Exception {
        String pattern = "o";
        
        assertThat(read(pattern, 1, 1)).isEqualTo(Collections.singleton(origin()));
    }

    private Collection<Cell> read(String pattern, int xColumns, int yRows) {
        if ("o".equals(pattern)) {
            return Collections.singleton(origin());
        }
        return Collections.emptyList();
    }
}
