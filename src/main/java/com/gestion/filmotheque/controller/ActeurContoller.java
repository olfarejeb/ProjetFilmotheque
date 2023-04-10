package com.gestion.filmotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion.filmotheque.entities.Acteur;
import com.gestion.filmotheque.entities.Film;
import com.gestion.filmotheque.service.IServiceCategorie;
import com.gestion.filmotheque.service.IServiceFilm;
import com.gestion.filmotheque.service.IServiceActeur;

@Controller
@RequestMapping("/acteur/")
public class ActeurContoller {
	@Autowired
	IServiceActeur iServiceActeur;
	@Autowired
	IServiceCategorie iServiceCategorie;
	@Autowired
	IServiceFilm iServiceFilm;
	@GetMapping("allacteur")
	public String listActeurs(Model model)
	{
		model.addAttribute("acteurs", iServiceActeur.findAllActeurs());
		
		return "afficheacteur";
	}
	@GetMapping("newacteur")
	public String afficheNewForm(Model model)
	{
		model.addAttribute("films", iServiceFilm.findAllFilms());
		return "ajoutacteur";
	}
	@PostMapping("addacteur")
	public String add(Acteur a){
		iServiceActeur.createActeur(a);
		return "redirect:/acteur/allacteur" ;
	}
	@GetMapping("modifacteur/{id}")
	public String afficheUpdateForm(Model model,@PathVariable int id)
	{
		
		model.addAttribute("films", iServiceFilm.findAllFilms());
		model.addAttribute("acteur", iServiceActeur.findActeurById(id));
		
		return "modifacteur";
	}
	@PostMapping("updateacteur/{id}")
	public String upadate(Acteur a)
	{
		iServiceActeur.updateActeur(a);
		return "redirect:/acteur/allacteur";
	}
	@DeleteMapping("deleteacteur/{id}")
	public String delete(@PathVariable int id)
	{
		iServiceActeur.deleteActeur(id);
		return "redirect:/acteur/allacteur";
	}


}
