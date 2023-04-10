package com.gestion.filmotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion.filmotheque.entities.Categorie;
import com.gestion.filmotheque.entities.Film;
import com.gestion.filmotheque.service.IServiceActeur;
import com.gestion.filmotheque.service.IServiceCategorie;
import com.gestion.filmotheque.service.IServiceFilm;

@Controller
@RequestMapping("/categorie/")
public class CategorieContoller {
	@Autowired
	IServiceFilm iServiceFilm;
	@Autowired
	IServiceCategorie iServiceCategorie;
	@Autowired
	IServiceActeur iServiceActeur;
	@GetMapping("all")
	public String listFilms(Model model)
	{
		model.addAttribute("categories", iServiceCategorie.findAllCategories());
		return "affichecategorie";
	}
	@GetMapping("new")
	public String afficheNewForm(Model model)
	{
		model.addAttribute("categories", iServiceCategorie.findAllCategories());
		model.addAttribute("acteurs", iServiceActeur.findAllActeurs());
		return "ajoutcategorie";
	}
	@PostMapping("add")
	public String add(Categorie c){
		iServiceCategorie.craeteCategorie(c);
		return "redirect:/categorie/all" ;
	}
	@GetMapping("modif/{id}")
	public String afficheUpdateForm(Model model,@PathVariable int id)
	{
		model.addAttribute("categorie", iServiceCategorie.findCategorieById(id));
	
		return "modifcategorie";
	}
	@PostMapping("update/{id}")
	public String upadate(Categorie c)
	{
		iServiceCategorie.updateCategorie(c);
		return "redirect:/categorie/all";
	}
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id)
	{
		iServiceCategorie.deleteCategorie(id);
		return "redirect:/categorie/all";
	}


}
