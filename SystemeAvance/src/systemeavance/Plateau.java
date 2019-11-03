/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemeavance;

import java.util.ArrayList;

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
    private CelluleObjectif objectif; // Peut être faire une liste ???
    
    public Plateau(int width,int height,int nbPoliciers, int nbManifestants){
        this.height=height;
        this.width=width;
        this.listPoliciers = new ArrayList<Policier>();
        this.listManifestants = new ArrayList<Manifestant>();
        this.plateau = CreateEmptyBoard(new CelluleObjectif(new Point(height/2,width/2))); 
        // Il reste à créer les policiers et les manifestants dans plateau
        // Pour les tests
        plateau.get(0).set(0,new Policier(new Point(10, 10), null));
        plateau.get(1).set(0,new Manifestant(new Point(20, 20), null));
        plateau.get(2).set(0,new CelluleObjectif(new Point(20, 20)));
    }
    
    public void NextIteration(){
        // TODO : ici a lieu le code qui calcul l'iteration suivante à partir de la liste des cellules.
        ArrayList<Policier> NewlistPoliciers= new ArrayList<Policier>();
        for(Policier elem : listPoliciers){
            //Ligne modifié car erreur sur la fonction Deplacement
            //NewlistPoliciers.add(new Policier(elem.Deplacement(),elem.GroupeReferent));
            NewlistPoliciers.add(new Policier(elem.Deplacement(1),elem.GroupeReferent));
        }
        ArrayList<Manifestant> NewlistManifestants= new ArrayList<Manifestant>();
        for(Manifestant elem : listManifestants){
            //Ligne modifié car erreur sur la fonction Deplacement
            //NewlistManifestants.add(new Manifestant(elem.Deplacement(),elem.GroupeReferent));
            NewlistManifestants.add(new Manifestant(elem.Deplacement(1),elem.GroupeReferent));
        }
    }
    
    private ArrayList<ArrayList<Cellule>> CreateEmptyBoard(CelluleObjectif objectif){
        ArrayList<ArrayList<Cellule>> newEmptyBoard = new ArrayList<ArrayList<Cellule>>();
        for(int i =0;i<this.height;i++){
            ArrayList<Cellule> newEmptyLine = new ArrayList<Cellule>();
            for(int j=0;j<this.width;j++){
                newEmptyLine.add(new CelluleVide(new Point(i, j)));
            }
            newEmptyBoard.add(newEmptyLine);
        }
        newEmptyBoard.get(objectif.centre.x).set(objectif.centre.y, objectif);
        return newEmptyBoard;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public Cellule getCellule(int x, int y){
        return plateau.get(x).get(y);
    }
}
