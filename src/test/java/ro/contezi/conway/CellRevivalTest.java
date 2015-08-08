package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;
import static ro.contezi.conway.Cells.adiacentOnX;
import static ro.contezi.conway.Cells.adiacentOnXandY;
import static ro.contezi.conway.Cells.adiacentOnY;
import static ro.contezi.conway.Cells.origin;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class CellRevivalTest {
    @Test
    public void cellWithThreeNeighborsIsRevived() throws Exception {
        assertThat(revived(adiacentOnX(), adiacentOnY(), adiacentOnXandY())).contains(origin());
    }

    private Collection<Cell> revived(Cell... cells) {
        Map<Cell, Integer> possibleNeighbors = new HashMap<>();
        Arrays.asList(cells).forEach(myCell -> Neighbors.of(myCell)
                .forEach(cell -> possibleNeighbors.put(cell, possibleNeighbors.getOrDefault(cell, 0) + 1)));
        return possibleNeighbors.entrySet().stream().filter(entry -> entry.getValue() == 3)
                .map(Map.Entry::getKey).collect(Collectors.toSet());
    }
}
