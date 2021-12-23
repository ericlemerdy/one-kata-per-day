package name.eric.lemerdy.name.adventofcode.year2021.day01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class DepthMeasurementPartTwoTest {

    @Test
    public void should_count_sliding_window_example() {
        DepthMeasurements depthMeasurements = DepthMeasurements.builder().withMeasures(199, 200, 208, 210, 200, 207, 240, 269, 260, 263).build();

        long numberOfTimesADepthMeasurementIncreases = depthMeasurements.countSlidingWindowIncreases();

        Assertions.assertThat(numberOfTimesADepthMeasurementIncreases).isEqualTo(5L);
    }

    @Test
    public void should_count_sliding_window_input() throws IOException {
        DepthMeasurements depthMeasurements = DepthMeasurements.builder().withMeasuresFromPath(Paths.get("src/test/resources/input-day-01")).build();

        long numberOfTimesADepthMeasurementIncreases = depthMeasurements.countSlidingWindowIncreases();

        Assertions.assertThat(numberOfTimesADepthMeasurementIncreases).isEqualTo(1362L);
    }
}
