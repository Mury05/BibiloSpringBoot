package bj.highfive.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BiblioController {

    @GetMapping("")
    public String welcome(){
        return "Bienvenue sur notre application de gestion de bibliothèque !";
    }
}
