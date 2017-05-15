package assignment2017;
import assignment2017.codeprovied.Connect4Player;
import assignment2017.codeprovided.Connect4GameState;


public class Connect4 {
  //instance variables
  private static Connect4GameState gameState = new Connect4GameState();
  private static Connect4Player red = new Connect4Player();
  private static Connect4Player yellow = new Connect4Player();
  private static Connect4ConsoleDisplay display = new Connect4ConsoleDisplay();
  public Connect4(Connect4GameState gs, Connect4Player r, Connect4Player y, Connect4ConsoleDisplay d){
    this.gameState = gs;
    this.red = r;
    this.yellow = y;
    this.display = d;
  }
}
