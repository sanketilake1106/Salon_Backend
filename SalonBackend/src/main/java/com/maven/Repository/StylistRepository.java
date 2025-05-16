package com.maven.Repository;

import com.maven.models.Stylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StylistRepository extends JpaRepository<Stylist, Long> {
}
