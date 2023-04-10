package com.gestion.filmotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion.filmotheque.entities.Film;
import com.gestion.filmotheque.service.IServiceCategorie;
import com.gestion.filmotheque.service.IServiceFilm;

@Controller
@RequestMapping("/film/")
public class FilmContoller {
	@Autowired
	IServiceFilm iServiceFilm;
	@Autowired
	IServiceCategorie iServiceCategorie;
	@GetMapping("all")
	public String listFilms(Model model)
	{
		model.addAttribute("films", iServiceFilm.findAllFilms());
		return "affiche";
	}
	@GetMapping("new")
	public String afficheNewForm(Model model)
	{
		model.addAttribute("categories", iServiceCategorie.findAllCategories());
		return "ajout";
	}
	@PostMapping("add")
	public String add(Film f){
		iServiceFilm.createFilm(f);
		return "redirect:/film/all" ;
	}
	@GetMapping("modif/{id}")
	public String afficheUpdateForm(Model model,@PathVariable int id)
	{
		model.addAttribute("categories", iServiceCategorie.findAllCategories());
		model.addAttribute("film", iServiceFilm.findFilmById(id));
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


}
