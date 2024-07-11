package com.BDM.ERP.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workshop_mechanical_processing")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkshopProcessing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "date")
//    private String date;
//
//    @Column(name = "workShift")
//    private int workShift;

    @Column(name = "partNumber")
    private String partNumber;

    @Column(name = "input")
    private int input;

    @Column(name = "turning1")
    private int turning1;

    @Column(name = "turning2")
    private int turning2;

    @Column(name = "turning3")
    private int turning3;

    @Column(name = "drilling")
    private int drilling;

    @Column(name = "milling")
    private int milling;
}
