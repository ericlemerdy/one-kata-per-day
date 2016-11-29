package name.lemerdy.eric.dataMunging.football;

import lombok.Value;
import lombok.experimental.NonFinal;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.io.Resources.readLines;

@Value
@NonFinal
public class FootballFileReader {

    URL footballFile;

    FootballFileLineProcessor footballFileLineProcessor;

    public List<TeamResult> readFile() throws IOException {
        return readLines(footballFile, UTF_8, footballFileLineProcessor);
    }

}
