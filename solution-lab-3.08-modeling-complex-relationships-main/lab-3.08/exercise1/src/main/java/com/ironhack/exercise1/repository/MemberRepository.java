package com.ironhack.exercise1.repository;

import com.ironhack.exercise1.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
