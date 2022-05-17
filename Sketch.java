import processing.core.PApplet;

public class Sketch extends PApplet {

  int CELL_WIDTH = 45;
  int CELL_HEIGHT = 45;
  int MARGIN = 5;
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  float SCREEN_WIDTH = (10*CELL_WIDTH * 11*MARGIN);
  float SCREEN_HEIGHT = (10*CELL_HEIGHT * 11*MARGIN);
  int rectX = 0;
  int rectY = 0;
  int[][] intGrid;

  public void settings() {
    size(500, 500);
  }

  
  public void setup() {
    background(0,0,0);
    
    intGrid = new int[ROW_COUNT][COLUMN_COUNT];
    for(int x = 0; x < ROW_COUNT; x++){
      for(int y = 0; y < COLUMN_COUNT; y++){
        intGrid[y][x] = 0;
      }
    }

  }
  

 
  public void draw() {
    for(int row = 0; row < ROW_COUNT; row++){
      for(int column = 0; column < COLUMN_COUNT; column++){
        if(intGrid[column][row] == 1){
          fill(0,255,0);
        }
        else{
          fill(255);
        }
        rect(MARGIN,rectY,CELL_WIDTH,CELL_HEIGHT);
        MARGIN+=49;
      }
      MARGIN = 5;
      rectY +=50;
    }

    
  }
  public void mousePressed(){
    if(intGrid[mouseY/CELL_WIDTH][mouseX/CELL_HEIGHT] == 1){
      intGrid[mouseY/CELL_WIDTH][mouseX/CELL_HEIGHT] = 0;

    }
    else{
      intGrid[mouseY/CELL_WIDTH][mouseX/CELL_HEIGHT] = 1;
    }
  }
}

  

  
