package Tela;

import DynamicLayout.DynamicLayout;
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
        this.setResizable(true);
        this.setLayout(new DynamicLayout(500,400));
        this.addJPanel();
        this.addlabel();
        this.addJbutton();
        this.addMatriz();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void addJPanel(){
        this.painel = new JPanelBackgground();
        painel.setBounds(0,50,500,313);
        painel.setLayout(new DynamicLayout(500,313));
        this.add(painel);
    }
    public void addlabel(){
        this.label.setBounds(0,0,500,50);
        this.add(label);
    }
    public void addMatriz(){
        Ouvinte ouvinte = new Ouvinte(this);
        Font font = new Font("Arial",Font.BOLD,40);
        Point []points = {
                new Point(30,20), new Point(184,20), new Point(330,20),
                new Point(30,120),new Point(184,120),new Point(330,120),
                new Point(30,217), new Point(184,217),new Point(330,217)
                };
        Dimension dimension = new Dimension(125,80);
        for(int i =0;i<9;i++){
            BUTTONS[i].setLocation(points[i]);
            BUTTONS[i].setSize(dimension);
            BUTTONS[i].setFont(font);
            BUTTONS[i].addMouseListener(ouvinte);
            this.painel.add(BUTTONS[i]);
        }
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
        button.setBounds(0,360,500,50);
        this.add(button, BorderLayout.SOUTH);
    }


}
