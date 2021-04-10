package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dtos.AppointmentResponse;
import com.luv2code.ecommerce.dtos.Purchase;
import com.luv2code.ecommerce.entity.Appointment;
import com.luv2code.ecommerce.entity.Patient;
import com.luv2code.ecommerce.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    //call the repository
    private PatientRepository patientRepository;

    //autowire the repository
    @Autowired
    public AppointmentServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    @Transactional
    public AppointmentResponse placeAppointment(Purchase purchase) {

        //retrieve appointment details from the client, using dto
        Appointment appointment = purchase.getAppointment();

        //generate Appointment Tracking id
        String appointmentTrackingNumber = generateTrackingNumber();
        appointment.setAppointmentTrackingNumber(appointmentTrackingNumber);

        Patient patient = appointment.getPatient();
        patient.add(appointment);

        //save to the db
        patientRepository.save(patient);

        //return a response
        return new AppointmentResponse(appointmentTrackingNumber);

    }

    private String generateTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
