package computerdatabase;

// static methods & objects from Gatling's Core DSL and HTTP DSL to use scenario(),
// http(), and constantUsersPerSec() without needing to prefix them.
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

// import classes from Gatling's Core and HTTP Java API libraries to create protocols,
// scenarios, and simulations.
import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

// Simulation is the base class required for all Gatling simulation scripts.
public class ComputerDatabaseSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol =
            http.baseUrl("https://computer-database.gatling.io")
                    // set the "accept" header to a value suited for the expected response
                    .acceptHeader("text/html");

//    ScenarioBuilder myScenario = scenario("My Scenario")
//            .exec(
//                    http("Request 1").get("/computers/")
//            );

FeederBuilder<String> feeder = csv("computer_ids.json").circular();

    // Define the scenario using the feeder
    ScenarioBuilder myScenario = scenario("My Scenario with Feeders")
            .feed(feeder) // Inject data from the feeder into the scenario
            .exec(
                    http("Get Computer by ID")
                            .get("/computers/#{id}") // Use the "id" field from the feeder
                            .check(status().is(200))
            );

    // Add the setUp block:
    {
        setUp(
                myScenario.injectOpen(constantUsersPerSec(2).during(60)) // Injection profile: 120 VUs
        ).protocols(httpProtocol); // attaches previously defined httpProtocol to this scenario.
    }
}