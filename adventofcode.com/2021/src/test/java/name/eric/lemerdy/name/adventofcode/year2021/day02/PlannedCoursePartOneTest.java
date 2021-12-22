package name.eric.lemerdy.name.adventofcode.year2021.day02;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

@Ignore("Because changes has been made in the spec.")
public class PlannedCoursePartOneTest {

    @Test
    public void should_execute_planned_course_one_command() {
        PlannedCourse plannedCourse = PlannedCourse.builder().withCommands("forward 5").build();

        Position position = plannedCourse.execute();

        Assertions.assertThat(position).isEqualTo(new Position(5L, 0L, 0L));
    }

    @Test
    public void should_execute_planned_course_two_command() {
        PlannedCourse plannedCourse = PlannedCourse.builder().withCommands("forward 5", "down 5").build();

        Position position = plannedCourse.execute();

        Assertions.assertThat(position).isEqualTo(new Position(5L, 5L, 0L));
    }

    @Test
    public void should_execute_planned_course_with_example_command() {
        PlannedCourse plannedCourse = PlannedCourse.builder().withCommands("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2").build();

        Position position = plannedCourse.execute();

        Assertions.assertThat(position).isEqualTo(new Position(15L, 10L, 0L));
        Assertions.assertThat(position.multiply()).isEqualTo(150L);
    }

    @Test
    public void should_execute_planned_course_with_input_command() throws IOException {
        PlannedCourse plannedCourse = PlannedCourse.builder().withCommandsFromPath(Paths.get("src/test/resources/input-day-02")).build();

        Position position = plannedCourse.execute();

        Assertions.assertThat(position.multiply()).isEqualTo(1451208L);
    }
}
