package name.lemerdy.eric.dataMunging.football;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class SmallestGoalDifferenceTest {

    @Mock
    FootballFileReader footballFileReader;

    @InjectMocks
    SmallestGoalDifference smallestGoalDifference;

    @Test
    public void should_find_team_with_the_smallest_goal_difference_in_football_league() throws IOException {
        List<TeamResult> footballLeagueResults = newArrayList(
                new TeamResult("Arsenal", 79, 36),
                new TeamResult("Liverpool", 67, 30));
        doReturn(footballLeagueResults).when(footballFileReader).readFile();

        Optional<String> teamWithMinimumGoalDifference = smallestGoalDifference.teamWithMinimumGoalDifference();

        assertThat(teamWithMinimumGoalDifference).hasValue("Liverpool");
    }

    @Test
    public void with_empty_file() throws IOException {
        URL footballFile = getResource("empty.dat");
        FootballFileLineProcessor footballFileLineProcessor = new FootballFileLineProcessor();
        FootballFileReader footballFileReader = new FootballFileReader(footballFile, footballFileLineProcessor);
        SmallestGoalDifference smallestGoalDifference = new SmallestGoalDifference(footballFileReader);

        Optional<String> teamWithMinimumGoalDifference = smallestGoalDifference.teamWithMinimumGoalDifference();

        assertThat(teamWithMinimumGoalDifference).isEmpty();
    }

    @Test
    public void acceptance() throws IOException {
        URL footballFile = getResource("football.dat");
        FootballFileLineProcessor footballFileLineProcessor = new FootballFileLineProcessor();
        FootballFileReader footballFileReader = new FootballFileReader(footballFile, footballFileLineProcessor);
        SmallestGoalDifference smallestGoalDifference = new SmallestGoalDifference(footballFileReader);

        Optional<String> teamWithMinimumGoalDifference = smallestGoalDifference.teamWithMinimumGoalDifference();

        assertThat(teamWithMinimumGoalDifference).hasValue("Aston_Villa");
    }
}