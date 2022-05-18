import processing.core.PApplet;

public class Sketch extends PApplet {

  int CELL_WIDTH = 45;
  int CELL_HEIGHT = 45;
  int MARGIN = 5;
  
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  
  int SCREEN_WIDTH = (CELL_WIDTH + MARGIN) * COLUMN_COUNT + MARGIN;
  int SCREEN_HEIGHT = (CELL_HEIGHT + MARGIN) * ROW_COUNT + MARGIN;
  int[][] intGrid;
  
  int row = 0;
  int column = 0;
  
 
  
  public void settings() {
    size(500, 500);
  }

  
  public void setup() {
    background(0,0,0);
    
    intGrid = new int[ROW_COUNT][COLUMN_COUNT];
    for(int x = 0; x < ROW_COUNT; x++){
      for(int y = 0; y < COLUMN_COUNT; y++){
        intGrid[x][y] = 0;
      }
    }

  }
  

 
  public void draw() {
    intGrid[9][2] = 1;
    for(row = 0; row < ROW_COUNT; row++){
      for(column = 0; column < COLUMN_COUNT; column++){
        int boxX = (MARGIN + CELL_WIDTH) * column + MARGIN + CELL_HEIGHT/2 -25;
        int boxY = (MARGIN + CELL_HEIGHT) * row + MARGIN + CELL_HEIGHT/2 -25;
        if(intGrid[column][row] == 1){
          fill(0,255,0);
          rect(boxX,boxY,CELL_WIDTH,CELL_HEIGHT);
        }
        if(intGrid[column][row] == 0){
          fill(255);
          rect(boxX,boxY,CELL_WIDTH,CELL_HEIGHT);
        }
      }  

      }

    }
    
  
  public void mousePressed(){
    
    
    if(intGrid [mouseX/50][mouseY/50] == 1){
      intGrid [mouseX/50][mouseY/50] = 0;
    }
  
    else{
      intGrid [mouseX/50][mouseY/50] = 1;
    }
  }
}


  

  
