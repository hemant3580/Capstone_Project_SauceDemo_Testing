package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.Common;

public class Hooks {
 
    @After
    public void tearDown() {
        Common.quitDriver();
    }
}
