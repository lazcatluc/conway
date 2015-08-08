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

}
