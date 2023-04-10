package com.gestion.filmotheque.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Film {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
  private int id;
  private String titre;
  private String description;
  private int anneeparution;
  @ManyToOne
  private Categorie categorie;
  @ManyToMany
  private List<Acteur> acteurs;
  
  
}
