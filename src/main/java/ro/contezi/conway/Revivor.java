package ro.contezi.conway;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Revivor {

    public static Collection<Cell> revived(Cell... cells) {
        Map<Cell, Integer> possibleNeighbors = new HashMap<>();
        Arrays.asList(cells).forEach(myCell -> Neighbors.of(myCell)
                .forEach(cell -> possibleNeighbors.put(cell, possibleNeighbors.getOrDefault(cell, 0) + 1)));
        return possibleNeighbors.entrySet().stream().filter(entry -> entry.getValue() == 3)
                .map(Map.Entry::getKey).collect(Collectors.toSet());
    }

}
