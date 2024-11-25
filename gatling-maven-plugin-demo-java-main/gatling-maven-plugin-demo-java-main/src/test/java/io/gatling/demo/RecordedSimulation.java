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
    .baseUrl("https://news.sky.com")
    .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Mobile Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android")
  );
  
  private Map<CharSequence, String> headers_4 = Map.ofEntries(
    Map.entry("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7"),
    Map.entry("priority", "u=0, i"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "document"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "none"),
    Map.entry("sec-fetch-user", "?1"),
    Map.entry("upgrade-insecure-requests", "1")
  );
  
  private Map<CharSequence, String> headers_5 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7"),
    Map.entry("priority", "u=1"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "script"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_10 = Map.ofEntries(
    Map.entry("Origin", "https://news.sky.com"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android")
  );
  
  private Map<CharSequence, String> headers_13 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "script"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_15 = Map.ofEntries(
    Map.entry("Accept", "*/*"),
    Map.entry("Accept-Encoding", "gzip, deflate, br, zstd"),
    Map.entry("Accept-Language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7"),
    Map.entry("If-Modified-Since", "Wed, 14 Mar 2018 14:45:21 GMT"),
    Map.entry("If-None-Match", "cf46209fa5b536683955ba58bf9da27f"),
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-site"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android")
  );
  
  private Map<CharSequence, String> headers_17 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7"),
    Map.entry("origin", "https://news.sky.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_18 = Map.ofEntries(
    Map.entry("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7"),
    Map.entry("priority", "u=2, i"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "image"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_19 = Map.ofEntries(
    Map.entry("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7"),
    Map.entry("priority", "i"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "image"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_21 = Map.ofEntries(
    Map.entry("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "image"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_51 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_62 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7"),
    Map.entry("access-control-request-headers", "authorization"),
    Map.entry("access-control-request-method", "GET"),
    Map.entry("origin", "https://news.sky.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_64 = Map.ofEntries(
    Map.entry("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7"),
    Map.entry("priority", "i"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "image"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "same-origin")
  );
  
  private String uri1 = "https://assets.adobedtm.com";
  
  private String uri2 = "https://e3.365dm.com";
  
  private String uri3 = "https://cdn.privacy-mgmt.com";
  
  private String uri5 = "https://analytics.global.sky.com/sky-tags/news/prod/sky-tags-without-adobe.min.js";
  
  private String uri6 = "https://e0.365dm.com/skynews/apple-touch-icon.png";
  
  private String uri7 = "https://rm-script.dotmetrics.net/hit.gif";
  
  private String uri8 = "https://api.condatis.sky/weather/GetWeather/51782";
  
  private String uri9 = "https://uk-script.dotmetrics.net";

  private ScenarioBuilder scn = scenario("RecordedSimulation")
    .exec(
      http("request_0")
        .get("/css/min/index-ad2aec742852c586114334177642b6d6.css")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get("/css/min/theme-dark-mode-4fbc993da59aabd1e70315250d17e0d7.css")
            .headers(headers_0),
          http("request_2")
            .get("/resources/sky-news-logo.svg?v=1")
            .headers(headers_0),
          http("request_3")
            .get("/resources/sky-news-logo-dark.svg?v=1")
            .headers(headers_0),
          http("request_4")
            .get("/")
            .headers(headers_4),
          http("request_5")
            .get(uri1 + "/launch-ENdec3197734dd4b629a9283183faf094b.min.js")
            .headers(headers_5),
          http("request_6")
            .get(uri2 + "/24/11/768x432/skynews-strike-ukraine-russia_6753668.jpg?20241121125235")
            .headers(headers_0),
          http("request_7")
            .get("/js/vendor/require.2.3.2.min.js")
            .headers(headers_0),
          http("request_8")
            .get(uri2 + "/24/11/768x432/skynews-donald-trump-president-elect_6754145.jpg?20241121225208")
            .headers(headers_0),
          http("request_9")
            .get("/resources/sky-spectrum-logo.png")
            .headers(headers_0),
          http("request_10")
            .get("/resources/fonts/sky-regular.woff")
            .headers(headers_10),
          http("request_11")
            .get("/resources/fonts/sky-medium.woff")
            .headers(headers_10),
          http("request_12")
            .get("/resources/fonts/sky-headline-semi-bold.woff")
            .headers(headers_10),
          http("request_13")
            .get(uri1 + "/extensions/EPa06d4a70bf964e93808ee073533d9238/AppMeasurement.min.js")
            .headers(headers_13),
          http("request_14")
            .get(uri1 + "/extensions/EPa06d4a70bf964e93808ee073533d9238/AppMeasurement_Module_ActivityMap.min.js")
            .headers(headers_13),
          http("request_15")
            .get(uri5)
            .headers(headers_15),
          http("request_16")
            .get(uri3 + "/unified/wrapperMessagingWithoutDetection.js")
            .headers(headers_13),
          http("request_17")
            .get(uri3 + "/wrapper/v2/meta-data?hasCsp=true&accountId=630&env=prod&metadata=%7B%22gdpr%22%3A%7B%7D%7D&propertyId=2371&scriptVersion=4.27.2&scriptType=unified")
            .headers(headers_17),
          http("request_18")
            .get(uri2 + "/24/10/768x432/skynews-assisted-dying-protests_6713282.jpg?20241011120927")
            .headers(headers_18),
          http("request_19")
            .get(uri2 + "/24/11/768x432/skynews-money-eggs_6756676.jpg?20241124144957")
            .headers(headers_19),
          http("request_20")
            .get(uri2 + "/24/11/384x216/skynews-cyber-attack-russia_6757046.jpg?20241124192855")
            .headers(headers_19),
          http("request_21")
            .get(uri2 + "/24/11/768x432/skynews-storm-bert-weather_6757121.jpg?20241124221302")
            .headers(headers_21),
          http("request_22")
            .get(uri3 + "/wrapper/v2/messages?hasCsp=true&env=prod&body=%7B%22accountId%22%3A630%2C%22campaignEnv%22%3A%22prod%22%2C%22campaigns%22%3A%7B%22gdpr%22%3A%7B%22consentStatus%22%3A%7B%22hasConsentData%22%3Atrue%2C%22consentedToAll%22%3Afalse%2C%22consentedToAny%22%3Atrue%2C%22rejectedAny%22%3Atrue%7D%2C%22hasLocalData%22%3Atrue%2C%22targetingParams%22%3A%7B%7D%7D%7D%2C%22clientMMSOrigin%22%3A%22https%3A%2F%2Fcdn.privacy-mgmt.com%22%2C%22hasCSP%22%3Atrue%2C%22includeData%22%3A%7B%22localState%22%3A%7B%22type%22%3A%22string%22%7D%2C%22actions%22%3A%7B%22type%22%3A%22RecordString%22%7D%2C%22cookies%22%3A%7B%22type%22%3A%22RecordString%22%7D%7D%2C%22propertyHref%22%3A%22https%3A%2F%2Fnews.sky.com%2F%22%2C%22propertyId%22%3A2371%7D&localState=%7B%22gdpr%22%3A%7B%22mmsCookies%22%3A%5B%22_sp_v1_ss%3D1%3AH4sIAAAAAAAAAItWqo5RKimOUbKKJoKRV5qToxOjlIrELgFLVNfWxtJBQkmHGOfSyZXEOQaFkQdiGNAlqIZBGFLXDfS0KhYAlexT8VcDAAA%253D%22%5D%2C%22propertyId%22%3A2371%2C%22messageId%22%3A0%7D%7D&metadata=%7B%22gdpr%22%3A%7B%22applies%22%3Atrue%7D%7D&nonKeyedLocalState=%7B%22gdpr%22%3A%7B%22_sp_v1_data%22%3A%221021055%22%2C%22_sp_v1_p%22%3A%2246%22%7D%7D&ch=4696014734696014733a85&scriptVersion=4.27.2&scriptType=unified")
            .headers(headers_17),
          http("request_23")
            .get(uri2 + "/24/11/384x216/skynews-soldier-russia-ukraine_6757138.png?20241124230053")
            .headers(headers_19),
          http("request_24")
            .get(uri2 + "/24/11/384x216/skynews-assisted-dying-health_6754443.jpg?20241122111736")
            .headers(headers_19),
          http("request_25")
            .get(uri2 + "/24/11/384x216/skynews-westminster-stabbing_6756551.jpg?20241124125411")
            .headers(headers_19),
          http("request_26")
            .get(uri2 + "/24/01/384x216/skynews-adele-grammy_6439503.jpg?20240131165135")
            .headers(headers_19),
          http("request_27")
            .get(uri3 + "/unified/4.27.2/gdpr-tcf.00cd3b6a2692e330e4ec.bundle.js")
            .headers(headers_13),
          http("request_28")
            .get(uri1 + "/eee7eee0aaaa/b6a2aeea252d/788fe3c6264f/RC460952a0931d4c4d98665d61369a346b-source.min.js")
            .headers(headers_13),
          http("request_29")
            .get("/resources/favicon.ico?v=2")
            .headers(headers_0),
          http("request_30")
            .get("/js/min/site-main-cdc906be6e1c2da545e1993e19611e64.js")
            .headers(headers_0),
          http("request_31")
            .get(uri2 + "/24/11/384x216/skynews-shabana-mahmood-justice_6756107.jpg?20241123202025")
            .headers(headers_0),
          http("request_32")
            .get(uri2 + "/24/11/384x216/skynews-assisted-dying-euthansia_6746051.jpg?20241111174046")
            .headers(headers_0),
          http("request_33")
            .get(uri2 + "/24/11/384x216/skynews-turkey-fire-airplane_6757153.jpg?20241125022213")
            .headers(headers_19),
          http("request_34")
            .get(uri9 + "/door.js?d=news.sky.com&t=other")
            .headers(headers_13),
          http("request_35")
            .get(uri2 + "/24/11/384x216/skynews-chancellor-rachel-reeves_6749159.jpg?20241124225413")
            .headers(headers_19),
          http("request_36")
            .get(uri2 + "/24/11/384x216/skynews-paper-review-newspapers_6757118.jpg?20241124215916")
            .headers(headers_19),
          http("request_37")
            .get(uri2 + "/22/01/384x216/skynews-spiking-drinks-istock_5639345.jpg?20220112130951")
            .headers(headers_19),
          http("request_38")
            .get(uri2 + "/24/11/384x216/skynews-kim-leadbeater-assisted-dying_6756515.jpg?20241124151438")
            .headers(headers_19),
          http("request_39")
            .get(uri2 + "/24/11/384x216/skynews-sophie-blake-assisted-dying_6756488.jpg?20241124112451")
            .headers(headers_19),
          http("request_40")
            .get(uri2 + "/24/11/384x216/skynews-wales-floods_6756966.jpg?20241124180228")
            .headers(headers_19),
          http("request_41")
            .get(uri2 + "/24/11/384x216/skynews-ashish-joshi-vt-grab_6757159.jpg?20241125035027")
            .headers(headers_19),
          http("request_42")
            .get(uri2 + "/24/11/384x216/skynews-pride-india-gay-rights_6756941.jpg?20241124175530")
            .headers(headers_19),
          http("request_43")
            .get(uri2 + "/24/11/384x216/skynews-floods-storm-bert-baby_6756893.jpg?20241124171423")
            .headers(headers_19),
          http("request_44")
            .get(uri2 + "/24/11/384x216/skynews-ilford-london-storm-bert_6756749.jpg?20241124152947")
            .headers(headers_19),
          http("request_45")
            .get("/js/min/ui-liveblog-mini-88416ec5ddca3f975b98fa8357dbedc1.js")
            .headers(headers_0),
          http("request_46")
            .get("/js/min/ui-news-header-db0e63a5273833271ddc4766df31af23.js")
            .headers(headers_0),
          http("request_47")
            .get("/js/min/ui-weather-widget-6e0f527c45a407ff43c0754071954b02.js")
            .headers(headers_0),
          http("request_48")
            .get("/js/min/ui-news-footer-04d9f2cb2e05b18c35b75f24895788cc.js")
            .headers(headers_0),
          http("request_49")
            .get(uri2 + "/24/11/384x216/skynews-paris-lights-champs-elysees_6757067.jpg?20241124195207")
            .headers(headers_19),
          http("request_50")
            .get(uri2 + "/24/11/384x216/885704156e78097c30ccb55cf8801b270c2db8bb9141d00f94b015453895bb7e_6756784.jpg?20241124155254")
            .headers(headers_19),
          http("request_51")
            .get("/api/liveblog/hero-live-mini-liveblog/13258302")
            .headers(headers_51),
          http("request_52")
            .get(uri9 + "/hit.gif?id=11721&url=https%3A%2F%2Fnews.sky.com%2F&dom=news.sky.com&r=1732509085974&pvs=1&ecid=dc437809-e698-4e56-9f65-2c9da74cddec&c=false&tzOffset=-120&doorUrl=http%3a%2f%2fuk-script.dotmetrics.net%2fdoor.js%3fd%3dnews.sky.com%26t%3dother&dfph=&ver=324")
            .headers(headers_19),
          http("request_53")
            .get(uri9 + "/Scripts/ncs-script.js?v=324")
            .headers(headers_0),
          http("request_54")
            .get(uri2 + "/24/11/384x216/f601faa8b32f2edb4f91dc3693e1bd960f2ecd8058a2937b989bcdfeadacb5f3_6756723.jpg?20241124152200")
            .headers(headers_19),
          http("request_55")
            .get(uri2 + "/24/11/384x216/skynews-scott-from-asish-joshi-vt_6757157.jpg?20241125034905")
            .headers(headers_19),
          http("request_56")
            .get(uri2 + "/24/11/384x216/skynews-wales-cars_6756634.jpg?20241124143110")
            .headers(headers_19),
          http("request_57")
            .get("/resources/manifest.json")
            .headers(headers_0),
          http("request_58")
            .get("/resources/icon.svg?v=2")
            .headers(headers_0),
          http("request_59")
            .get(uri6)
            .headers(headers_0),
          http("request_60")
            .get("/resources/favicon.ico?v=2")
            .headers(headers_0),
          http("request_61")
            .get(uri7 + "?id=11721&url=https%3A%2F%2Fnews.sky.com%2F&dom=news.sky.com&r=1732509085974&pvs=1&pvid=dc437809-e698-4e56-9f65-2c9da74cddec&c=false&tzOffset=-120")
            .headers(headers_19),
          http("request_62")
            .options(uri8 + "?v=1")
            .headers(headers_62),
          http("request_63")
            .get(uri8 + "?v=1")
            .headers(headers_17),
          http("request_64")
            .get("/resources/icons/sunny.svg?bypass-service-worker")
            .headers(headers_64)
        ),
      pause(9),
      http("request_65")
        .get("/api/liveblog/hero-live-mini-liveblog/13258302")
        .headers(headers_0),
      pause(9),
      http("request_66")
        .get("/api/liveblog/hero-live-mini-liveblog/13258302")
        .headers(headers_0)
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
