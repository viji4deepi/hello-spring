package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at Path/ hello

//    @GetMapping("hello")  // used for only get requests
//    @ResponseBody // returns http response
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //request lives with /hello/goodbye
    @GetMapping("goodbye")  // used for only get requests
    @ResponseBody // returns http response
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handler handles request of the form /hello?name=LaunchCode
    // lives with /hello/hello?name=LaunchCode
    @GetMapping("hello")
    public String helloWithQueryPram(@RequestParam String name){
        return "Hello "+ name +"!";
    }

    //handles request of the form /hello/Launchcode (path parameters)
    // lives with /hello/hello/Launchcode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, "+name+"!";
    }

    //form submission with get request
    //lives with /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello'>" +
                "<input type = 'text' name = 'name'>" +
                "<input type = 'submit' value = 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    //form submission with post request
    // it takes request for both request and post request
    //lives with /hello/hello
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "hello")
    public String helloWithQueryParmeter(@RequestParam String name){
        return "Hello "+ name +"!";
    }

    // the http request lives with //hello/fprmpost
    @GetMapping("formpost")
    public String helloFormPostRequest(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method ='post'>" +
                "<input type = 'text' name = 'name'>" +
                "<input type = 'submit' value = 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
