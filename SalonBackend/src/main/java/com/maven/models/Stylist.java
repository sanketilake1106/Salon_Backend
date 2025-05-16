package com.maven.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stylist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stylistId;
    private String StylistName;
    private String email;
    private String contact;
    private String specialization;
    private String bio;
    private boolean isActive = true;
}
