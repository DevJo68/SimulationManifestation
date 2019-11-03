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
public class CelluleObjectif extends Cellule{
    
    public CelluleObjectif(Point centre){
        super(centre);
    }
    
    @Override
    public TypeCellule getType() {
       return TypeCellule.Objectif;
    }
    
    @Override
    public void dessiner(Graphics2D g,int tailleCase) {
        g.setColor(Color.RED);
        g.fillRect(centre.x*tailleCase+10, centre.y*tailleCase+10, tailleCase, tailleCase);
    }
}
