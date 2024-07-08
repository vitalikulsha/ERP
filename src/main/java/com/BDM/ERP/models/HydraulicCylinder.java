package com.BDM.ERP.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cylinders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HydraulicCylinder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number", unique = true)
    private String number;

    @Column(name = "name")
    private String name;

    @ElementCollection
    private List<CylinderPart> cylinderParts = new ArrayList<>();

}
