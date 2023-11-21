package com.GreenWorld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GreenWorld.repository.MyTreesRepository;

import com.GreenWorld.entity.MyTrees;

@Service
public class MyTreesService {

	@Autowired
	private MyTreesRepository mytrees;
	
	public void saveMyTrees(MyTrees  trees) {
		mytrees.save(trees);
	}
	
	public List<MyTrees> getAllMyTrees(){
		return mytrees.findAll();
	}
	
	public void deleteById(int id) {
		mytrees.deleteById(id);
	}
	
}
