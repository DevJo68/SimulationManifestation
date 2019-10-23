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
public class Manifestant extends CelluleActive {



    public Manifestant(Point centre, Groupe referent) {
        super(centre,referent);
    }


    public boolean estPoliceProche(){
        //On teste si il  a des police proches
        return true;
    }

    @Override
    public Point Deplacement(int pas) {
        return new Point(0,0);
    }
}
