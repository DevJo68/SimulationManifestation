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
public class CelluleObjectif extends Cellule{
    
    public CelluleObjectif(Point centre){
        super(centre);
    }

    @Override
    public String getType() {
       return "Objectif";
    }
}
