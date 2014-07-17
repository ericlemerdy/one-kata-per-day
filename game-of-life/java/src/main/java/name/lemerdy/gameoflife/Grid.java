package name.lemerdy.gameoflife;

import java.util.List;

import static com.google.common.base.Splitter.fixedLength;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;
import static name.lemerdy.gameoflife.Cell.STRING_TO_CELL;

public class Grid {
    private final List<List<Cell>> cells;

    public Grid(String... lines) {
        this.cells = newArrayList();
        for (String line : lines) {
            this.cells.add(fixedLength(1).splitToList(line).stream().map(STRING_TO_CELL).collect(toList()));
        }
    }

    public List<String> nextGeneration() {
        List<String> newGrid = newArrayList();
        for (int height = 0; height < cells.size(); height++) {
            List<Cell> line = cells.get(height);
            StringBuffer sb = new StringBuffer();
            for (int width = 0; width < line.size(); width++) {
                Cell cell = line.get(width);
                sb.append(cell.nextGenerationWithAliveNeighbors(countAliveNeighbours(height, width)));
            }
            newGrid.add(sb.toString());
        }
        return newGrid;
    }

    private int countAliveNeighbours(int height, int width) {
        int aliveNeighbours = 0;
        aliveNeighbours += isAlive(height + (-1), width + (-1));
        aliveNeighbours += isAlive(height + (-1), width + (+0));
        aliveNeighbours += isAlive(height + (-1), width + (+1));
        aliveNeighbours += isAlive(height + (+0), width + (+1));
        aliveNeighbours += isAlive(height + (+1), width + (+1));
        aliveNeighbours += isAlive(height + (+1), width + (+0));
        aliveNeighbours += isAlive(height + (+1), width + (-1));
        aliveNeighbours += isAlive(height + (+0), width + (-1));
        return aliveNeighbours;
    }

    private int isAlive(int height, int width) {
        if (height < 0) {
            return 0;
        }
        if (height >= cells.size()) {
            return 0;
        }
        if (width < 0) {
            return 0;
        }
        if (width >= cells.get(0).size()) {
            return 0;
        }
        return cells.get(height).get(width).equals(new Cell(true)) ? 1 : 0;
    }

    @Override
    public String toString() {

        // return cells.stream().map(cellList -> cellList.stream().map(cell -> cell.toString()).collect(Collectors.joining(" ", "", "\n")));

        StringBuffer out = new StringBuffer();
        for (List<Cell> cell : cells) {
            out.append(cell.stream().map(cel -> cel.toString()));
            for (Cell cell1 : cell) {
                out.append(cell1.toString());
            }
            out.append('\n');
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Grid g = new Grid(
                ".....",
                ".....",
                ".***.",
                ".....",
                ".....");
        while (true) {
            System.out.println(g.toString());
            g = new Grid(g.nextGeneration().toArray(new String[]{}));
        }
    }
}
