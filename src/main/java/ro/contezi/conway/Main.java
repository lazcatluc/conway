package ro.contezi.conway;

import java.util.Collection;

public class Main {
    
    public static void main(String args[]) {
        String pattern = 
                "O.....O."+
                "..O...O."+
                "..O..O.O"+
                ".O.O....";
        Collection<Cell> cells = PatternReader.read(pattern, pattern.length() / 4, 4);
        
        int step = 1000;
        for (int i = 1; i < 18; i ++) {
            cells = Evolver.evolveFor(step, cells);
            System.out.println((i*step)+": "+cells.size());
        }
    }
}
