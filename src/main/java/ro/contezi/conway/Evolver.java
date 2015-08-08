package ro.contezi.conway;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Evolver {

    public static Collection<Cell> evolve(Cell... cells) {
        Set<Cell> evolved = new HashSet<>();
        evolved.addAll(Surviver.survivors(cells));
        evolved.addAll(Revivor.revived(cells));
        return evolved;
    }

    public static Collection<Cell> evolveFor(int turns, Collection<Cell> cells) {
        Cell[] evolutionCells = cells.toArray(new Cell[cells.size()]);
        for (int i = 0; i < turns-1; i++) {
            Collection<Cell> evolved = evolve(evolutionCells);
            evolutionCells = evolved.toArray(new Cell[evolved.size()]);
        }
        return evolve(evolutionCells);
    }
}
