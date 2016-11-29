package name.lemerdy.eric.dataMunging.weather;

import lombok.Value;

import java.io.IOException;
import java.util.List;

@Value
public class SmallestTemperatureSpread {

    WeatherFileReader weatherFileReader;

    public Integer minTemperatureSpreadDay() throws IOException {
        List<TemperatureExtremum> extrema = weatherFileReader.readFile();
        return extrema.stream()
                .sorted()
                .findFirst()
                .get()
                .getDay();
    }

}
