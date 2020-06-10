package name.lemerdy.eric.dataMunging.weather;

import lombok.Value;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Value
public class SmallestTemperatureSpread {

    WeatherFileReader weatherFileReader;

    public Optional<Integer> minTemperatureSpreadDay() throws IOException {
        List<TemperatureExtremum> extrema = weatherFileReader.readFile();
        return extrema.stream()
                .sorted()
                .findFirst()
                .map(TemperatureExtremum::getDay);
    }

}
