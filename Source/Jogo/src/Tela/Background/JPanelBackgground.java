package Tela.Background;

import javax.swing.*;
import java.awt.*;

public class JPanelBackgground extends JPanel {
    private ImageIcon img;

    public JPanelBackgground(){
        img = new ImageIcon(JPanelBackgground.class.getResource("/img.png"));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);

    }

    public void setImg(ImageIcon img){
        this.img = img;
    }

    public ImageIcon getImg(){
        return this.img;
    }

}

