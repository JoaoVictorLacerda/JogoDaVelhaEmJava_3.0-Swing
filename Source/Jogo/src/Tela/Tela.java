package Tela;

import Ouvinte.Ouvinte;
import Tela.Background.JPanelBackgground;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame {
    private JPanel painel;

    public final JLabel BUTTONS[]={

            new JLabel("",JLabel.CENTER),new JLabel("",JLabel.CENTER),new JLabel("",JLabel.CENTER),
            new JLabel("",JLabel.CENTER),new JLabel("",JLabel.CENTER),new JLabel("",JLabel.CENTER),
            new JLabel("",JLabel.CENTER),new JLabel("",JLabel.CENTER),new JLabel("",JLabel.CENTER),
    };

    public final JLabel label = new JLabel("SEJAM BEM-VINDOS! Jogador 1 começa",JLabel.CENTER);

    public Tela(){
        this.setSize(500,400);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addLabels();
        this.addJPanel();
        this.addJbutton();
        this.addMatriz();
        this.setVisible(true);
    }
    public void addJPanel(){
        this.painel = new JPanelBackgground();
        painel.setLayout(null);
        this.add(painel,BorderLayout.CENTER);
    }
    public void addMatriz(){
        Ouvinte ouvinte = new Ouvinte(this);
        Font font = new Font("Arial",Font.BOLD,40);
        Point []points = {
                new Point(20,20), new Point(159,20), new Point(295,20),
                new Point(20,120),new Point(159,120),new Point(295,120),
                new Point(20,217), new Point(159,217),new Point(295,217)
                };
        Dimension dimension = new Dimension(120,80);

        for(int i =0;i<9;i++){
            BUTTONS[i].setLocation(points[i]);
            BUTTONS[i].setSize(dimension);
            BUTTONS[i].setFont(font);
            BUTTONS[i].addMouseListener(ouvinte);
            this.painel.add(BUTTONS[i]);
        }
    }
    public void addLabels(){
        Font font = new Font("Arial",Font.BOLD,20);

        JLabel espaco1 = new JLabel("      ");
        JLabel espaco2 = new JLabel("      ");


        this.label.setFont(font);
        this.add(this.label,BorderLayout.NORTH);
        this.add(espaco1,BorderLayout.WEST);
        this.add(espaco2,BorderLayout.EAST);

    }
    public void addJbutton(){
        JButton button = new JButton("NOVO JOGO");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Tela();
            }
        });
        this.add(button, BorderLayout.SOUTH);
    }


}
