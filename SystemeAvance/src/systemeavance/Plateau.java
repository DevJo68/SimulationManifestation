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

    public Plateau(){
        //Ici on va remplir les listes policier et manifestant etc...
        //JE VOUS LAISSE FAIRE
        ArrayList<Policier> NewlistPoliciers = new ArrayList<Policier>();
        for (Policier elem : listPoliciers) {
            NewlistPoliciers.add(new Policier(elem.Deplacement(), elem.GroupeReferent));
        }
        ArrayList<Manifestant> NewlistManifestants = new ArrayList<Manifestant>();
        for (Manifestant elem : listManifestants) {
            NewlistManifestants.add(new Manifestant(elem.Deplacement(), elem.GroupeReferent));
        }
    }
    
    private void Dessin() {
    }

    private void NextIteration() {
       //Faire faire les deplacements
       //Soit par le biais de groupes avec la method deplacement
       //Soit individuellemnt pour chaque celluleActive toujours avec la methode deplacement
       
        

        Dessin();//On redessine le dessin après avoir terminer de calculer une application
    }

    public void Start() {
        Encours = true;
        while (Encours) {
            NextIteration();
        }
    }

    public void Stop() {
        Encours = false;
    }

    public boolean isCellFree(int x, int y) {
        return true;
    }

    public String getTypeCell(int x, int y) {
        return plateau.get(x).get(y).getType();
    }

    //replace old cell with new one after mouvement
    void changeCellStatus(int px, int py, Cellule newCell) {
        plateau.get(px).set(py, newCell);
    }

}
