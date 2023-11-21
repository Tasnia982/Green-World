package com.GreenWorld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.GreenWorld.entity.UserInfo;
import com.GreenWorld.entity.alltrees;

import com.GreenWorld.repository.alltreesRepository;



@Service
public class alltreesService {
	
	@Autowired
	private alltreesRepository tRepo;//tRepo nam ar file create hoiacha jatha alltreesRepository ar info thakbe
	
	public void save(alltrees  t) {
		tRepo.save(t);
	}
	
	public List<alltrees> getAllalltrees(){
		return tRepo.findAll();
	}

	public alltrees getalltreesById(int id) {
		return tRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		tRepo.deleteById(id);
	}

	
}
