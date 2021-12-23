package name.lemerdy.eric.dataMunging.abstractdesign;

import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;

public class InlinedFootballTest {

    @Test
    public void acceptance() throws IOException {
        URL footballFile = getResource("football.dat");

        Optional<String> teamWithMinimumGoalDifference = InlinedFootball.teamWithMinimumGoalDifference(footballFile);

        assertThat(teamWithMinimumGoalDifference).isPresent().hasValue("Aston_Villa");
    }

    @Test
    public void with_empty_file() throws IOException {
        URL footballFile = getResource("empty.dat");

        Optional<String> teamWithMinimumGoalDifference = InlinedFootball.teamWithMinimumGoalDifference(footballFile);

        assertThat(teamWithMinimumGoalDifference).isEmpty();
    }

}
