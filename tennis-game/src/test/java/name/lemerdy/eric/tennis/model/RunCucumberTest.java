package name.lemerdy.eric.tennis.model;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("name/lemerdy/eric/tennis/model")
public class RunCucumberTest {}
