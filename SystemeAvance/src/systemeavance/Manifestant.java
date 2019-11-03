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
        int xo = GroupeReferent.objectif.x;
        int yo = GroupeReferent.objectif.y;
        float dist = ((xo - this.centre.x) * (xo - this.centre.x)) + ((yo - this.centre.y) * (yo - this.centre.y));

        if (dist > 0) {
            float directionx = xo - this.centre.x;
            float directionz = xo - this.centre.y;
            float normalizex = directionx / dist;
            float normalizez = directionz / dist;

            float translationx = (float) (normalizex * 0.01);
            float translationz = (float) (normalizez * 0.01);

            //nouvelles coordonnes temporaires avant verification de ce qui se passe dans le plateau
            int tmpPx = this.centre.x + (int) translationx;
            int tmpPy = this.centre.y + (int) translationz;
            return new Point(tmpPx, tmpPy);

        }
        //si pas deplacement on return le meme coordonnes
        return new Point(this.centre.x, this.centre.y);
    }

    @Override
    public TypeCellule getType() {
        return TypeCellule.Manifestant;
    }

    @Override
    public void dessiner(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(15, 5, 10, 10);
    }
    
    
}
