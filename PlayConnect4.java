package assignment2017;
import assignment2017.codeprovided.*;
/**
* @Author Abai Edmund
* @Version 1.0
*
*/
public class PlayConnect4 {
  public static void main(String[] args){
    Connect4GameState gameState = new MyGameState();

    Connect4Player red = new RandomPlayer();
    Connect4Player yellow = new KeyboardPlayer();
    Connect4ConsoleDisplay display = new Connect4ConsoleDisplay(gameState);

    Connect4 game = new Connect4(gameState, red, yellow, display);
    game.play();
  }
}
