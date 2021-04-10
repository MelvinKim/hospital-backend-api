package com.luv2code.ecommerce.dtos;

import com.luv2code.ecommerce.entity.Doctor;
import com.luv2code.ecommerce.entity.Patient;
import com.luv2code.ecommerce.entity.Appointment;
import lombok.Data;

@Data
public class Purchase {

    private Patient patient;

    private Doctor doctor;

    private Appointment appointment;
}
