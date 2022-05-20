import processing.core.PApplet;

public class Sketch extends PApplet {

  int CELL_WIDTH = 45;
  int CELL_HEIGHT = 45;
  int MARGIN = 5;
  
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  
  int SCREEN_WIDTH = 500;
  int SCREEN_HEIGHT = 500;
  int[][] intGrid;
  
  int row = 0;
  int column = 0;
  
  int cellCounter = 0;

  int rowCellCount = 0;
  int colCellCount = 0;

  int rowCont = 0;

  
 
  
  public void settings() {
    size(SCREEN_WIDTH, SCREEN_HEIGHT);
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
    //Draws Grid
    for(row = 0; row < ROW_COUNT; row++){
      for(column = 0; column < COLUMN_COUNT; column++){
        int boxX = (MARGIN + CELL_WIDTH) * column + MARGIN + CELL_HEIGHT/2 -25;
        int boxY = (MARGIN + CELL_HEIGHT) * row + MARGIN + CELL_HEIGHT/2 -25;

        //Sets Colours
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
    
    /**
     * Checks if the mouse is pressed
     */
  
  public void mousePressed(){
    int colCheck = mouseX/50;
    int rowCheck = mouseY/50;
    
    //Checks how many cells are selected
    if(intGrid [mouseX/50][mouseY/50] == 1){

      intGrid [mouseX/50][mouseY/50] = 0;
      cellCounter -=1;
      
    }
    else{
      if(intGrid [mouseX/50][mouseY/50] == 0){
  
        intGrid [mouseX/50][mouseY/50] = 1;
        cellCounter +=1;
        
      
    }
  }
//Makes Cells go in cross shape
      if(colCheck < 9 && intGrid [mouseX/50+1][mouseY/50] == 1 ){
        
        intGrid [mouseX/50+1][mouseY/50] = 0;
        cellCounter -=1;
      
      }
    
    else{
        if(colCheck < 9 && intGrid [mouseX/50+1][mouseY/50] == 0 ){
          
            intGrid [mouseX/50+1][mouseY/50] = 1;
            cellCounter +=1;
          
        
    }
    }
    if(colCheck > 0 && intGrid [mouseX/50-1][mouseY/50] == 1){ 

        intGrid [mouseX/50-1][mouseY/50] = 0;
        cellCounter -=1;
      
    }
    else{
      if(colCheck > 0 && intGrid [mouseX/50-1][mouseY/50] == 0){          
        intGrid [mouseX/50-1][mouseY/50] = 1;
          cellCounter +=1;
        
      }
    }
    if(rowCheck < 9 && intGrid [mouseX/50][mouseY/50+1] == 1){
        intGrid [mouseX/50][mouseY/50+1] = 0;
        cellCounter -=1;
      
    }
    else{
      if(rowCheck < 9 && intGrid [mouseX/50][mouseY/50+1] == 0){
        intGrid [mouseX/50][mouseY/50+1] = 1;
  
        cellCounter +=1;
        
       
      }
    }
    if(rowCheck > 0 && intGrid [mouseX/50][mouseY/50-1] == 1){
        intGrid [mouseX/50][mouseY/50-1] = 0;
        cellCounter -=1;
      
    }
  
    else{
      if(rowCheck > 0 && intGrid [mouseX/50][mouseY/50-1] == 0){
          intGrid [mouseX/50][mouseY/50-1] = 1;
          cellCounter +=1;
        
      }
    }
    //Prints mouse clicks and total amount of cells are selected
    System.out.println("");
    System.out.println("Click " + "Mouse Coordinates: " + mouseX + " " + mouseY + " Grid Coordinates: (Row: " + mouseY/50 + " Column: " + mouseX/50 + ")");
    System.out.println("Total of " + cellCounter + " cells are selected");
    System.out.println("");
    
    rowCont = 0;
    for(int i = 0; i < ROW_COUNT; i++){
      for (int j = 0; j < COLUMN_COUNT; j++){
      
        //Checks how many cells are selected per row
        if(intGrid[j][i] == 1){
          rowCellCount++;
        }
        //Checks how many cells are selected consecutively

        if(i > 0 && i < 9){
          
          if(intGrid[j][i] == 1 && intGrid[j][i+1] == 1){
            rowCont+=1;
          }
            
          if(intGrid[j][i] == 1 && intGrid[j][i-1] == 1 && i==9){
            rowCont+=1;
          }
          
          if(intGrid[j][i] == 1 && intGrid[j][i-1] == 1 && intGrid[j][i+1] == 1 && i < 9){
            rowCont+=1;
            
           }
            
          }
        

        }
        //Prints how manny cells are selected per row and consecutively
        if (rowCont > 0 && rowCellCount > 2){ 
          System.out.println("There are " + rowCont + " consecutive cells selected on Row " + i);
          rowCont = 0;
          }
          System.out.println("There are " + rowCellCount + " cells selected on Row " + i);
          rowCellCount = 0;

        }

      
      System.out.println("");
      
       //Checks how many cells are selected per column
      for (int l = 0; l < COLUMN_COUNT; l++){
        for(int k = 0; k < ROW_COUNT; k++){
          if(intGrid[l][k] == 1){
           colCellCount++;
         }
       }
       System.out.println("There are " + colCellCount + " cells selected on Column " + l);
        colCellCount = 0;

      }
      
    }
  
    

  }



  

  
