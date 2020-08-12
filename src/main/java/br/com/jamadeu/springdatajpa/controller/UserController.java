package br.com.jamadeu.springdatajpa.controller;

import br.com.jamadeu.springdatajpa.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Jean Amadeu 08/12/2020
 */
@RestController
@RequestMapping("/usuarios")
public class UserController {
    @PostMapping()
    public String create(@Valid @RequestBody User user){
        return "criado";
    }
}
