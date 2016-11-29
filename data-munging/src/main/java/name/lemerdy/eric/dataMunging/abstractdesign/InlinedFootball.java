package name.lemerdy.eric.dataMunging.abstractdesign;

import name.lemerdy.eric.dataMunging.football.TeamResult;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import static java.util.Optional.empty;

public class InlinedFootball {
    public static String teamWithMinimumGoalDifference(URL footballFile) throws IOException {
        TeamResult teamResult = MinimumDifferenceInFile.minimum(footballFile, (datas) -> {
            String team = datas.get(1);
            try {
                Integer numberOfGoalsFor = Integer.valueOf(datas.get(6));
                Integer numberOfGoalsAgainst = Integer.valueOf(datas.get(7));
                return Optional.of(new TeamResult(team, numberOfGoalsFor, numberOfGoalsAgainst));
            } catch (NumberFormatException e) {
                return empty();
            }
        });
        return teamResult.getTeam();
    }

}
