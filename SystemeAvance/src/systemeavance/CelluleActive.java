/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemeavance;

/**
 *
 * @author e1603982
 */
public abstract class CelluleActive extends Cellule{
    public Groupe GroupeReferent;//Reference vers le groupe dont elle fait partie, Null si elle ne fait partie d'aucun groupe
    
    //TODO implementer logique de déplacement qui va être le même pour toute cellules active selon un pas donné
    // deplaccement vers GroupeReferent objectif.
    public abstract Point Deplacement(int pas);
    
    
    public CelluleActive(Point centre,Groupe referent){
        super(centre);
        this.GroupeReferent=referent;
    }
}
