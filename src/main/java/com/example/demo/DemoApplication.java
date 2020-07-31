package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.*;

import static com.example.demo.Start.glavnayaStranica;

@SpringBootApplication //означает что этот класс является spring - говским
@RestController // без этого контроллера не работает
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args); //всегда необходимо так запускать Spring приложения
    }


    //главная страница
    @RequestMapping("/") //при переходе на localhost:8080/ - выводит это сообщение, value = "/" - указывается, если задаётся более, чем один параметр
    public StringBuilder greeting() {
        return new Start().sbb();

    }

    //приветствует пользователя
    @GetMapping("/hello") //при открытий localhost:8080//hello можно также указать имя, hello?name=Marat
    public String hello(@RequestParam(value = "name", defaultValue = "World!") String name) {
        return String.format(glavnayaStranica + "Hello %s!", name); //выводит "Hello World!"
    }


    //получение диапазона цифр
    @GetMapping(value = "/for/{nu}" + "-" + "{nu2}") //при написании цифр через дефис, например localhost:8080/for/100-500 выводит диапазон цифер
    public Object c0(@PathVariable long nu, @PathVariable long nu2) {
        return glavnayaStranica + new For().forEach(nu, nu2);
    }


    //возводит в степень число на самого себя. Пример http://localhost:8080/155
    @GetMapping(value = "/{num}") //при написании любых цифр, например localhost:8080//100
    public Object c(@PathVariable int num) {
        return glavnayaStranica + new PowToPow().pow(num);
    }

    //возводит в степень. Пример: http://localhost:8080/15x5
    @GetMapping(value = "/pow/{number}" + "x" + "{number2}") //при написании любых цифр, например localhost:8080//100x15
    public Object c2(@PathVariable int number, @PathVariable int number2) {
        return glavnayaStranica + new PowXpow().powXpow(number, number2);
    }


    //рандомные сайты
    @GetMapping("/random") //при переходе на random
    public String random() throws URISyntaxException, IOException {
        return glavnayaStranica + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd()
                + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd() + new Rand().randd();
    }

    //текст наоборот
    @GetMapping(value = "/reverse/{name}")
    public String reverse(@PathVariable StringBuffer name) {
        StringBuffer stringBuffer = new StringBuffer(name);
        StringBuffer stringBuffer2 = new StringBuffer(name);
        return "Исходный текст: " + "<br>" + stringBuffer + "<br>" + "<br>" + "<br>" + "Текст наоборот (reverse): " + "<br>" + stringBuffer2.reverse();
    }


    //регистр букв
    @GetMapping(value = "/case/{name}")
    public String casee(@PathVariable String name) {
        String text = name;
        return "Исходный текст: " + "<br>" + text + "<br>" + "<br>" + "<br>" + "прописные буквы: " + "<br>" + text.toLowerCase() + "<br>" + "<br>" + "<br>" + "ЗАГЛАВНЫЕ БУКВЫ: " + "<br>" + text.toUpperCase();
    }

}