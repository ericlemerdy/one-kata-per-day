package name.lemerdy.eric.dataMunging.weather;

import lombok.Value;

@Value
public class TemperatureExtremum implements Comparable {
    int day;
    int max;
    int min;

    @Override
    public int compareTo(Object o) {
        TemperatureExtremum other = (TemperatureExtremum) o;
        return new Integer((max - min))
                .compareTo(new Integer(other.max - other.min));
    }
}




