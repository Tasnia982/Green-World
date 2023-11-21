package com.GreenWorld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GreenWorld.entity.MyTrees;
@Repository
public interface MyTreesRepository  extends JpaRepository<MyTrees,Integer>{
	

}
