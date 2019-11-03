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
    public Point Deplacement(int pas) {
        // TODO : place here the rule of the demonstrator
        //il y a deux deplacements : charger manifestant et revenir vers objectif
        return new Point(0,0);
    }
    public boolean estManifestantProche(){return true;};
    public void charger(){};

    @Override
    public void dessiner(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect(centre.x-5, centre.y-5, 10, 10);
    }
    
    
    
}

