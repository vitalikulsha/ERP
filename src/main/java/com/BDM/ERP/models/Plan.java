package com.BDM.ERP.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "planes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;

    @Column (name = "orderNumber")
    private String orderNumber;

    @Column (name = "customer")
    private String customer;

    @Column (name = "cylinderNumber")
    private String cylinderNumber;

    @Column (name = "quantity")
    private int quantity;
}
