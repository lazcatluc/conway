package ro.contezi.conway;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Surviver {

    public static Collection<Cell> survivors(Cell... cells) {
        return Arrays.asList(cells).stream().filter(cell -> {
            int neighborsCount = neighborsCount(cell, cells);
            return neighborsCount == 2 || neighborsCount == 3;
        }).collect(Collectors.toList());
    }

    public static int neighborsCount(Cell cell, Cell[] cells) {
        Collection<Cell> neighbors = Neighbors.of(cell);
        neighbors.retainAll(Arrays.asList(cells));
        return neighbors.size();
    }

}
