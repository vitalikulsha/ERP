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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cylinder")
    private List<CylinderPart> cylinderParts = new ArrayList<>();

    public void addPartToCylinder(CylinderPart part) {
        part.setCylinder(this);
        cylinderParts.add(part);
    }
}
