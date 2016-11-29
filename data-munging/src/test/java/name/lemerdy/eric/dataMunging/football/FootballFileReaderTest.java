package name.lemerdy.eric.dataMunging.football;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;

public class FootballFileReaderTest {

    @Test
    public void should_read_football_dat_file() throws IOException {
        URL footballFile = getResource("football.dat");
        FootballFileReader footballFileReader = new FootballFileReader(footballFile, new FootballFileLineProcessor());

        List<TeamResult> teamResults = footballFileReader.readFile();

        assertThat(teamResults).contains(new TeamResult("Derby", 33, 63));
    }

}