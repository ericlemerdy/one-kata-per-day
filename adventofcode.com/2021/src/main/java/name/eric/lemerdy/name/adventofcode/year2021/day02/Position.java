package name.eric.lemerdy.name.adventofcode.year2021.day02;

import java.util.Objects;

public class Position {
    private long horizontal;
    private long depth;
    private long aim;

    public Position(final long horizontal, final long depth, long aim) {
        this.horizontal = horizontal;
        this.depth = depth;
        this.aim = aim;
    }

    public void applyCommand(final Command command) {
        switch (command.getDirection()) {
            case FORWARD: {
                horizontal += command.getUnits();
                depth = depth + aim * command.getUnits();
                break;
            }
            case DOWN: {
                aim += command.getUnits();
                break;
            }
            case UP: {
                aim -= command.getUnits();
                break;
            }
            default:
                break;
        }
    }

    public void add(Position position2) {
        horizontal += position2.horizontal;
        depth += position2.depth;
        aim += position2.aim;
    }

    public long multiply() {
        return this.horizontal * this.depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return horizontal == position.horizontal
                && depth == position.depth
                && aim == position.aim;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontal, depth, aim);
    }

    @Override
    public String toString() {
        return "Position{" +
                "horizontal=" + horizontal +
                ", depth=" + depth +
                ", aim=" + aim +
                '}';
    }
}
