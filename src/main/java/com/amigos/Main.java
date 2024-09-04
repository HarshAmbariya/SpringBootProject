package com.amigos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        SpringApplication.run(Main.class , args);
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse(
                "Hello",
                List.of("java ", "gloang" , "javascript"),
                new Person("Alex")

        );
        return response;
    }
    record Person(String name){}

    record GreetResponse(String greet,
                          List<String> fav,
                         Person person
    ) {}
}
