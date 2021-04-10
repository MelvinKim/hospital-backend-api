package com.luv2code.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "id")
    private String Department;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<>();

    @Column(name = "dataJoined")
    @CreationTimestamp
    private Date dateJoined;

    @Column(name = "dateUpdated")
    @UpdateTimestamp
    private Date dateUpdated;

    @Column(name = "address")
    private String address;

    @Column(name = "experience")
    private int experience;

    @Column(name = "rating")
    private double rating;

    //create a method to add an appointment
    public void add(Appointment appointment) {
        if(appointment != null) {
            if(appointments == null) {
                appointments = new HashSet<>();
            }

            appointments.add(appointment);
            appointment.setDoctor(this);
        }
    }
}
