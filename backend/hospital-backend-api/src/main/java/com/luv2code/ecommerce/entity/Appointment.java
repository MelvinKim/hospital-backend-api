package com.luv2code.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "appointmentTrackingNumber")
    private String appointmentTrackingNumber;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "appointmentFee")
    private double appointmentFee;

    @Column(name = "rating")
    private double rating;

    @Column(name = "creationDate")
    @CreationTimestamp
    private Date creationDate;

    @Column(name = "scheduledDate")
    @UpdateTimestamp
    private Date scheduledDate;

    //check whether the appointment occurred or not
    @Column(name = "occurred")
    private Boolean occurred;
}
