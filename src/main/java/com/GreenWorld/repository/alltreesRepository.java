package com.GreenWorld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GreenWorld.entity.alltrees;

@Repository
public interface alltreesRepository  extends JpaRepository<alltrees,Integer>{

}
