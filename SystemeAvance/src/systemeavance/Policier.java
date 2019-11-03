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
public class Policier extends CelluleActive {
    public Policier(Point centre, Groupe referent) {
        super(centre,referent);
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
        return TypeCellule.Policier;
    }
    
    public boolean estManifestantProche(){return true;};
    public void charger(){};

    @Override
    public void dessiner(Graphics2D g,int tailleCase) {
        g.setColor(Color.BLUE);
        g.fillRect(centre.x*tailleCase+10, centre.y*tailleCase+10, tailleCase, tailleCase);
    }
    
    
    
}

