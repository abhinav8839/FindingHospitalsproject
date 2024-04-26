package cucumber.testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features= {".//Feature File"},
				  glue={"cucumberStepDefinitions"},
						  plugin= {"pretty", "html:reports/myCucumberReport.html", 
								  "rerun:target/rerun.txt",
							    	},
								
						dryRun=false,    // checks mapping between scenario steps and step definition methods
						monochrome=true,    // to avoid junk characters in output
						publish=true   // to publish report in cucumber server
				)

public class run {

}
