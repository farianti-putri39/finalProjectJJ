package stepDef;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.*;
import io.cucumber.plugin.event.Node;

import java.util.Objects;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;

public class Hooks {

    String tagsRunning = null;

    @BeforeAll
    public static void setUp(){
    }

    @AfterAll
    public static void tearDown(){

    }

    @Before
    public void beforeTest(Scenario scenario){
        System.out.println("Before Test");

        String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
        tagsRunning = tags[0];
        if (Objects.equals(tagsRunning, "@web")){
            startDriver();
        }
    }

    @After
    public void afterTest() throws InterruptedException {
        if (Objects.equals(tagsRunning, "@web")) {
            quitDriver();
        }
    }
}
