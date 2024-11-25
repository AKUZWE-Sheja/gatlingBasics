package io.gatling.demo;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://computer-database.gatling.io")
    .inferHtmlResources()
    .acceptHeader("text/css,*/*;q=0.1")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7")
    .userAgentHeader("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Mobile Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("priority", "u=0, i"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "document"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "same-origin"),
    Map.entry("sec-fetch-user", "?1"),
    Map.entry("upgrade-insecure-requests", "1")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("priority", "u=0"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "style"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_3 = Map.ofEntries(
    Map.entry("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("origin", "https://computer-database.gatling.io"),
    Map.entry("priority", "u=0, i"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "document"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "same-origin"),
    Map.entry("sec-fetch-user", "?1"),
    Map.entry("upgrade-insecure-requests", "1")
  );


//  our scenario is called RecordedSimulation
//  U'll need to edit the codes sightly to make them more meaningful
  private ScenarioBuilder scn = scenario("RecordedSimulation")
    .exec(
      http("LOAD_NEW_COMP_PAGE")
        .get("/computers/new")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get("/assets/css/bootstrap.min.css")
            .headers(headers_1),
          http("request_2")
            .get("/assets/css/main.css")
            .headers(headers_1)
        ),
//      created a computer with the following params
      pause(1),
      http("CREATE_NEW_COMP")
        .post("/computers")
        .headers(headers_3)
        .formParam("name", "abc1234")
        .formParam("introduced", "2018-01-01")
        .formParam("discontinued", "2019-01-01")
        .formParam("company", "1")
        .resources(
          http("request_4")
            .get("/assets/css/bootstrap.min.css")
            .headers(headers_1),
          http("request_5")
            .get("/assets/css/main.css")
            .headers(headers_1)
        ),
//      searched for computer 1234
      pause(1),
      http("SEARCH_COMP")
        .get("/computers?f=abc1234")
        .headers(headers_0)
        .resources(
          http("request_7")
            .get("/assets/css/bootstrap.min.css")
            .headers(headers_1),
          http("request_8")
            .get("/assets/css/main.css")
            .headers(headers_1)
        )
    );

  {
//    Load profile
//    We can see that this one is running with only 1 user :)
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
