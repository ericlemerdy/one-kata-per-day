package name.lemerdy.eric.dataMunging.abstractdesign;

import name.lemerdy.eric.dataMunging.weather.TemperatureExtremum;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import static java.util.Optional.empty;

public class InlinedWeather {
    public static Optional<Integer> minTemperatureSpreadDay(URL weatherFile) throws IOException {
        Optional<TemperatureExtremum> temperatureExtremum = MinimumDifferenceInFile.minimum(weatherFile, datas -> {
            try {
                Integer day = Integer.valueOf(datas.get(0));
                Integer max = Integer.valueOf(datas.get(1));
                Integer min = Integer.valueOf(datas.get(2));
                return Optional.of(new TemperatureExtremum(day, max, min));
            } catch (NumberFormatException e) {
                return empty();
            }
        });
        return temperatureExtremum.map(TemperatureExtremum::getDay);
    }

}
