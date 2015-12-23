/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.databaselp50.core.entity;


import java.util.Set;
/**
 *
 * @author nicolas
 */
public class Enjoy {
    
    private int id ;
    private String name;
    private String type; 
    
    private String description;    
    private String horraireLundi;
    private String horraireMardi;
    private String horraireMercredi;
    private String horraireJeudi;
    private String horraireVendredi;
    private String horraireSamedi;
    private String horraireDimanche;
    
    private double note;
    private int nbrNote; //nbr de personne qui ont noté 
    
    private Set <CommentaireEnjoy> commentaires;

    public Enjoy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHorraireLundi() {
        return horraireLundi;
    }

    public void setHorraireLundi(String horraireLundi) {
        this.horraireLundi = horraireLundi;
    }

    public String getHorraireMardi() {
        return horraireMardi;
    }

    public void setHorraireMardi(String horraireMardi) {
        this.horraireMardi = horraireMardi;
    }

    public String getHorraireMercredi() {
        return horraireMercredi;
    }

    public void setHorraireMercredi(String horraireMercredi) {
        this.horraireMercredi = horraireMercredi;
    }

    public String getHorraireJeudi() {
        return horraireJeudi;
    }

    public void setHorraireJeudi(String horraireJeudi) {
        this.horraireJeudi = horraireJeudi;
    }

    public String getHorraireVendredi() {
        return horraireVendredi;
    }

    public void setHorraireVendredi(String horraireVendredi) {
        this.horraireVendredi = horraireVendredi;
    }

    public String getHorraireSamedi() {
        return horraireSamedi;
    }

    public void setHorraireSamedi(String horraireSamedi) {
        this.horraireSamedi = horraireSamedi;
    }

    public String getHorraireDimanche() {
        return horraireDimanche;
    }

    public void setHorraireDimanche(String horraireDimanche) {
        this.horraireDimanche = horraireDimanche;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public int getNbrNote() {
        return nbrNote;
    }

    public void setNbrNote(int nbrNote) {
        this.nbrNote = nbrNote;
    }

    public Set<CommentaireEnjoy> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Set<CommentaireEnjoy> commentaires) {
        this.commentaires = commentaires;
    }

   
  
}
