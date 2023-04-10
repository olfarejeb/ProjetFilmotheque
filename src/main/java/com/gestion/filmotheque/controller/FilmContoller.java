package com.gestion.filmotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestion.filmotheque.entities.Film;
import com.gestion.filmotheque.service.IServiceActeur;
import com.gestion.filmotheque.service.IServiceCategorie;
import com.gestion.filmotheque.service.IServiceFilm;

@Controller
@RequestMapping("/film/")
public class FilmContoller {
	@Autowired
	IServiceFilm iServiceFilm;
	@Autowired
	IServiceCategorie iServiceCategorie;
	@Autowired
	IServiceActeur iServiceActeur;
	@GetMapping("all")
	public String listFilms(Model model)
	{
		model.addAttribute("films", iServiceFilm.findAllFilms());
		model.addAttribute("categories", iServiceCategorie.findAllCategories());
		return "affiche";
	}
	@GetMapping("recherche")
	public String rechFilmparannees(Model model,@RequestParam(name="annee") int a)
	{
		model.addAttribute("films", iServiceFilm.findByAnneeparution(a));
	
		return "affiche";
	}
	@GetMapping("new")
	public String afficheNewForm(Model model)
	{
		model.addAttribute("categories", iServiceCategorie.findAllCategories());
		model.addAttribute("acteurs", iServiceActeur.findAllActeurs());
		model.addAttribute("message","");
		return "ajout";
	}
	@PostMapping("add")
	public String add(Film f, Model model){
		try
		{iServiceFilm.createFilm(f);
		return "redirect:/film/all" ;}
		catch(DataIntegrityViolationException ex){
			String message="film deja existe";
			model.addAttribute("categories", iServiceCategorie.findAllCategories());
			model.addAttribute("acteurs", iServiceActeur.findAllActeurs());
			model.addAttribute("message",message);
			return "ajout";
		}
	}
	@GetMapping("modif/{id}")
	public String afficheUpdateForm(Model model,@PathVariable int id)
	{
		model.addAttribute("categories", iServiceCategorie.findAllCategories());
		model.addAttribute("film", iServiceFilm.findFilmById(id));
		model.addAttribute("acteurs", iServiceActeur.findAllActeurs());
		return "modifer";
	}
	@PostMapping("update/{id}")
	public String upadate(Film f)
	{
		iServiceFilm.updateFilm(f);
		return "redirect:/film/all";
	}
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id)
	{
		iServiceFilm.deleteFilm(id);
		return "redirect:/film/all";
	}
	@PostMapping("findcategorie")
	public String rechercheparcategorie(Model model,int id) {
	if(id == 0) {
	model.addAttribute("films",iServiceFilm.findAllFilms());
	model.addAttribute("categories",iServiceCategorie.findAllCategories());
	}else {
	model.addAttribute("films",iServiceFilm.findByCategorieId(id));
	model.addAttribute("categories",iServiceCategorie.findAllCategories());
	}
	return "affiche";
	}


}
