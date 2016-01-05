/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.databaselp50.core.entity;

import java.util.Date;
import java.util.Set;
/**
 *
 * @author nicolas
 */
public class Evenement {
    
    private int id ;
    private String name;
    private String description;
    private Date startDate;
    
    
    private int heureD;
    private int minuteD;
    private int HeureF;
    private int minuteF;
    
    private TypeEven type;
    private Set <CommentaireEven> commentaires;

    public Evenement() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public TypeEven getType() {
        return type;
    }

    public void setType(TypeEven type) {
        this.type = type;
    }

    public int getHeureD() {
        return heureD;
    }

    public void setHeureD(int heureD) {
        this.heureD = heureD;
    }

    public int getMinuteD() {
        return minuteD;
    }

    public void setMinuteD(int minuteD) {
        this.minuteD = minuteD;
    }

    public int getHeureF() {
        return HeureF;
    }

    public void setHeureF(int HeureF) {
        this.HeureF = HeureF;
    }

    public int getMinuteF() {
        return minuteF;
    }

    public void setMinuteF(int minuteF) {
        this.minuteF = minuteF;
    }

    public Set<CommentaireEven> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Set<CommentaireEven> commentaires) {
        this.commentaires = commentaires;
    }

    public void setType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    
  
}
