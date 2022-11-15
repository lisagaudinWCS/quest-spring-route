package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number) {
        if (number > 0 && number < 13) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Toto");
        } else if (number == 13) {
            return new Doctor(13, "Jodie Wittaker");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number);
        }
        // return null;
    }
}

// if {number} == 13 tu me renvoies le JSON {"number":13, "name":"Toto"}
// if {number} > 0 && < 13 tu me renvoies un statut : 303 See Other
//if {number} n'existe pas tu me renvoies un statut : 404 Not Found