package name.lemerdy.eric.dataMunging.football;

import com.google.common.base.CharMatcher;
import com.google.common.io.LineProcessor;
import lombok.Value;

import java.io.IOException;
import java.util.List;

import static com.google.common.base.Splitter.on;
import static com.google.common.collect.Lists.newArrayList;

@Value
public class FootballFileLineProcessor implements LineProcessor<List<TeamResult>> {

    List<TeamResult> result = newArrayList();

    @Override
    public boolean processLine(String line) throws IOException {
        List<String> datas = on(' ').omitEmptyStrings().trimResults(new CharMatcher() {
            @Override
            public boolean matches(char c) {
                return c == '-' || c == ' ';
            }
        }).splitToList(line);
        if (datas.isEmpty()) {
            return true;
        }
        String team = datas.get(1);
        try {
            Integer numberOfGoalsFor = Integer.valueOf(datas.get(6));
            Integer numberOfGoalsAgainst = Integer.valueOf(datas.get(7));
            return result.add(new TeamResult(team, numberOfGoalsFor, numberOfGoalsAgainst));
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
