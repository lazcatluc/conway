package ro.contezi.conway;

import java.util.Collection;

public class Main {
    
    String pattern = "O.....O."+
                     "..O...O."+
                     "..O..O.O"+
                     ".O.O....";
    
    public static void main(String args[]) {
        Cell[] cells = new Cell[] { new Cell(0, 0), new Cell(0, 1), new Cell(1, 0), new Cell(1, -1), new Cell(-1, 0) };

        for (int i = 0; i < 1500; i++) {
            Collection<Cell> evolved = Evolver.evolve(cells);
            System.out.println(i+": "+evolved.size());
            cells = evolved.toArray(new Cell[evolved.size()]);
        }
    }
}
