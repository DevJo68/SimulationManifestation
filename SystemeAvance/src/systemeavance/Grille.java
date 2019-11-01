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
public class Grille extends JPanel {

    private int width, height;
    private int nbCaseHorizontal, nbCaseVertical;
    private Cellule[][] tableauCase;
    private int tailleCase = 10;
    private int nbCaseTotal = 0;

    public Grille(int nbCaseHorizontal, int nbCaseVertical) {
        super();
        this.nbCaseHorizontal = nbCaseHorizontal;
        this.nbCaseVertical = nbCaseVertical;
        this.width = nbCaseHorizontal * tailleCase;
        this.height = nbCaseVertical * tailleCase;
        setPreferredSize(new Dimension(width, height));

        this.tableauCase = new Cellule[nbCaseVertical][nbCaseHorizontal];
        for (int i = 0; i < this.nbCaseVertical; i++) {
            for (int j = 0; j < this.nbCaseHorizontal; j++) {
                tableauCase[i][j] = new Cellule(null);
                nbCaseTotal++;
            }
        }
        System.out.println(nbCaseTotal);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        // draw the rectangle here
        g2.setColor(Color.BLACK);
        //setBackground(Color.yellow);
        //g2.drawRect(5, 5, width, height);
//        for (int i = 5; i <= width + 5; i += tailleCase) {
//
//            g2.drawLine(i, 5, i, height + 5);
//        }
//        for (int j = 5; j <= height + 5; j += tailleCase) {
//
//            g2.drawLine(5, j, width + 5, j);
//        }
        for (int i = 5; i < this.width; i += tailleCase) {
            for (int j = 5; j < this.height; j += tailleCase) {
                g2.drawRect(i, j, tailleCase,tailleCase);
                //System.out.println("Dessiner " + i);
            }
            //System.out.println("Nouvelle colonne");
        }

    }

}
