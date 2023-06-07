/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginSE;


import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author lizir
 */
public class fotoImagenMYSQL extends javax.swing.JPanel{
    BufferedImage ruta;
    
    public fotoImagenMYSQL(int x, int y, BufferedImage ruta){
        this.setSize(x,y);
        this.ruta = ruta;
    }
    
    public void paint(Graphics g){
        Dimension height = getSize();
        //Image imgExt = new ImageIcon(ruta).getImage();
        BufferedImage img = ruta;
        g.drawImage(img, 0,0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
    
}
