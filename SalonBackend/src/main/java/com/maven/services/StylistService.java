package com.maven.services;

import com.maven.models.Stylist;
import com.maven.models.dtos.StylistDto;
import java.io.IOException;
import java.util.List;

public interface StylistService {

    Stylist addStylist(Stylist stylist);

    Stylist updateStylist(Stylist stylist) throws IOException;

    String deleteStylist(Long Stylist_id);

    List<StylistDto> getAllStylist();
}
