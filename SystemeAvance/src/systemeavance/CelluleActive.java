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
public abstract class CelluleActive extends Cellule {

    public Groupe GroupeReferent;//Reference vers le groupe dont elle fait partie, Null si elle ne fait partie d'aucun groupe
    public Plateau plateau;
    public int px;
    public int py;

    public abstract Point Deplacement();

    public Point fairUnPas() {
        int xo = GroupeReferent.objectif.x;
        int yo = GroupeReferent.objectif.y;
        float dist = ((xo - px) * (xo - px)) + ((yo - py) * (yo - py));

        if (dist > 0) {
            float directionx = xo - px;
            float directionz = xo - py;
            float normalizex = directionx / dist;
            float normalizez = directionz / dist;

            float translationx = (float) (normalizex * 0.01);
            float translationz = (float) (normalizez * 0.01);

            //nouvelles coordonnes temporaires avant verification de ce qui se passe dans le plateau
            int tmpPx = px + (int) translationx;
            int tmpPy = py + (int) translationz;
            return new Point(tmpPx, tmpPy);

        }
        //si pas deplacement on return le meme coordonnes
        return new Point(px, py);
    }

    //Avec cette methode on met a jour l'etat du plateau quand la cellule se deplace ainsi que la position de laa cellule meme
    public void deplaceDansPlateau(float newPx, float newPy) {
        plateau.changeCellStatus(px, py, new CelluleVide(new Point(px, py)));
        px = (int)newPx;
        py = (int)newPy;
        plateau.changeCellStatus(px, py, this);

    }

    public CelluleActive(Point centre, Groupe referent) {
        super(centre);
        this.GroupeReferent = referent;
    }
}
