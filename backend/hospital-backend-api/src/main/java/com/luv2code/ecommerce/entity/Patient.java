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

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<>();

    @Column(name = "dateJoined")
    @CreationTimestamp
    private Date dataJoined;

    @Column(name = "dateUpdated")
    @UpdateTimestamp
    private Date dataUpdated;

    //create a method to add an appointment
    public void add(Appointment appointment) {
        if(appointment != null) {
            if(appointments == null) {
                appointments = new HashSet<>();
            }

            appointments.add(appointment);
            appointment.setPatient(this);
        }
    }

}

