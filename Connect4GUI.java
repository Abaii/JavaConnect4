package assignment2017;
import assignment2017.codeprovided.Connect4Displayable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class Connect4GUI extends JFrame implements ActionListener,
                                                    Connect4Displayable{
    public Connect4GUI(){
      setTitle("Connect 4 main menu");
      //add buttons
      JButton buttons = new JButton();
      buttons.setLayout(new BorderLayout());
      JButton button = new JButton("Enter Game");
      buttons.add(new JButton("Human player"));
      buttons.add(new JButton("AI "));
      buttons.add(new JButton("Random"));
      //add event listener
      button.addActionListener(this);
      //add labels
      JPanel labels = new JPanel();
      labels.setLayout(new BorderLayout());
      labels.add(new JLabel("Connect4"));
      labels.add(new JLabel("By Abai Edmund"));

      //border layout position the enter button north east south and west
      Container contentPane = getContentPane();
      contentPane.setLayout(new BorderLayout());
      contentPane.add(button, BorderLayout.SOUTH);
      contentPane.add(labels, BorderLayout.EAST);


      Toolkit toolkit = Toolkit.getDefaultToolkit();
      Dimension screenDimensions = toolkit.getScreenSize();

      setSize(screenDimensions.width/2, screenDimensions.height/2);
      setLocation(new Point(screenDimensions.width/4, screenDimensions.height/4));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    /**
    * Closes main menu and opens the game menu
    */
    @Override
    public void actionPerformed(ActionEvent e){
      GameScreen screen = new GameScreen();
      screen.setVisible(true);
      this.setVisible(false);
    }
    public void displayBoard(){

    }

}
