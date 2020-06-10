package name.lemerdy.eric.dataMunging.football;

import lombok.Value;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Value
public class SmallestGoalDifference {

    FootballFileReader footballFileReader;

    public Optional<String> teamWithMinimumGoalDifference() throws IOException {
        List<TeamResult> extrema = footballFileReader.readFile();
        return extrema.stream()
                .sorted()
                .findFirst()
                .map(TeamResult::getTeam);
    }
}
