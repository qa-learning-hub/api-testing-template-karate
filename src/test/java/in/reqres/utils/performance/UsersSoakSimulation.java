package in.reqres.utils.performance;


import com.intuit.karate.gatling.javaapi.KarateProtocolBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import static com.intuit.karate.gatling.javaapi.KarateDsl.*;
import static io.gatling.javaapi.core.CoreDsl.*;

//Sustained moderate load over a long period.
public class UsersSoakSimulation extends Simulation {

    public UsersSoakSimulation() {
        KarateProtocolBuilder protocol = karateProtocol(uri("https://reqres.in").nil());
        ScenarioBuilder soak = scenario("Soak Test")
                .exec(karateFeature("classpath:in/reqres/users/users-get.feature"));
        setUp(soak.injectOpen(constantUsersPerSec(20).during(1800)).protocols(protocol)); // 30 min
    }

}
