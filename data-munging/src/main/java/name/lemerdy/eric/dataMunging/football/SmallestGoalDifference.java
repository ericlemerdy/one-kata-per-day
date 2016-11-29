package name.lemerdy.eric.dataMunging.football;

import lombok.Value;

import java.io.IOException;
import java.util.List;

@Value
public class SmallestGoalDifference {

    FootballFileReader footballFileReader;

    public String teamWithMinimumGoalDifference() throws IOException {
        List<TeamResult> extrema = footballFileReader.readFile();
        return extrema.stream()
                .sorted()
                .findFirst()
                .get()
                .getTeam();
    }
}
