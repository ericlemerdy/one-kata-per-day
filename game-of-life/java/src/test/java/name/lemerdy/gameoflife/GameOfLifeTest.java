package name.lemerdy.gameoflife;

import name.lemerdy.gameoflife.Cell;
import name.lemerdy.gameoflife.Grid;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeTest {

    @Test
    public void rule_1__any_live_cell_with_fewer_than_two_live_neighbours_dies() {
        Cell cell = new Cell(true);
        assertThat(cell.nextGenerationWithAliveNeighbors(0)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(1)).isEqualTo(new Cell(FALSE));
    }

    @Test
    public void rule_2__any_live_cell_with_two_or_three_live_neighbours_lives() {
        Cell cell = new Cell(true);
        assertThat(cell.nextGenerationWithAliveNeighbors(2)).isEqualTo(new Cell(TRUE));
        assertThat(cell.nextGenerationWithAliveNeighbors(3)).isEqualTo(new Cell(TRUE));
    }

    @Test
    public void rule_3__any_live_cell_with_more_than_three_live_neighbours_dies() {
        Cell cell = new Cell(true);
        assertThat(cell.nextGenerationWithAliveNeighbors(4)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(5)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(6)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(7)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(8)).isEqualTo(new Cell(FALSE));
    }

    @Test
    public void rule_4__any_dead_cell_with_exactly_three_live_neighbours_becomes_a_live_cell() {
        Cell cell = new Cell(false);
        assertThat(cell.nextGenerationWithAliveNeighbors(0)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(1)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(2)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(3)).isEqualTo(new Cell(TRUE));
        assertThat(cell.nextGenerationWithAliveNeighbors(4)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(5)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(6)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(7)).isEqualTo(new Cell(FALSE));
        assertThat(cell.nextGenerationWithAliveNeighbors(8)).isEqualTo(new Cell(FALSE));
    }

    @Test
    public void acceptance() throws Exception {
        Grid grid = new Grid(
                ".....",
                ".....",
                ".***.",
                ".....",
                ".....");
        assertThat(grid.nextGeneration()).containsExactly(
                ".....",
                "..*..",
                "..*..",
                "..*..",
                "....."
        );
    }
}
