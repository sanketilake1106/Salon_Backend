package com.maven.controller;

import com.maven.models.Stylist;
import com.maven.services.StylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/stylist")
@CrossOrigin("*")
public class StylistController {

    @Autowired
    StylistService stylistService;

    @GetMapping("/test")
    public String test() {
        return "Public endpoint working!";
    }
    @PostMapping("/addStylist")
    public ResponseEntity<?> addStylist(
            @RequestParam("stylistName") String stylistName,
            @RequestParam("email") String email,
            @RequestParam("contact") String contact,
            @RequestParam("specialization") String specialization,
            @RequestParam("bio") String bio) {

        Stylist stylist = new Stylist();
        stylist.setStylistName(stylistName);
        stylist.setEmail(email);
        stylist.setContact(contact);
        stylist.setSpecialization(specialization);
        stylist.setBio(bio);
        stylist.setActive(true);

        return ResponseEntity.ok(stylistService.addStylist(stylist));
    }

    @PatchMapping("/updateStylist")
    private ResponseEntity<?> updateStylist(@RequestParam("stylistId") Long stylistId,
                                            @RequestParam("stylistName") String stylistName,
                                            @RequestParam("email") String email,
                                            @RequestParam("contact") String contact,
                                            @RequestParam("specialization") String specialization,
                                            @RequestParam("bio") String bio){

        Stylist stylist = new Stylist();
        stylist.setStylistId(stylistId);
        stylist.setStylistName(stylistName);
        stylist.setEmail(email);
        stylist.setContact(contact);
        stylist.setSpecialization(specialization);
        stylist.setBio(bio);
        stylist.setActive(true);
        return ResponseEntity.ok(stylistService.addStylist(stylist));
    }

    @DeleteMapping("/deleteStylist/{stylistId}")
    public ResponseEntity<?> deleteTeamMember(@PathVariable Long stylistId) {
        return ResponseEntity.ok(stylistService.deleteStylist(stylistId));
    }

    @GetMapping("/getAllStylist")
    public ResponseEntity<?> getAllTeamMember() {
        return ResponseEntity.ok(stylistService.getAllStylist());
    }

}
