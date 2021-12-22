package name.eric.lemerdy.name.adventofcode.year2021.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DepthMeasurements {
    private final long[] depthMeasurements;

    public DepthMeasurements(final long[] depthMeasurements) {
        this.depthMeasurements = depthMeasurements;
    }

    public static DepthMeasurementsBuilder builder() {
        return new DepthMeasurementsBuilder();
    }

    public long countIncreases() {
        return countSlidingWindowIncreases(1);
    }

    public long countSlidingWindowIncreases() {
        return countSlidingWindowIncreases(3);
    }

    private long countSlidingWindowIncreases(final int slidingWindowSize) {
        final long[] slidingWindowSums = IntStream
                .range(0, this.depthMeasurements.length - slidingWindowSize + 1)
                .mapToLong(i -> IntStream.range(0, slidingWindowSize)
                        .mapToLong(j -> this.depthMeasurements[i + j])
                        .sum())
                .toArray();
        return IntStream
                .range(0, slidingWindowSums.length)
                .mapToObj(i -> {
                    if (i == 0) {
                        return MeasurementDifference.NA;
                    }
                    return MeasurementDifference.ofMeasurement(slidingWindowSums[i - 1], slidingWindowSums[i]);
                })
                .filter(measurementDifference -> measurementDifference == MeasurementDifference.INCREASED)
                .count();
    }

    public static class DepthMeasurementsBuilder {
        private long[] depthMeasurement;

        public DepthMeasurementsBuilder withMeasures(final long... depthMeasurement) {
            this.depthMeasurement = depthMeasurement;
            return this;
        }

        public DepthMeasurementsBuilder withMeasuresFromPath(final Path path) throws IOException {
            try (Stream<String> lines = Files.lines(path)) {
                this.depthMeasurement = lines.mapToLong(Long::parseLong).toArray();
            }
            return this;
        }

        public DepthMeasurements build() {
            return new DepthMeasurements(this.depthMeasurement);
        }
    }
}
