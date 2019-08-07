package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.AlienRepo;
import com.example.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		repo.save(alien);
		
		return "home.jsp";
	}

	@RequestMapping("/getAlienById")
	public ModelAndView getAlienById(@RequestParam int aid) {		
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("/getAlienByTech")
	public String getAlienByTech(@RequestParam String tech) {	
		
		System.out.println("findByTech: " + tech);
		System.out.println(repo.findByTech(tech));	

		System.out.println("findByTechSorted: " + tech);
		System.out.println(repo.findByTechSorted(tech));	
		
		int aid = 105;
		System.out.println("findByAidGreaterThan: " + aid);
		System.out.println(repo.findByAidGreaterThan(aid));
		
		return "home.jsp";
	}
	
	
	
}
