package in.reqres.utils.performance;


import com.intuit.karate.gatling.javaapi.KarateProtocolBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import static com.intuit.karate.gatling.javaapi.KarateDsl.*;
import static io.gatling.javaapi.core.CoreDsl.*;

//Rapidly increases load to find system limits.
public class UsersStressSimulation extends Simulation {

    public UsersStressSimulation() {
        KarateProtocolBuilder protocol = karateProtocol(uri("https://reqres.in").nil());
        ScenarioBuilder stress = scenario("Stress Test")
                .exec(karateFeature("classpath:in/reqres/users/users-get.feature"));
        setUp(stress.injectOpen(rampUsersPerSec(10).to(200).during(30)).protocols(protocol));
    }

}
