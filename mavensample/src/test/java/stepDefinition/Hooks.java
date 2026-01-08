package stepDefinition;

import coreUtils.BaseClass;
import io.cucumber.java.After;

public class Hooks {
	
	
    // Assuming driver is initialized in a @Before hook or shared via Dependency Injection
    @After
    public void closeBrowser() {
        BaseClass baseclass = new BaseClass();
        baseclass.tearDown();
    }

}
