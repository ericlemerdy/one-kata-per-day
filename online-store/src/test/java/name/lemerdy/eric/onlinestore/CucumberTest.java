package name.lemerdy.eric.onlinestore;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("name/lemerdy/eric/onlinestore")
public class CucumberTest {
    @Test
    public void start() {
        
    }
}
