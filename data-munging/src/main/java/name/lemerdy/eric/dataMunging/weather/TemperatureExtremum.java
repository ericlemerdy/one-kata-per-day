package name.lemerdy.eric.dataMunging.weather;

import lombok.Value;

import static java.lang.Integer.compare;

@Value
public class TemperatureExtremum implements Comparable {
    int day;
    int max;
    int min;

    @Override
    public int compareTo(Object o) {
        TemperatureExtremum other = (TemperatureExtremum) o;
        return compare(max - min, other.max - other.min);
    }
}




