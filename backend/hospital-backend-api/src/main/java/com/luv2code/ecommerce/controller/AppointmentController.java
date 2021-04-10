package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.dtos.AppointmentResponse;
import com.luv2code.ecommerce.dtos.Purchase;
import com.luv2code.ecommerce.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/purchase")
    //we are passing "purchase" as the request body
    public AppointmentResponse appointmentResponse(@RequestBody Purchase purchase) {
        AppointmentResponse appointmentResponse = appointmentService.placeAppointment(purchase);

        return appointmentResponse;
    }



}
