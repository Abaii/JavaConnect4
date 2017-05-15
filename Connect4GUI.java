package assignment2017;
import java.awt.*;
import javax.swing.*;

public class Connect4GUI extends JFrame{
    public Connect4GUI(){
      setTitle("Connect 4 main menu");
      //add buttons
      JButton buttons = new JButton();
      buttons.setLayout(new BorderLayout());
      buttons.add(new JButton("Enter Game"));
      //add labels
      JPanel labels = new JPanel();
      labels.setLayout(new BorderLayout());
      labels.add(new JLabel("Connect4"));
      labels.add(new JLabel("By Abai Edmund"));

      //border layout position the enter button north east south and west
      Container contentPane = getContentPane();
      contentPane.setLayout(new BorderLayout());
      contentPane.add(buttons, BorderLayout.SOUTH);
      contentPane.add(labels, BorderLayout.EAST);


      Toolkit toolkit = Toolkit.getDefaultToolkit();
      Dimension screenDimensions = toolkit.getScreenSize();

      setSize(screenDimensions.width/2, screenDimensions.height/2);
      setLocation(new Point(screenDimensions.width/4, screenDimensions.height/4));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args){
      Connect4GUI board = new Connect4GUI();
      board.setVisible(true);
    }

}
