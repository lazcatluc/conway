package ro.contezi.conway;

public class Cells {
    public static Cell origin() {
        return new Cell(0, 0);
    }
    
    public static Cell adiacentOnX() {
        return new Cell(1, 0);
    }
    
    public static Cell adiacentOnXandY() {
        return new Cell(1, 1);
    }
    
    public static Cell adiacentOnY() {
        return new Cell(0, 1);
    }
    
    public static Cell farOnY() {
        return new Cell(-1, 10);
    }
    
    public static Cell farOnX() {
        return new Cell(10, 1);
    }
}
