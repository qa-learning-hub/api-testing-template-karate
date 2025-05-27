package examples.performance;


import com.intuit.karate.gatling.javaapi.KarateProtocolBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import static com.intuit.karate.gatling.javaapi.KarateDsl.*;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class UsersSimulation  extends Simulation {

    public UsersSimulation() {

        KarateProtocolBuilder protocol = karateProtocol(
                uri("/api/users?page=2").nil()
        );

        ScenarioBuilder main = scenario("main").exec(karateFeature("classpath:examples/users/users.feature"));

        setUp(
                main.injectOpen(rampUsers(10).during(5)).protocols(protocol)
        );
    }

}
