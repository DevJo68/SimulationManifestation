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
public abstract class Cellule {

    Point centre;
    
    public Cellule(Point centre){
        this.centre = centre;
    }
    
    public abstract TypeCellule getType();
    
    public void dessiner(Graphics2D g,int tailleCase){
                g.setColor(Color.BLACK);
        g.drawRect(5, 5, 10, 10);
    }
        
    
}
