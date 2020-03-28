package name.lemerdy.eric.dataMunging.football;

import lombok.Value;

import static java.lang.Integer.compare;
import static java.lang.Math.abs;

@Value
public class TeamResult implements Comparable {
    String team;
    int numberOfGoalsFor;
    int numberOfGoalsAgainst;

    @Override
    public int compareTo(Object o) {
        TeamResult other = (TeamResult) o;
        return compare(abs(numberOfGoalsFor - numberOfGoalsAgainst), abs(other.numberOfGoalsFor - other.numberOfGoalsAgainst));
    }
}
