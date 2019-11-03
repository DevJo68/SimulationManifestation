/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemeavance;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author victo
 */
public class Affichage extends JFrame {

    private Dimension screen;
    private Grille grille;
    static boolean i = false;


    public Affichage() {
        super();
        // Taille de l'écran
        screen = Toolkit.getDefaultToolkit().getScreenSize();
    }

    public void afficher(String titre) {
        // setSize(1366, 768);
        setSize(screen.width, screen.height);
        JPanel p = new JPanel();
        GridLayout gl = new GridLayout();
        JLabel label = new JLabel(" Nombre de policier :");
        label.setHorizontalAlignment(JLabel.CENTER);
        JLabel label2 = new JLabel(" Nombre de manifestant :");
        label2.setHorizontalAlignment(JLabel.CENTER);
        gl.setRows(20);
        gl.setColumns(1);
        gl.setVgap(5);
        p.setBackground(Color.red);

        // Crée une grille avec 51 cases sur 51 cases
        grille = new Grille(51, 51);
        JPanel ctrl = new JPanel();

        //ctrl.setBackground(Color.black);
        JButton start = new JButton("Lancer la Simulation");
        JButton stop = new JButton("Stopper la Simulation");
        //GridBagConstraints gbc = new GridBagConstraints();

        //grille.setPreferredSize(new Dimension(1000, getHeight()));
        ctrl.setPreferredSize(new Dimension(300, getHeight()));
        JFormattedTextField jtf = new JFormattedTextField(NumberFormat.getIntegerInstance());
        JFormattedTextField jtf2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
        Font police = new Font("Arial", Font.BOLD, 14);
        jtf.setFont(police);
        jtf.setPreferredSize(new Dimension(150, 30));
        jtf.setForeground(Color.BLUE);
        jtf2.setFont(police);
        jtf2.setPreferredSize(new Dimension(150, 30));
        jtf2.setForeground(Color.BLUE);
        ctrl.add(label);
        ctrl.add(jtf);
        ctrl.add(label2);
        ctrl.add(jtf2);
        ctrl.add(start);
        ctrl.add(stop);
        ctrl.setLayout(gl);
        p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
        p.add(grille);
        p.add(ctrl);
        setContentPane(p);

        setLocationRelativeTo(null);
        setTitle(titre);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible(true);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i = true;
                
                JOptionPane.showMessageDialog(rootPane, "Programme lancé", "Lancement", JOptionPane.WARNING_MESSAGE);
              
                grille.Start();

            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               grille.Stop();
                JOptionPane.showMessageDialog(rootPane, "Programme stoppé", "Arret", JOptionPane.ERROR_MESSAGE);
                //i =false;
            }
        });

    }

}
