package org.amtf.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello World, Spring MVC Tutorial</h3>" +
                "This message is coming from Amtf World.java **********</div><br><br>";
        return new ModelAndView("hello", "message", message);
    }
}