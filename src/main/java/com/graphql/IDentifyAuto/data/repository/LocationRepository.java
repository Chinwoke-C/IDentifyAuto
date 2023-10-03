package com.graphql.IDentifyAuto.data.repository;

import com.graphql.IDentifyAuto.data.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
