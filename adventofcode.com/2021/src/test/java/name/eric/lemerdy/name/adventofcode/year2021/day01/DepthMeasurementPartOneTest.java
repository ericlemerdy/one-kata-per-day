package name.eric.lemerdy.name.adventofcode.year2021.day01;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class DepthMeasurementPartOneTest {

    @Test
    public void can_not_count_when_there_is_only_one_measure() {
        DepthMeasurements depthMeasurements = DepthMeasurements.builder().withMeasures(199).build();

        long numberOfTimesADepthMeasurementIncreases = depthMeasurements.countIncreases();

        Assertions.assertThat(numberOfTimesADepthMeasurementIncreases).isEqualTo(0L);
    }

    @Test
    public void should_count_one_when_the_second_measure_is_larger_than_the_first() {
        DepthMeasurements depthMeasurements = DepthMeasurements.builder().withMeasures(199, 200).build();

        long numberOfTimesADepthMeasurementIncreases = depthMeasurements.countIncreases();

        Assertions.assertThat(numberOfTimesADepthMeasurementIncreases).isEqualTo(1L);
    }

    @Test
    public void should_count_with_example() {
        DepthMeasurements depthMeasurements = DepthMeasurements.builder().withMeasures(199, 200, 208, 210, 200, 207, 240, 269, 260, 263).build();

        long numberOfTimesADepthMeasurementIncreases = depthMeasurements.countIncreases();

        Assertions.assertThat(numberOfTimesADepthMeasurementIncreases).isEqualTo(7L);
    }

    @Test
    public void should_count_with_input() throws IOException {
        DepthMeasurements depthMeasurements = DepthMeasurements.builder().withMeasuresFromPath(Paths.get("src/test/resources/input-day-01")).build();

        long numberOfTimesADepthMeasurementIncreases = depthMeasurements.countIncreases();

        Assertions.assertThat(numberOfTimesADepthMeasurementIncreases).isEqualTo(1387L);
    }
}
