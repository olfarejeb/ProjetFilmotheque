package com.gestion.filmotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.filmotheque.entities.Film;

public interface FilmRepository extends JpaRepository< Film ,Integer>{
	List<Film> findByAnneeparution(int annee) ;
	List<Film> findByCategorieId(int id) ;


}
