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
public class Policier extends CelluleActive {
    public Policier(Point centre, Groupe referent) {
        super(centre,referent);
    }

    @Override
    public Point Deplacement(int pas) {
        // TODO : place here the rule of the demonstrator
        //il y a deux deplacements : charger manifestant et revenir vers objectif
        return new Point(0,0);
    }
    public boolean estManifestantProche(){return true;};
    public void charger(){};
}

