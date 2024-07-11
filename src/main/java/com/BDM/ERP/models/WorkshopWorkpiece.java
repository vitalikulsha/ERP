package com.BDM.ERP.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workshop_workpiece")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkshopWorkpiece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "partNumber")
    private String partNumber;

    @Column(name = "input")
    private int input;

    @Column(name = "saw")
    private int saw;
}
