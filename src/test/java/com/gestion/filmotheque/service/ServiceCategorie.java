package com.gestion.filmotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.filmotheque.entities.Categorie;
import com.gestion.filmotheque.repository.CategorieRepository;
@Service
public class ServiceCategorie implements IServiceCategorie{
	
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public Categorie craeteCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return categorieRepository.save(c) ;
	}

	@Override
	public Categorie findCategorieById(int id) {
		// TODO Auto-generated method stub
		return categorieRepository.findById(id).get();
	}

	@Override
	public List<Categorie> findAllCatgories() {
		// TODO Auto-generated method stub
		return categorieRepository.findAll();
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return categorieRepository.save(c);
	}

	@Override
	public void deleteCategorie(int id) {
		// TODO Auto-generated method stub
		categorieRepository.deleteById(id);
	}

}
