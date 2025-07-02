package in.reqres.utils.performance;


import com.intuit.karate.gatling.javaapi.KarateProtocolBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import static com.intuit.karate.gatling.javaapi.KarateDsl.*;
import static io.gatling.javaapi.core.CoreDsl.*;

//Simulates expected average load.
public class UsersLoadSimulation extends Simulation {

    public UsersLoadSimulation() {
        KarateProtocolBuilder protocol = karateProtocol(uri("https://reqres.in").nil());
        ScenarioBuilder load = scenario("Load Test")
                .exec(karateFeature("classpath:in/reqres/users/users-get.feature"));
        setUp(load.injectOpen(rampUsers(50).during(60)).protocols(protocol)); // 50 users over 1 min
    }

}
