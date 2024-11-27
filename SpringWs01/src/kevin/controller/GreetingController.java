package kevin.controller;

import kevin.service.Greeting;
import kevin.service.impl.GreetingJson;
import kevin.service.impl.GreetingXml;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private int defaultId = 0;
    private String defaultName = "Mr. Stranger";
    private String defaultMsg = "I come with peace";

    @RequestMapping(
            value = "/greet.json",
            method = RequestMethod.GET,
            produces = "application/json")
    public Greeting sayGreetingJson() {
        return new GreetingJson(defaultId, defaultName, defaultMsg);
    }

    @RequestMapping(
            value = "/greet.json/{guestId}/{guestName}/{message}",
            method = RequestMethod.GET,
            produces = "application/json")
    public Greeting seyGreetingJson(
            @PathVariable int guestId,
            @PathVariable String guestName,
            @PathVariable String message
    ) {
        return new GreetingJson(guestId, guestName, message);
    }

    @RequestMapping(
            value = "/greet.xml",
            method = RequestMethod.GET,
            produces = "application/xml")
    public Greeting sayGreetingXml() {
        return new GreetingXml(defaultId, defaultName, defaultMsg);
    }

    @RequestMapping(
            value = "/greet.xml/{guestId}/{guestName}/{message}",
            method = RequestMethod.GET,
            produces = "application/xml"
    )
    public Greeting sayGreetingXml(
            @PathVariable int guestId,
            @PathVariable String guestName,
            @PathVariable String message
    ) {
        return new GreetingXml(guestId, guestName, message);
    }
}
