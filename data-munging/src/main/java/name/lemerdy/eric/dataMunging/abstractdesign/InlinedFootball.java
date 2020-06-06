package name.lemerdy.eric.dataMunging.abstractdesign;

import name.lemerdy.eric.dataMunging.football.TeamResult;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import static java.util.Optional.empty;

public class InlinedFootball {
    public static Optional<String> teamWithMinimumGoalDifference(URL footballFile) throws IOException {
        Optional<TeamResult> teamResult = MinimumDifferenceInFile.minimum(footballFile, (datas) -> {
            String team = datas.get(1);
            try {
                int numberOfGoalsFor = Integer.parseInt(datas.get(6));
                int numberOfGoalsAgainst = Integer.parseInt(datas.get(7));
                return Optional.of(new TeamResult(team, numberOfGoalsFor, numberOfGoalsAgainst));
            } catch (NumberFormatException e) {
                return empty();
            }
        });
        return teamResult.map(TeamResult::getTeam);
    }

}
