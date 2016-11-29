package name.lemerdy.eric.dataMunging.football;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
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

        String teamWithMinimumGoalDifference = smallestGoalDifference.teamWithMinimumGoalDifference();

        assertThat(teamWithMinimumGoalDifference).isEqualTo("Liverpool");
    }

    @Test
    public void acceptance() throws IOException {
        URL footballFile = getResource("football.dat");
        FootballFileLineProcessor footballFileLineProcessor = new FootballFileLineProcessor();
        FootballFileReader footballFileReader = new FootballFileReader(footballFile, footballFileLineProcessor);
        SmallestGoalDifference smallestGoalDifference = new SmallestGoalDifference(footballFileReader);

        String teamWithMinimumGoalDifference = smallestGoalDifference.teamWithMinimumGoalDifference();

        assertThat(teamWithMinimumGoalDifference).isEqualTo("Aston_Villa");
    }
}