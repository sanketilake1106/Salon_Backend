package com.maven.services.impl;

import com.maven.Repository.StylistRepository;
import com.maven.models.Stylist;
import com.maven.models.dtos.StylistDto;
import com.maven.services.StylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StylistServiceImpl implements StylistService {

    @Autowired
    StylistRepository stylistRepository;
    @Override
    public Stylist addStylist(Stylist stylist) {
            return stylistRepository.save(stylist);
    }

    @Override
    public Stylist updateStylist(Stylist stylist) throws IOException {
        return null;
    }

    @Override
    public String deleteStylist(Long teamMemberId) {
        stylistRepository.deleteById(teamMemberId);

        if(stylistRepository.findById(teamMemberId).isEmpty()){
            return "Stylist deleted";
        }
        else {
            return "Stylist not deleted";
        }
    }

    @Override
    public List<StylistDto> getAllStylist() {
        List<StylistDto> stylistDtos = new ArrayList<>();
        stylistRepository.findAll().forEach(stylist -> {
            StylistDto stylistDto = new StylistDto();
            stylistDto.setStylistId(stylist.getStylistId());
            stylistDto.setStylistName(stylist.getStylistName());
            stylistDto.setEmail(stylist.getEmail());
            stylistDto.setProfileImage(stylist.getProfileImage());
            stylistDto.setContact(stylist.getContact());
        });

        return stylistDtos;
    }
}
