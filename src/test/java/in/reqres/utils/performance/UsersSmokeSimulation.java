package in.reqres.utils.performance;


import com.intuit.karate.gatling.javaapi.KarateProtocolBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import static com.intuit.karate.gatling.javaapi.KarateDsl.*;
import static io.gatling.javaapi.core.CoreDsl.*;
//low-load test to verify basic functionality.
public class UsersSmokeSimulation extends Simulation {

    public UsersSmokeSimulation() {
        KarateProtocolBuilder protocol = karateProtocol(uri("https://reqres.in").nil());
        ScenarioBuilder smoke = scenario("Smoke Test")
                .exec(karateFeature("classpath:in/reqres/users/users-get.feature"));
        setUp(smoke.injectOpen(atOnceUsers(1)).protocols(protocol));
    }

}
