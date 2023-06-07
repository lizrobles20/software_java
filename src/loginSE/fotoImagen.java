/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginSE;


import javax.swing.ImageIcon;
import java.awt.*;
/**
 *
 * @author lizir
 */
public class fotoImagen extends javax.swing.JPanel{
    String ruta;
    
    public fotoImagen(int x, int y, String ruta){
        this.setSize(x,y);
        this.ruta = ruta;
    }
    
    public void paint(Graphics g){
        Dimension height = getSize();
        Image imgExt = new ImageIcon(ruta).getImage();
        g.drawImage(imgExt, 0,0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
    
}
