package name.eric.lemerdy.name.adventofcode.year2021.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class PlannedCourse {
    private final String[] commands;

    private PlannedCourse(final String... commands) {
        this.commands = commands;
    }

    public static PlannedCourseBuilder builder() {
        return new PlannedCourseBuilder();
    }

    public Position execute() {
        return Arrays
                .stream(commands)
                .map(Command::fromString)
                .collect(() -> new Position(0L, 0L, 0L), Position::applyCommand, Position::add);
    }

    public static class PlannedCourseBuilder {
        private String[] commands;

        public PlannedCourseBuilder withCommands(String... commands) {
            this.commands = commands;
            return this;
        }

        public PlannedCourseBuilder withCommandsFromPath(Path path) throws IOException {
            try (Stream<String> lines = Files.lines(path)) {
                this.commands = lines.toArray(String[]::new);
            }
            return this;
        }

        public PlannedCourse build() {
            return new PlannedCourse(this.commands);
        }
    }
}
