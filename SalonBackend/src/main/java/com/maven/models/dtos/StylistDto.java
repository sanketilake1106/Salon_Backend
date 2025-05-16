package com.maven.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StylistDto {

    private Long stylistId;
    private String stylistName;
    private String email;
    private String contact;
    private String specialization;
    private String bio;
    private boolean isActive;
}
