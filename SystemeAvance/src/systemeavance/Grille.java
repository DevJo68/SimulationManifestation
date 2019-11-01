/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemeavance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author victo
 */
public class Grille extends JPanel{
    
    private int width,height;
    
    public Grille(int nbCaseHorizontal,int nbCaseVertical){
        super();
        
        this.width =  nbCaseHorizontal*10;
        this.height = nbCaseVertical*10;
        setPreferredSize(new Dimension(width, height));
                System.out.println(this.width);
        System.out.println(this.height);
    }

    @Override
   protected void paintComponent(Graphics g) {
     Graphics2D g2 = (Graphics2D) g;
       super.paintComponent(g);
      // draw the rectangle here
      g2.setColor(Color.BLACK);
              //setBackground(Color.yellow);
      //g2.drawRect(5, 5, width, height);
      for(int i = 5;i<=width+5;i+=10){

          g2.drawLine(i, 5, i, height+5);
      }
            for(int j = 5;j<=height+5;j+=10){

          g2.drawLine(5, j, width+5, j);
      }
   }
    
}
