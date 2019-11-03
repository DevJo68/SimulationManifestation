/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemeavance;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author e1603982
 */
public class Plateau {
    private int width, height;
    private ArrayList<ArrayList<Cellule>> plateau;
    private ArrayList<Policier> listPoliciers;
    private ArrayList<Manifestant> listManifestants;
    private ArrayList<Groupe> listGroupes;
    public CelluleObjectif objectif; // Peut être faire une liste ???
    
    public Plateau(int width,int height,int nbPoliciers, int nbManifestants){
        this.height=height;
        this.width=width;
        this.listPoliciers = new ArrayList<>();
        this.listManifestants = new ArrayList<>();
        this.plateau = CreateEmptyBoard(new CelluleObjectif(new Point(height/2,width/2))); 
        Random rand = new Random();
        for(int i=0;i<nbPoliciers;i++){
            
        }
        // Il reste à créer les policiers et les manifestants dans plateau
        // Pour les tests
        plateau.get(height/2).set(10,new Manifestant(new Point(height/2, 10), null));
        listManifestants.add(new Manifestant(new Point(height/2, 10),null));
        plateau.get(height/2).set(0,new Policier(new Point(height/2, 0), null));
        listPoliciers.add(new Policier(new Point(height/2, 0),null));
    }
    
    public void NextIteration(){
        ArrayList<Policier> NewlistPoliciers= new ArrayList<>();
        for(Policier elem : listPoliciers){
            Policier newPolicier = new Policier(elem.Deplacement(this),elem.GroupeReferent);
            switch (getCellule(newPolicier.centre).getType()) {
                case Vide:
                    setCellule(new CelluleVide(elem.centre));
                    setCellule(newPolicier);
                    NewlistPoliciers.add(newPolicier);
                    break;
                case Manifestant:
                    //On bouge pas ou on fait la bagarre chespas
                    this.listManifestants.remove(getCellule(newPolicier.centre));
                    setCellule(new CelluleVide(elem.centre));
                    setCellule(newPolicier);
                    NewlistPoliciers.add(newPolicier);
                    break;
                case Policier:
                    //On fait la fusion
                    NewlistPoliciers.add(elem);
                    break;
                default:
                    System.err.println("Impossible : la cellule prend la place de l'objectif!");
                    break;
            }
        }
        ArrayList<Manifestant> NewlistManifestants= new ArrayList<>();
        for(Manifestant elem : listManifestants){
            Manifestant newManifestant = new Manifestant(elem.Deplacement(this),elem.GroupeReferent);
            switch (getCellule(newManifestant.centre).getType()) {
                case Vide:
                    setCellule(new CelluleVide(elem.centre));
                    setCellule(newManifestant);
                    NewlistManifestants.add(newManifestant);
                    break;
                case Manifestant:
                    //On fait la fusion
                    NewlistManifestants.add(elem);
                    break;
                case Policier:
                    setCellule(new CelluleVide(elem.centre));
                    this.listManifestants.remove(getCellule(elem.centre));
                    NewlistManifestants.add(elem);
                    break;
                default:
                    System.err.println("Impossible : la cellule prend la place de l'objectif!");
                    break;
            }
        }
        this.listPoliciers = NewlistPoliciers;
        this.listManifestants = NewlistManifestants;
    }
    
    private ArrayList<ArrayList<Cellule>> CreateEmptyBoard(CelluleObjectif objectif){
        ArrayList<ArrayList<Cellule>> newEmptyBoard = new ArrayList<>();
        for(int i =0;i<this.height;i++){
            ArrayList<Cellule> newEmptyLine = new ArrayList<>();
            for(int j=0;j<this.width;j++){
                newEmptyLine.add(new CelluleVide(new Point(i, j)));
            }
            newEmptyBoard.add(newEmptyLine);
        }
        this.objectif=objectif;
        newEmptyBoard.get(objectif.centre.x).set(objectif.centre.y, objectif);
        return newEmptyBoard;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    private void setCellule(Cellule cell){
        plateau.get(cell.centre.x).set(cell.centre.y,cell);
    }
    
    public Cellule getCellule(Point point){
        return plateau.get(point.x).get(point.y);
    }
    
    public Cellule getCellule(int x, int y){
        return plateau.get(x).get(y);
    }
}
