package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.AlienRepo;
import com.example.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
/////////////////////////////////////
// 	Web (Jsp) Methods
////////////////////////////////////
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/addAlienFromWeb")
	public String addAlienFromWeb(Alien alien) {
		
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
	
/////////////////////////////////////
// 	Rest Service Methods
////////////////////////////////////
	
	//@RequestMapping(path="/aliens", produces= {"application/xml"})
	//@RequestMapping("/aliens")
	//@ResponseBody
	@GetMapping("/aliens")
	public List<Alien> getAliens() {
		
		return repo.findAll();
	}
	
	
//	@RequestMapping("/alien/{aid}")
//	@ResponseBody
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		return repo.findById(aid);
	}
	
//	@PostMapping(path="/alien", consumes= {"application/json"})
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien) {		
		repo.save(alien);		
		return alien;
	}
	
	@PutMapping("/alien")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {		
		repo.save(alien);		
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien alien = repo.getOne(aid);
		repo.delete(alien);
		return "deleted";
	}
	
	
}
