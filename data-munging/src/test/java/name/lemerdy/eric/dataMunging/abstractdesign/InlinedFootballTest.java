package name.lemerdy.eric.dataMunging.abstractdesign;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;

public class InlinedFootballTest {

    @Test
    public void acceptance() throws IOException {
        URL footballFile = getResource("football.dat");

        String teamWithMinimumGoalDifference = InlinedFootball.teamWithMinimumGoalDifference(footballFile);

        assertThat(teamWithMinimumGoalDifference).isEqualTo("Aston_Villa");
    }

}
