/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemeavance;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author e1603982
 */
public class Manifestant extends CelluleActive {

    public Manifestant(Point centre, Groupe referent) {
        super(centre,referent);
    }

     public boolean estPoliceProche() {
        //On teste si il  a des police proches
        return true;
    }

    @Override
    public Point Deplacement(Plateau plateau) {
        int xo = plateau.objectif.centre.x;
        int yo = plateau.objectif.centre.y;
        int newX=this.centre.x,newY=this.centre.y;
        
        if (Math.abs(this.centre.x-xo)>1) {
            if(this.centre.x-xo<0){
                newX++;
            }
            else{
                newX--;
            }
        }
        if (Math.abs(this.centre.y-yo)>1) {
            if(this.centre.y-yo<0){
                newY++;
            }
            else{
                newY--;
            }
        }
        return new Point(newX,newY);
    }

    @Override
    public TypeCellule getType() {
        return TypeCellule.Manifestant;
    }

    @Override
    public void dessiner(Graphics2D g,int tailleCase) {
        g.setColor(Color.BLACK);
        g.fillRect(centre.x*tailleCase+10, centre.y*tailleCase+10, tailleCase, tailleCase);
    }
    
    
}
