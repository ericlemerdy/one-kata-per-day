package name.eric.lemerdy.name.adventofcode.year2021.day02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Command {

    private static final Pattern PATTERN = Pattern.compile("(\\w+) (\\d)");

    private final Direction direction;

    private final long units;

    private Command(final Direction direction, final long units) {
        this.direction = direction;
        this.units = units;
    }

    public Direction getDirection() {
        return direction;
    }

    public long getUnits() {
        return units;
    }

    public static Command fromString(String command) {
        return Stream
                .of(command)
                .map(PATTERN::matcher)
                .filter(Matcher::find)
                .map(matcher -> new Command(Direction.valueOf(matcher.group(1).toUpperCase()), Long.parseLong(matcher.group(2))))
                .findFirst()
                .orElseThrow();
    }
}


