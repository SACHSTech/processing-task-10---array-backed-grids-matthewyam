import processing.core.PApplet;

public class Sketch extends PApplet {

  float CELL_WIDTH = 45;
  float CELL_HEIGHT = 45;
  float MARGIN = 5;
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  float SCREEN_WIDTH = (10*CELL_WIDTH * 11*MARGIN);
  float SCREEN_HEIGHT = (10*CELL_HEIGHT * 11*MARGIN);
  float rectX = 0;
  float rectY = 0;
  int[][] intGrid;
  int row = 0;
  int column = 0;

	
 
  public void settings() {
    size(500, 500);
  }

  
  public void setup() {
    background(0,0,0);
    
    intGrid = new int[ROW_COUNT][COLUMN_COUNT];

  }

 
  public void draw() {
    for(row = 0; row < ROW_COUNT; row++){
      for(column = 0; column < COLUMN_COUNT; column++){
        rect(MARGIN,rectY,CELL_WIDTH,CELL_HEIGHT);
        MARGIN+=49;
      }
      MARGIN = 5;
      rectY +=50;
    }

    
  }

  

  public void mousePressed(){
      fill(0,255,0);
      rect(12,mouseY,CELL_WIDTH,CELL_HEIGHT);
    }
  }
