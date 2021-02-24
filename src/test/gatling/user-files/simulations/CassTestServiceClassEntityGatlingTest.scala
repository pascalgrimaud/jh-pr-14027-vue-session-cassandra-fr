import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the CassTestServiceClassEntity entity.
 */
class CassTestServiceClassEntityGatlingTest extends Simulation {

    val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    // Log all HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
    // Log failed HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("DEBUG"))

    val baseURL = Option(System.getProperty("baseURL")) getOrElse """http://localhost:8080"""

    val httpConf = http
        .baseUrl(baseURL)
        .inferHtmlResources()
        .acceptHeader("*/*")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
        .connectionHeader("keep-alive")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:33.0) Gecko/20100101 Firefox/33.0")
        .silentResources // Silence all resources like css or css so they don't clutter the results

    val headers_http = Map(
        "Accept" -> """application/json"""
    )

    val headers_http_authenticated = Map(
        "Accept" -> """application/json""",
        "X-XSRF-TOKEN" -> "${xsrf_token}"
    )

    val keycloakHeaders = Map(
        "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        "Upgrade-Insecure-Requests" -> "1"
    )

    val scn = scenario("Test the CassTestServiceClassEntity entity")
        .exec(http("First unauthenticated request")
        .get("/api/account")
        .headers(headers_http)
        .check(status.is(401))
        .check(headerRegex("Set-Cookie", "XSRF-TOKEN=(.*);[\\s]").saveAs("xsrf_token"))
        ).exitHereIfFailed
        .pause(10)
        .exec(http("Authentication")
        .post("/api/authentication")
        .headers(headers_http_authenticated)
        .formParam("username", "admin")
        .formParam("password", "admin")
        .formParam("remember-me", "true")
        .formParam("submit", "Login")
        .check(headerRegex("Set-Cookie", "XSRF-TOKEN=(.*);[\\s]").saveAs("xsrf_token"))).exitHereIfFailed
        .pause(2)
        .exec(http("Authenticated request")
        .get("/api/account")
        .headers(headers_http_authenticated)
        .check(status.is(200)))
        .pause(10)
        .repeat(2) {
            exec(http("Get all cassTestServiceClassEntities")
            .get("/api/cass-test-service-class-entities")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new cassTestServiceClassEntity")
            .post("/api/cass-test-service-class-entities")
            .headers(headers_http_authenticated)
            .body(StringBody("""{
                "id":null
                , "stringField":"SAMPLE_TEXT"
                , "stringRequiredField":"SAMPLE_TEXT"
                , "stringMinlengthField":"SAMPLE_TEXT"
                , "stringMaxlengthField":"SAMPLE_TEXT"
                , "stringPatternField":"SAMPLE_TEXT"
                , "integerField":"0"
                , "integerRequiredField":"0"
                , "integerMinField":"0"
                , "integerMaxField":"0"
                , "longField":null
                , "longRequiredField":null
                , "longMinField":null
                , "longMaxField":null
                , "floatField":null
                , "floatRequiredField":null
                , "floatMinField":null
                , "floatMaxField":null
                , "doubleRequiredField":null
                , "doubleMinField":null
                , "doubleMaxField":null
                , "bigDecimalRequiredField":"0"
                , "bigDecimalMinField":"0"
                , "bigDecimalMaxField":"0"
                , "localDateField":"2020-01-01T00:00:00.000Z"
                , "localDateRequiredField":"2020-01-01T00:00:00.000Z"
                , "instantDateField":"2020-01-01T00:00:00.000Z"
                , "instantRequiredField":"2020-01-01T00:00:00.000Z"
                , "zonedDateTimeField":"2020-01-01T00:00:00.000Z"
                , "zonedDateTimeRequiredField":"2020-01-01T00:00:00.000Z"
                , "durationDateField":null
                , "durationRequiredField":null
                , "booleanField":null
                , "booleanRequiredField":null
                , "enumTom":"ENUM_VALUE_1"
                , "enumRequiredTom":"ENUM_VALUE_1"
                , "picture":null
                , "operationsFile":null
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_cassTestServiceClassEntity_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created cassTestServiceClassEntity")
                .get("${new_cassTestServiceClassEntity_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created cassTestServiceClassEntity")
            .delete("${new_cassTestServiceClassEntity_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
