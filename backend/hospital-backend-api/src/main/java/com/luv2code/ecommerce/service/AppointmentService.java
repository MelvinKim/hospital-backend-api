package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dtos.AppointmentResponse;
import com.luv2code.ecommerce.dtos.Purchase;

public interface AppointmentService {

    AppointmentResponse placeAppointment(Purchase purchase);
}
