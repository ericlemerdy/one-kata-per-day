package name.lemerdy.gameoflife;

import java.util.function.Function;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Cell {
    public static final Function<String, Cell> STRING_TO_CELL = s -> s.equals("*") ? new Cell(TRUE) : new Cell(FALSE);
    private final boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public Cell nextGenerationWithAliveNeighbors(int aliveNeighbors) {
        if (alive && aliveNeighbors == 2) {
            return new Cell(TRUE);
        }
        if (aliveNeighbors == 3) {
            return new Cell(TRUE);
        }
        return new Cell(FALSE);
    }

    @Override
    public boolean equals(Object obj) {
        return this.alive == ((Cell) obj).alive;
    }

    @Override
    public String toString() {
        return alive ? "*" : ".";
    }
}
