package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DoctorController {


    List<Doctor> doctors = new ArrayList<Doctor>();

    @GetMapping("/doctor/")
    @ResponseBody
    public Doctor doctor() {

        return null;
    }

    @GetMapping("/doctor/{id}")
    @ResponseBody
    Doctor getDoctorById(@PathVariable int id) {

       if (id==13){
           return new Doctor(13,"Jodie Whittaker");
       }
       else if(id >=1 && id <= 12)
       {
           throw new ResponseStatusException(HttpStatus.SEE_OTHER, "See Other");
       } else {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + id + " .");
       }
    }


}
