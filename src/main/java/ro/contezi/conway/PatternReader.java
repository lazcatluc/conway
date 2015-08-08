package ro.contezi.conway;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PatternReader {
    
    private static final List<Character> MATCHES = Arrays.asList('o', '0', 'O');

    public static Collection<Cell> read(String pattern, int xColumns, int yRows) {
        Set<Cell> cells = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (MATCHES.contains(ch)) {
                int x = i % xColumns;
                int y = (i / xColumns) % yRows;
                cells.add(new Cell(x, y));
            }
        }
    
        return cells;
    }

}
