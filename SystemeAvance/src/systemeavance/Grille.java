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
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Grille extends JPanel {

    private int width,height;
    private static Plateau plateau;
    private int tailleCase = 10;
    private boolean Encours = false;
    private static Timer timer;
    
    public Grille(int nbCaseHorizontal, int nbCaseVertical) {
        super();
        this.plateau = new Plateau(nbCaseVertical,nbCaseHorizontal,5,15);
        this.width = nbCaseHorizontal * tailleCase;
        this.height = nbCaseVertical * tailleCase;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        // draw the rectangle here
        g2.setColor(Color.BLACK);
        //setBackground(Color.yellow);
        //g2.drawRect(5, 5, width, height);
        /*for (int i = 5; i <= width + 5; i += tailleCase) {

            g2.drawLine(i, 5, i, height + 5);
        }
        for (int j = 5; j <= height + 5; j += tailleCase) {

            g2.drawLine(5, j, width + 5, j);
        }*/
//        for (int i = 5; i < this.width; i += tailleCase) {
//            for (int j = 5; j < this.height; j += tailleCase) {
//                
//                g2.drawRect(i, j, tailleCase,tailleCase);
//                //System.out.println("Dessiner " + i);
//            }
//            //System.out.println("Nouvelle colonne");
//        }
        dessinerCase(g2);

    }
    
    private void dessinerCase(Graphics2D g2){
         for (int i = 0; i < this.plateau.getHeight(); i++) {
            for (int j = 0; j < this.plateau.getWidth(); j++) {
                plateau.getCellule(i, j).dessiner(g2,tailleCase);
            }
        }
    }
    
    public void Start(){
        Encours=true;
        TimerTask task = new TimerTask() {
        public void run() {
            try{
                System.out.println("systemeavance.Grille.Start()");
                plateau.NextIteration();
                repaint();
                } catch (Exception e) {
                    System.err.println(e);
                }
                if (!Encours) {
                    timer.cancel();
                }
            }
        };
            timer = new Timer("Timer");
            timer.scheduleAtFixedRate(task, 1000L, 1000L);
    }
    
    public void Stop(){
        Encours=false;
    }
    
}
