package com.BDM.ERP.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workshop_welding")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkshopWelding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "partNumber")
    private String partNumber;

    @Column(name = "input")
    private int input;

    @Column(name = "welding1")
    private int welding1;

    @Column(name = "welding2")
    private int welding2;

    @Column(name = "cleaning")
    private int cleaning;
}
