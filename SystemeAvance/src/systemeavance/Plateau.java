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
    private ArrayList<ArrayList<Cellule>> plateau;
    private ArrayList<Policier> listPoliciers;
    private ArrayList<Manifestant> listManifestants;
    private ArrayList<Groupe> listGroupes;
    private CelluleObjectif objectif; // Peut être faire une liste ???
    private boolean Encours = false;
    
    private void Dessin(){}
    private void NextIteration(){
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
        
        Dessin();//On redessine le dessin après avoir terminer de calculer une application
    }
    public void Start(){
        Encours=true;
        while(Encours){
            NextIteration();
        }
    }
    public void Stop(){
        Encours=false;
    }
}
