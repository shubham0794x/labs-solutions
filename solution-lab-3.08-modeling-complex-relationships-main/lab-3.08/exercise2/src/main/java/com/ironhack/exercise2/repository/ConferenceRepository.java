package com.ironhack.exercise2.repository;

import com.ironhack.exercise2.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface ConferenceRepository  extends JpaRepository<Conference, Integer> {
}
