package assignment2017;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class GameScreen extends JFrame{
  //instane variables
  public static int BOARD_WIDTH = 7;
  public static int BOARD_HEIGHT = 8;
  private static final Color B = Color.BLACK;
  private final int GAP = 3;
  public GameScreen(){
    setTitle("Game Screen");

    JPanel panel = new JPanel(new GridLayout(BOARD_HEIGHT, BOARD_WIDTH));
    panel.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,GAP,GAP));
    panel.setBackground(B);

    JButton buttons = new JButton();
    buttons.setLayout(new GridLayout(BOARD_HEIGHT,BOARD_WIDTH));
    for (int i = 0; i < BOARD_WIDTH; i ++){
      for (int j = 0; j < BOARD_HEIGHT; j++){
        buttons.add(new JButton("" + i + "," + j){{
          buttons.setBackground(Color.RED);
          buttons.setForeground(Color.GRAY);
          buttons.setContentAreaFilled(false);
          buttons.setOpaque(true);
        }});
        panel.add(buttons);
      }
    }
    JMenuBar menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);
    JMenu menu = new JMenu("File");
    menuBar.add(menu);

    JMenuItem home = new JMenuItem("Home");
    JMenuItem exit = new JMenuItem("Exit");
    menu.add(home);
    menu.add(exit);

    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(buttons, BorderLayout.CENTER);

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenDimensions = toolkit.getScreenSize();

    setSize(screenDimensions.width/2, screenDimensions.height/2);
    setLocation(new Point(screenDimensions.width/4, screenDimensions.height/4));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //event handlers

  }
  public void actionPerformed(ActionEvent e){
  }
  public static void main(String[] args){

  }
}
