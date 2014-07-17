package name.lemerdy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamAPILearning {

    @Test
    public void should_split() throws Exception {
        String listAsString = "foo;bar;qix";

        List<String> list = asList(listAsString.split(";"));

        assertThat(list).contains("foo", "bar", "qix");
    }

    @Test
    public void should_transform() throws Exception {
        List<String> list = Arrays.asList("foo", "bar", "qix");

        String uppercasedJoinedList = list
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce("", (s, s2) -> (s.length() > 0) ? s + ";" + s2 : s2);

        assertThat(uppercasedJoinedList).isEqualTo("Foo;Bar;Qix");
    }
}
