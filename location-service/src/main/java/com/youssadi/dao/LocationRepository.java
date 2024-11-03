package com.youssadi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.youssadi.domain.Location;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
