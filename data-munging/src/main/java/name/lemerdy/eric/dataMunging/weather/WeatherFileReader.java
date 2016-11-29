package name.lemerdy.eric.dataMunging.weather;

import lombok.Value;
import lombok.experimental.NonFinal;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.io.Resources.readLines;

@Value
@NonFinal
public class WeatherFileReader {

    URL weatherFile;

    WeatherFileLineProcessor weatherFileLineProcessor;

    public List<TemperatureExtremum> readFile() throws IOException {
        return readLines(weatherFile, UTF_8, weatherFileLineProcessor);
    }

}
