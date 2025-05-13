package com.maven.models.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

    private  Long id;
    private String UserName;
    private String email;
    private String contact;
    private String password;
}
