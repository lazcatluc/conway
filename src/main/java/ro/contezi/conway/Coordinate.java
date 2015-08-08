package ro.contezi.conway;

import java.util.function.Function;

@FunctionalInterface
public interface Coordinate extends Function<Cell, Integer> {
    
}