package com.GreenWorld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.GreenWorld.entity.MyTrees;
//import com.GreenWorld.entity.UserInfo;
import com.GreenWorld.entity.alltrees;
import com.GreenWorld.service.MyTreesService;
//import com.GreenWorld.service.UserInfoService;
import com.GreenWorld.service.alltreesService;


@Controller
public class alltreesController {
	
	@Autowired
	private  alltreesService  service;
	
	//@Autowired
	//private UserInfoService us;
	
	@Autowired
	private MyTreesService mytreesservice;
	
	
	@GetMapping("/tree_register")//treeRegister
	public String treeRegister() {
		return "treeRegister";
	}
	
	
	@GetMapping("/available_trees")//treeList
	public ModelAndView getAllalltrees() {
		List<alltrees>list=service.getAllalltrees();		
		return new ModelAndView("alltreesList","alltrees",list);
	}
	

	@PostMapping("/save")
	public String addT(@ModelAttribute alltrees  t) {
		service.save(t);
		return "redirect:/available_trees";
	}
	
	@GetMapping("/my_trees")//mytrees
	public String getMyTrees(Model model)
	{
		List<MyTrees>list=mytreesservice.getAllMyTrees();
		model.addAttribute("alltrees",list);
		return "mytrees";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		alltrees t=service.getalltreesById(id);
		MyTrees mt=new MyTrees(t.getId(),t.getName(),t.getPrice());
		mytreesservice.saveMyTrees(mt);
		return "redirect:/my_trees";
	}
	
	@RequestMapping("/editalltrees/{id}")
	public String editalltrees(@PathVariable("id") int id,Model model) {
		alltrees t=service.getalltreesById(id);
		model.addAttribute("alltrees",t);
		return "alltreesEdit";
	}
	
	@RequestMapping("/deleteTrees/{id}")
	public String deleteTrees(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_trees";
	}
	
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/Green-World")
	public String Greenworld()
	{
		return "Green-World";
	}
	
	@GetMapping("/About-Green-World")
	public String AboutGreenWorld()
	{
		return "About-Green-World";
	}
	
	@GetMapping("/Help")
	public String  Help()
	{
		return "Help";
	}
	
	@GetMapping("/Payment")
	public String  Payment()
	{
		return "Payment";
	}
	
	
	
	@GetMapping("/Add-To-Mytrees")
	public String  AddToMyTrees()
	{
		return "Add-To-Mytrees";
	}
	
	
	@GetMapping("/All-Trees")
	public String  AllTrees()
	{
		return "All-Trees";
	}
	
	

}
