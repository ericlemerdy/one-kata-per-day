package name.eric.lemerdy.name.adventofcode.year2021.day01;

public enum MeasurementDifference {
    NA, INCREASED, DECREASED, NO_CHANGE;

    public static MeasurementDifference ofMeasurement(long previousMeasurement, long actualMeasurement) {
        if (previousMeasurement == actualMeasurement) {
            return MeasurementDifference.NO_CHANGE;
        }
        if (previousMeasurement < actualMeasurement) {
            return MeasurementDifference.INCREASED;
        }
        return MeasurementDifference.DECREASED;
    }
}
