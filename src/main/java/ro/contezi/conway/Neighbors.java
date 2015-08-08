package ro.contezi.conway;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Neighbors {

    public static boolean neighbors(Cell cell, Cell neighbor) {
        boolean adiacent = false;
        List<Coordinate> coordinates = Arrays.asList(Cell::getX, Cell::getY);
        for (Coordinate coordinate : coordinates) {
            if (farOn(coordinate, cell, neighbor)) {
                return false;
            }
            if (adiacentOn(coordinate, cell, neighbor)) {
                adiacent = true;
            }
        }
        
        return adiacent;
    }

    public static boolean farOn(Coordinate coordinate, Cell cell, Cell possibleNeighbor) {
        return distanceOn(coordinate, cell, possibleNeighbor) > 1;
    }

    private static boolean adiacentOn(Coordinate coordinate, Cell cell, Cell possibleNeighbor) {
        return distanceOn(coordinate, cell, possibleNeighbor) == 1;
    }

    private static int distanceOn(Coordinate coordinate, Cell cell, Cell possibleNeighbor) {
        return Math.abs(coordinate.apply(cell) - coordinate.apply(possibleNeighbor));
    }

    public static Collection<Cell> of(Cell cell) {
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
