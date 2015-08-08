package ro.contezi.conway;

import static org.assertj.core.api.Assertions.assertThat;
import static ro.contezi.conway.Cells.adiacentOnX;
import static ro.contezi.conway.Cells.adiacentOnXandY;
import static ro.contezi.conway.Cells.adiacentOnY;
import static ro.contezi.conway.Cells.origin;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class CellRevivalTest {
    @Test
    public void cellWithThreeNeighborsIsRevived() throws Exception {
        assertThat(revived(adiacentOnX(), adiacentOnY(), adiacentOnXandY())).contains(origin());
    }

    private Collection<Cell> revived(Cell... cells) {
        Map<Cell, Integer> possibleNeighbors = new HashMap<>();
        Arrays.asList(cells).forEach(myCell -> cellNeighbors(myCell)
                .forEach(cell -> possibleNeighbors.put(cell, possibleNeighbors.getOrDefault(cell, 0) + 1)));
        return possibleNeighbors.entrySet().stream().filter(entry -> entry.getValue() == 3)
                .map(Map.Entry::getKey).collect(Collectors.toSet());
    }

    private Collection<Cell> cellNeighbors(Cell cell) {
        Set<Cell> cells = new HashSet<>();
        for (int i = -1; i< 2; i++) {
            for (int j = -1; j < 2; j++) {
                cells.add(new Cell(cell.getX()+i,cell.getY()+j));
            }
        }
        cells.remove(cell);
        return cells;
    }
}
