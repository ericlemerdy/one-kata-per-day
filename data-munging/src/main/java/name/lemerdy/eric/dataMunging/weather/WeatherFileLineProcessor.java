package name.lemerdy.eric.dataMunging.weather;

import com.google.common.io.LineProcessor;
import lombok.Value;

import java.io.IOException;
import java.util.List;

import static com.google.common.base.Splitter.on;
import static com.google.common.collect.Lists.newArrayList;

@Value
public class WeatherFileLineProcessor implements LineProcessor<List<TemperatureExtremum>> {

    List<TemperatureExtremum> result = newArrayList();

    @Override
    public boolean processLine(String line) throws IOException {
        List<String> numericData = on(' ').omitEmptyStrings().trimResults().splitToList(line);
        if (numericData.isEmpty()) {
            return true;
        }
        try {
            Integer day = Integer.valueOf(numericData.get(0));
            Integer max = Integer.valueOf(numericData.get(1));
            Integer min = Integer.valueOf(numericData.get(2));
            return result.add(new TemperatureExtremum(day, max, min));
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
