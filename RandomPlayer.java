package assignment2017;
import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.Connect4GameState;

public class RandomPlayer extends Connect4Player{
  public void makeMove(Connect4GameState gameState){
    gameState = new MyGameState(); 
  }
}
