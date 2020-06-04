package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.*;
import java.util.Random;

@SpringBootApplication //означает что этот класс является spring - говским
@RestController // без этого контроллера не работает
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args); //всегда необходимо так запускать Spring приложения
    }

    @GetMapping("/hello") //при открытий localhost:8080//hello
    public String hello(@RequestParam(value = "name", defaultValue = "World!") String name) {
        return String.format("Hello %s!", name); //выводит "Hello World!"
    }


    @GetMapping(value = "/{number}") //при написании любых цифр, например localhost:8080//100
    public Object c(@PathVariable int number) {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            s.append(String.format(i + "<br>")); //выводит диапазон цифр от 1 - до 100
        }
        return s;
    }

    @GetMapping("/random") //при переходе на random
    public String random() throws URISyntaxException, IOException {
        return new Rand().randd() + new Rand().randd()+ new Rand().randd()+ new Rand().randd()+ new Rand().randd()
                + new Rand().randd()+ new Rand().randd()+ new Rand().randd()+ new Rand().randd()+ new Rand().randd();
        //выводится рандомные сайты

/*
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 4;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);

        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        String site = "http://" + generatedString + ".com";
        String blank = "_blank";

        String mail = "http://mail.ru";
        char dm = (char) 34;

//        return "<a href=" + site + " target=" + blank + ">" + site + "</a>";
//        return "<a href=" + site + " target=" + blank + ">" + site + "</a>" + " <meta http-equiv=" + dm + "refresh"+ dm+ " "  + " content=" + dm + "2000000;" + site + dm + ">";

        return "<p><a href=" +dm + site + dm+ " target=" +dm + blank + dm+  ">" + site + "</a></p>" + " <br>";*/

    }
}