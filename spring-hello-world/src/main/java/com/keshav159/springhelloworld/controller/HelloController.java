package com.keshav159.springhelloworld.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("sayHello")
    public String sayHello(){
        return "hello Spring";
    }

    @GetMapping("/message/{msg}")
    public String getMessage(@PathVariable String msg){
        return "Welcome to : "+msg;
    }

    @GetMapping("/calculate/add")
    public double add(@RequestParam(defaultValue = "0") Integer i, @RequestParam(defaultValue = "0") Integer j){
        return i + j;
    }
    @GetMapping("/calculate/sub")
    public double sub(@RequestParam(defaultValue = "0") Integer i, @RequestParam(defaultValue = "0") Integer j){
        return i - j;
    }
    @GetMapping("/calculate/mul")
    public double mul(@RequestParam(defaultValue = "0") Integer i, @RequestParam(defaultValue = "0") Integer j) {
        return i * j;
    }
    @GetMapping("/calculate/div")
    public double div(@RequestParam(defaultValue = "0")  Integer i, @RequestParam(defaultValue = "0") Integer j) {
        return i / j;
    }
    @GetMapping("/calculate/sqrt")
    public double sqrt(@RequestParam(defaultValue = "0") Integer i) {
        if (i == 0 || i == 1)
            return i;

        float j = 1, result = 1;

        while (result <= i) {
            j++;
            result = j * j;
        }
        return (j - 1);
    }

    @GetMapping("/calculate/pow")
    public double pow(@RequestParam(defaultValue = "0") Integer i, @RequestParam(defaultValue = "0") Integer j) {
        if(j==0)
            return 1;
        else
            return i * pow(i, j-1);
    }

}


