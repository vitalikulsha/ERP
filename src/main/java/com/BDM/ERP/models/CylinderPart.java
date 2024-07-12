package com.BDM.ERP.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cylinderParts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CylinderPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "applicability")
    private String applicability;

    @Column(name = "type")
    private String type;

    @ElementCollection
    private List<WorkshopProcessing> processes;

    @ElementCollection
    private List<WorkshopWorkpiece> workpieces;

    @ElementCollection
    private List<WorkshopWelding> weldings;

    public int sumSaw() {
        int sum = 0;
        for (WorkshopWorkpiece workpiece : workpieces) {
            sum += workpiece.getSaw();
        }
        return sum;
    }

    public int sumTurning1() {
        int sum = 0;
        for (WorkshopProcessing process : processes) {
            sum += process.getTurning1();
        }
        return sum;
    }

    public int sumTurning2() {
        int sum = 0;
        for (WorkshopProcessing process : processes) {
            sum += process.getTurning2();
        }
        return sum;
    }

    public int sumTurning3() {
        int sum = 0;
        for (WorkshopProcessing process : processes) {
            sum += process.getTurning3();
        }
        return sum;
    }

    public int sumMilling() {
        int sum = 0;
        for (WorkshopProcessing process : processes) {
            sum += process.getMilling();
        }
        return sum;
    }

    public int sumDrilling() {
        int sum = 0;
        for (WorkshopProcessing process : processes) {
            sum += process.getDrilling();
        }
        return sum;
    }

    public int sumWelding1() {
        int sum = 0;
        for (WorkshopWelding welding : weldings) {
            sum += welding.getWelding1();
        }
        return sum;
    }

    public int sumWelding2() {
        int sum = 0;
        for (WorkshopWelding welding : weldings) {
            sum += welding.getWelding2();
        }
        return sum;
    }

    public int sumCleaning() {
        int sum = 0;
        for (WorkshopWelding welding : weldings) {
            sum += welding.getCleaning();
        }
        return sum;
    }
}
