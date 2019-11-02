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
        super(centre, referent);
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
                //Si la cellule est Manifestant on effectue le deplacement quand meme, le manifestant est remplace par une cellule vide
                deplaceDansPlateau(tmpPx, tmpPy);

            } else if (plateau.getTypeCell(tmpPy, tmpPx).equals("Policier")) {
                //Fusion
            }

        }
        return new Point(px, py);
    }

    @Override
    public String getType() {
        return "Policier";
    }

    //Dans cette methode faudra verifies si il y a un manifestant dans les parages
    public boolean estManifestantProche() {
        return true;
    }

    public void charger() {
    }

}
