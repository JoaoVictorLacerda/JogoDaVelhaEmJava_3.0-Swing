package Ouvinte;

import Tela.Tela;
import Verificacoes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Ouvinte implements MouseListener {
    private String conteudo="O";
    private ArrayList<JLabel> buttons;
    private Tela tela;
    private final char [][]GAME = {
            {'.','.','.'},
            {'.','.','.'},
            {'.','.','.'}};

    private JLabel button;

    public Ouvinte(Tela tela){
        this.tela = tela;
        this.buttons = new ArrayList<JLabel>(Arrays.asList(tela.BUTTONS));

    }

    public void manipulaJButtons(){
        boolean condicao = this.button.getText().equals("");
        String mensagem="";

        if(conteudo.equals("O")&&condicao){

            this.button.setText("X");
            this.button.setForeground(Color.BLUE);
            mensagem="2";
            conteudo = "X";

        }else if(conteudo.equals("X") && condicao){
            this.button.setText("O");
            this.button.setForeground(Color.GREEN);
            mensagem="1";
            conteudo="O";

        }else{
            this.showMessageDialog(
                    "<html>Posição ocupada<br>Escolha outra ou reinicie a partida<html>");
        }
        tela.label.setText("Vez do Jogador: "+mensagem);
    }

    public void addNaMatriz(){
        int index = buttons.indexOf(button);
        char letra =button.getText().charAt(0);
        if(index>=0 &&index<3){
            this.GAME[0][index]=letra;
        }else if(index>=3 && index<6){
            this.GAME[1][index-3]=letra;
        }else{
            this.GAME[2][index-6]=letra;
        }
    }

    public void resultado(){
        Verificacao [] verificacoes={
                new Diagonal(),new EixoX(),new EixoY()};
        boolean condicao=false;

        for(Verificacao v: verificacoes){
            condicao = v.verificacao(this.GAME);
            byte numeroDoJogador = (byte) (conteudo.equals("O")?2:1);

            if(condicao){
                tela.label.setText("Jogador: "+numeroDoJogador+" Venceu!!");
                this.showMessageDialog("jogador "+conteudo+" ganhou");
                break;
            }
        }
        if(new Empate().verificacao(this.GAME)&&!condicao){
            tela.label.setText("Jogo Empatado");
            this.showMessageDialog("Empate");


        }
    }
    public void reiniciarGame(){
        tela.dispose();
        new Tela();
    }

    public void showMessageDialog(String conteudo){
        JOptionPane.showMessageDialog(tela,conteudo);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.button = (JLabel) e.getSource();
        this.manipulaJButtons();
        this.addNaMatriz();
        this.resultado();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
