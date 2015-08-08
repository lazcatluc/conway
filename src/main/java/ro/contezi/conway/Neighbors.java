package ro.contezi.conway;

import java.util.Arrays;
import java.util.List;

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

}
