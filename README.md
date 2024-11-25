* # Gatling Simulation - Java Demo Project
============================================

A simple showcase of a Java project using Gatling for simulating REST API interactions. This project demonstrates how to set up and run performance tests on a REST API.

Refer to the plugin documentation [on the Gatling website](https://docs.gatling.io/reference/integrations/build-tools/maven-plugin/) for usage.

This project is written in Java, others are available for [Kotlin](https://github.com/gatling/gatling-maven-plugin-demo-kotlin)
and [Scala](https://github.com/gatling/gatling-maven-plugin-demo-scala).

## Overview
This project includes scenarios for loading Swagger UI, managing activities, and fetching computer details from a database. It captures various HTTP requests and responses to evaluate the performance of the API.

## Components
This project includes:

* **Maven Wrapper**: So you can immediately run Maven with `./mvnw` without having to install it on your computer.
* **Minimal `pom.xml`**: Configured for Gatling dependencies.
* **Latest version of `io.gatling:gatling-java-api`**: Applied for Java-based simulations.
* **Sample Simulation Classes**:
  - `RestApiRecordedSimulation`: Demonstrates interactions with a REST API.
  - `ComputerDatabaseSimulation`: Utilizes a feeder to dynamically inject data into the scenario.
* **Proper Source File Layout**: Organized structure for easy navigation and understanding.

## Usage
To get started with the simulation, clone the repository and run the following command:

```bash
git clone https://github.com/yourusername/simulation-project.git
cd simulation-project
./mvnw gatling:test
```

## Example Code

### RestApiRecordedSimulation
```java
public class RestApiRecordedSimulation extends Simulation {
    private HttpProtocolBuilder httpProtocol = http
        .baseUrl("https://fakerestapi.azurewebsites.net")
        .inferHtmlResources()
        .userAgentHeader("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Mobile Safari/537.36");

    private ScenarioBuilder scn = scenario("RestApiRecordedSimulation")
        .exec(
            http("LOAD_SWAGGER_PAGE")
                .get("/swagger-ui.css")
                .headers(headers_0)
                .resources(
                    http("request_1").get("/swagger-ui-standalone-preset.js").headers(headers_0),
                    http("request_2").get("/swagger-ui-bundle.js").headers(headers_0),
                    http("request_3").get("/index.html").headers(headers_3),
                    http("request_4").get("/favicon-32x32.png").headers(headers_0)
                ),
            pause(2),
            http("LOAD_ALL_ACTIVITIES")
                .get("/api/v1/Activities")
                .headers(headers_7),
            pause(6),
            http("POST_NEW_ACTIVITIES")
                .post("/api/v1/Activities")
                .headers(headers_8)
                .body(RawFileBody("io/gatling/demo/restapirecordedsimulation/0008_request.json"))
        );

    {
        setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
    }
}
```

### ComputerDatabaseSimulation
```java
public class ComputerDatabaseSimulation extends Simulation {
    HttpProtocolBuilder httpProtocol = http.baseUrl("https://computer-database.gatling.io").acceptHeader("text/html");

    FeederBuilder<String> feeder = csv("computer_ids.json").circular();

    ScenarioBuilder myScenario = scenario("My Scenario with Feeders")
        .feed(feeder)
        .exec(
            http("Get Computer by ID")
                .get("/computers/#{id}")
                .check(status().is(200))
        );

    {
        setUp(myScenario.injectOpen(constantUsersPerSec(2).during(60))).protocols(httpProtocol);
    }
}
```

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

## License
This project is licensed under the [Your License Name] License - see the [LICENSE](LICENSE) file for details.

