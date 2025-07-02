package in.reqres.utils.performance;


import com.intuit.karate.gatling.javaapi.KarateProtocolBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import static com.intuit.karate.gatling.javaapi.KarateDsl.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;

//Sudden spike, then sustained high load
public class UsersPeakSimulation extends Simulation {

    public UsersPeakSimulation() {
        KarateProtocolBuilder protocol = karateProtocol(uri("https://reqres.in").nil());
        ScenarioBuilder peak = scenario("Peak Test")
                .exec(karateFeature("classpath:in/reqres/users/users-get.feature"));
        setUp(peak.injectOpen(
                atOnceUsers(100),
                constantUsersPerSec(100).during(60)
        ).protocols(protocol));
    }

}
