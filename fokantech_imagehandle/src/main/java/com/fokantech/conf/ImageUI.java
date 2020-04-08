package com.fokantech.conf;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUI   extends JComponent {
    private BufferedImage bufferedImage;

    public ImageUI(){
        this.bufferedImage=null;
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gd2d = (Graphics2D) g;
        if (bufferedImage == null){
            gd2d.setPaint(Color.BLACK);
            gd2d.fillRect(0,0,this.getWidth(),this.getHeight());
        }else {
            gd2d.drawImage(bufferedImage,0,0,this.getWidth(),this.getHeight(),null);
        }
    }
    public void imshow(String title , BufferedImage bufferedImage){
        this.bufferedImage = bufferedImage;
        JDialog ui = new JDialog();
        ui.setTitle(title);
        ui.getContentPane().setLayout(new BorderLayout());
        ui.getContentPane().add(this,BorderLayout.CENTER);
        ui.setSize(bufferedImage.getWidth()+1,bufferedImage.getHeight()+1);
        ui.setVisible(true);
        this.repaint();
    }
}
