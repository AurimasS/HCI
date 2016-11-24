package hci_coursework;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Mgallery extends JFrame{
    JLabel pic;
    Timer tm;
    int x = 0;
    
private JFrame frame;
private KelvingroveMuseum kelvinm;
private Mgallery mgallery;

public Mgallery(KelvingroveMuseum kelvinm) {
	this.kelvinm = kelvinm;
	
}
    //Images Path In Array
    String[] list = {
                      "C:/Users/User/Desktop/a.jpg",//0
                      "C:/Users/User/Desktop/b.jpg",//1
                      "C:/Users/User/Desktop/c.jpg",//2
                      "C:/Users/User/Desktop/d.jpg",//3
                      "C:/Users/User/Desktop/e.jpg",//4

                    };
  
    public Mgallery(){
        super("Java SlideShow");
        pic = new JLabel();
        pic.setBounds(52, 37, 586, 219);


        //Call The Function SetImageSize
        SetImageSize(4);
        

       //set a timer
        tm = new Timer(500,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        getContentPane().add(pic);
        tm.start();
        getContentPane().setLayout(null);
        setSize(800, 400);
        getContentPane().setBackground(Color.decode("#bdb67b"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    //create a function to resize the image 
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

public static void main(String[] args){ 
    new Mgallery();
}
public JFrame getFrame() {
	return this.frame;
}
  }

