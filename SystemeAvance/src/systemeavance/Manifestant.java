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
        super(centre, referent);
    }

    public boolean estPoliceProche() {
        //On teste si il  a des police proches
        return true;
    }

    @Override
    public Point Deplacement() {
        Point newPos = fairUnPas();
        int tmpPx = newPos.x;
        int tmpPy = newPos.y;
        if (!newPos.equals(new Point(px, py))) {
            if (plateau.isCellFree(tmpPx, tmpPy)) {
                //si la cellule est vide alors on effectue le deplacement
                deplaceDansPlateau(tmpPx, tmpPy);
            } else if (plateau.getTypeCell(tmpPy, tmpPx).equals("Manifestant")) {
                //On fait la fusion 
            } else if (plateau.getTypeCell(tmpPy, tmpPx).equals("Policier")) {
                //On bouge pas ou on fait la bagarre chespas
            }

        }
        return new Point(px, py);
    }

    @Override
    public String getType() {
        return "Manifestant";
    }
}
