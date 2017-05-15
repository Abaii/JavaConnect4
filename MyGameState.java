package assignment2017;
import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.IllegalColumnException;
import assignment2017.codeprovided.IllegalRowException;
import assignment2017.codeprovided.ColumnFullException;


/**
* @Author Abai Edmund
* @Version 1.0
*/



public class MyGameState extends Connect4GameState {
  private int[][] board = new int[NUM_ROWS][NUM_COLS];
  private char currentTurn;

  //constructor
  public MyGameState(){}
  //setter
  public void setBoard(int[][] b){
    this.board = b;
  }
  //getter
  public int[][] getBoard(){
    return this.board;
  }
  public void setCurrentTurn(char c){
    this.currentTurn = c;
  }
  public char getCurrentTurn(){
    return this.currentTurn;
  }
    //methods

  public void startGame(){

    //SET ALL VALUES TO EMPTY WHEN STARTING THE GAME
    for (int i = 0; i < NUM_ROWS; i++){
      for(int j = 0; j < NUM_COLS; j++){
        board[i][j] = EMPTY;
      }
    }
    setCurrentTurn('R'); //set currentTurn to red.

  }
  public int whoseTurn() {

    return 1 ;

  }

  public void move(int c) throws ColumnFullException, IllegalColumnException{
    int col = c;
    char currentTurn = getCurrentTurn();
    if (col > 6 || col < 0){
      throw new IllegalColumnException(col);
    }else{
      for (int i = 0; i < col; i++){
        if (board[i][col] == EMPTY){ //find empty space
          board[i][col] = currentTurn; //place the counter
        }
      }
      throw new ColumnFullException(col); //if no spaces are empty

    }

  }

  public int getCounterAt(int col, int row) throws IllegalColumnException, IllegalRowException{
    if (col > 6 || col < 0){
      throw new IllegalColumnException(col);
    }else if(row < 0 || row > 5){
      throw new IllegalRowException(row);
    }else if (board[row][col] == 'R'){
      return RED;
    }else if (board[row][col] == 'Y'){
      return YELLOW;
    }else{
      return EMPTY;
    }

  }
  public boolean isBoardFull(){
    //loop through board and check for any empty spaces
    for (int i = 0; i < NUM_ROWS; i++){
      for(int j = 0; j < NUM_COLS; j++){
        if (board[NUM_ROWS][NUM_COLS] == EMPTY){
          return false;
        }
      }
    }
    return true;
  }

  public boolean isColumnFull(int c) throws IllegalColumnException{
    int col = c;
    //error handling
    if (col > 6 || col < 0){
      throw new IllegalColumnException(col);
    }else{
      //check the column
      for (int i = 0; i < col; i++){
        if (board[i][col] == EMPTY){
          return false;
        }
      }
    }
      return true;
  }
  public int getWinner(){
    int rCounter = 0; //red counter
    int yCounter = 0; //yellow counter
    int hCounter = 0; //horizontal counter
    int dCounter = 0; //diagonal counter
    int l = 0; //check diagonals
    //check each row
    for (int a = 0; a < NUM_ROWS; a++){
      for (int b = 0; b < NUM_COLS;b++ ){
        if (board[NUM_ROWS][NUM_COLS] == RED && board[NUM_ROWS+1][NUM_COLS+1] == RED){
            rCounter += 1;
        }else{
          rCounter = 0;
        }
        if (board[NUM_ROWS][NUM_COLS] == YELLOW && board[NUM_ROWS+1][NUM_COLS+1] == YELLOW){
          yCounter += 1;
        }else{
          yCounter = 0;
        }
      }
    }
    //check each column
    for (int c = 0; c < NUM_COLS; c++){
      for (int d = 0; d < NUM_ROWS; d++){
        if (board[NUM_ROWS][NUM_COLS] == RED &&
        board[NUM_ROWS+1][NUM_COLS+1] == RED){ // red followed by red
          rCounter += 1;//reset counter if reds arent in a row
        }else{
          rCounter = 0; //increase the counter
        }
        if (board[NUM_ROWS][NUM_COLS] == YELLOW  &&
        board[NUM_ROWS+1][NUM_COLS+1] == YELLOW){ // yellow followed by yellow
          yCounter += 1;//reset counter if yellows arent in a row
        }else{
          yCounter =0; //increase the counter if they are.
        }
      }
    }
    //diagonal forward check starting from (0,0)
    for (int k = 0; k < board.length; k++){
      if (rCounter == NUM_IN_A_ROW_TO_WIN){
        return RED;
      }else if (yCounter == NUM_IN_A_ROW_TO_WIN){
        return YELLOW;
      }
      if (board[k][l] == RED && (board[k+1][l+1] == RED)){ //red followed by red
        rCounter += 1; //reset red counter
      }else {
        rCounter += 0; //increase red counter
      }
      if (board[k][l] == YELLOW &&
      board[k+1][l+1] == YELLOW){ //consecutive yellows
        yCounter += 1;
      }else{
        yCounter += 0; //increase yellow counter
      }
      l++;
    }
    //diagonal check starting from (x,y) where x is the biggest x co-ordinate on the grid
    //and y is the biggest y co-ordinate on the grid
    for(int k = board.length; k > 0; k++){
      if (board[k][l] == RED && board[k-1][l-1] == RED){
        rCounter += 1;
      }else{
        rCounter = 0;
      }
      if (board[k][l] == YELLOW && board[k-1][l-1] == YELLOW){
        yCounter +=1;
      }else{
        yCounter = 0;
      }
    }
    return EMPTY;

  }
  //check too see if game is finished
  public boolean gameOver(){
    if (getWinner() == RED || getWinner() == YELLOW){
      return true;
    }
    return false;
  }
  //create a deep copy of the current game instance
  public Connect4GameState copy(){
    Connect4GameState newState = new MyGameState();

    return newState;
  }





}
