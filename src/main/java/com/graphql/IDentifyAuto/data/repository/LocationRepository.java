package com.graphql.IDentifyAuto.data.repository;

import com.graphql.IDentifyAuto.data.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByZipCode(String zipCode);

}
