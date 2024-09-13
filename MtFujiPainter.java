import org.code.neighborhood.*;
public class MtFujiPainter extends MuralPainter{
  
// A variable used in most MtFujiPainter methods to move downwards and stop at a certain point
int yLocation = getY();
  
/*
 * Combines all method parts to draw the whole picture
 */
  public void paintMtFuji(){
    paintSnow();
    paintMountain();
    paintSun();
    paintFlowers();
  }
  
 /*
  * Paints the white snow around 
  * the top half of the perimeter of the mountain
  */
  public void paintSnow(){
    // Turns right, then moves down 4 times
    turnRight();
      while(canMove("south") && yLocation < 4){
        move();
        yLocation = yLocation + 1;
      }
    // Moves to first snow spot, then paints two snow spaces
    // Two moves are added for each new line of snow
    turnLeft();
    move();
    move();
    move();
    move();
    move();
    move();
    move();
    paintLine("white", 2);
    moveFast();
    turnToWest();
    move();
    move();
    move();
    move();
    move();
    move();
    setPaint(2);
    paint("white");
    move();
    move();
    move();
    paint("white");
    moveFast();
    turnToEast();
    move();
    move();
    move();
    move();
    move();
    setPaint(2);
    paint("white");
    move();
    move();
    move();
    move();
    move();
    paint("white");
    moveFast();
    turnToWest();
    move();
    move();
    move();
    move();
    setPaint(2);
    paint("white");
    move();
    move();
    move();
    move();
    move();
    move();
    move();
    paint("white");
    // Finishes painting snow and moves back to beginning
    turnAround();
    resetPosition();
  }
/*
 * Paints the mountain itself
 */
  public void paintMountain(){
    // Turns right, then moves down 5 times
    turnRight();
    yLocation = 0;
      while(canMove("south") && yLocation < 5){
        move();
        yLocation = yLocation + 1;
      }
    // Moves into the snow perimeter around top of the mountain, then paints lines of gray
    // Each line adds another two spaces every time one is painted
      turnLeft();
      move();
      move();
      move();
      move();
      move();
      move();
      move();
    paintLine("gray", 2);
    moveFast();
    turnToWest();
      move();
      move();
      move();
      move();
      move();
    move();
    paintLine("gray", 4);
    moveFast();
    turnToEast();
      move();
      move();
      move();
      move();
      move();
    paintLine("gray", 6);
    moveFast();
    turnToWest();
      move();
      move();
      move();
      move();
    paintLine("gray", 8);
    moveFast();
    turnToEast();
      move();
      move();
      move();
    paintLine("gray", 10);
    moveFast();
    turnToWest();
      move();
      move();
    paintLine("gray", 12);
    // Moves painter back to beginning
    moveFast();
    turnToEast();
    
    resetPosition();
   
 }
  /*
   * Paints the Sun around the mountain by drawing the sides
   * then fills in each half of the Sun separately
   */
   public void paintSun(){
     // Turns right, then moves down 7 times
     turnRight();
     yLocation = 0;
      while(canMove("south") && yLocation < 7){
        move();
        yLocation = yLocation + 1;
      }
     // Turns left and mvoes to mountain, then paints the perimeter of the Sun
     turnLeft();
     move();
     move();
     move();
     move();
     turnAround();
     paintCircleSide("red", 2);
     paintCircleSide("red", 4);
     paintCircleSide("red", 2);
     // Moves back to start, then fills in the Sun
     turnLeft();
     resetPosition();
     fillInLeft();
     fillInRight();
     
   }
  /*
   * Fills in the left half of the Sun from left to right
   */
     public void fillInLeft(){
     // Turns right, then moves down 5 times
       turnRight();
       yLocation = 0;
       while(canMove("south") && yLocation < 5){
        move();
        yLocation = yLocation + 1;
      }
       // Paints first 2 space line on left side
       turnLeft();
       move();
       move();
       move();
       move();
       turnLeft();
       paintLine("red", 2);
       moveBackwards();
       setPaint(6);
      // Paints two lines of 3 spaces after first line on left side 
      while(hasPaint()){
       turnAround();
       move();
       turnLeft();
       move();
       turnLeft();
       paint("red");
        move();
       paint("red");
        move();
       paint("red");
      }
       // Paints final line of 2 at the end of the left side
       turnAround();
       move();
       turnLeft();
       move();
       turnLeft();
       paintLine("red", 2);
       turnRight();
       resetPosition();
     }
   /*
    * Fills in the right half of the Sun from right to left
    */
    public void fillInRight(){
      // Moves all the way to top right corner, then moves down 5 times
      while (canMove()){
        move();
      }
      turnRight();
      yLocation = 0;
       while(canMove("south") && yLocation < 5){
        move();
        yLocation = yLocation + 1;
      }
      // Moves into circle perimeter and paints first line of red (2 spaces)
       turnRight();
       move();
       move();
       move();
       move();
       turnRight();
       paintLine("red", 2);
      // Paints two lines of 3 red spaces left of the first line of 2 spaces
       moveBackwards();
       setPaint(6);
      
      while(hasPaint()){
       turnAround();
       move();
       turnRight();
       move();
       turnRight();
       paint("red");
        move();
       paint("red");
        move();
       paint("red");
      }
      // Paints the final line of 2 spaces on the right side
       turnAround();
       move();
       turnRight();
       move();
       turnRight();
       paintLine("red", 2);
    }
  /*
   * Paints cherry blossom flowers in front of the mountain
   * by painting the branch and pink flowers around it
   * then ends drawing Mt. Fuji by moving the painter to the bottom right corner
   */
    public void paintFlowers(){
      // Sends painter to start
      turnRight();
      resetPosition();
      // Moves painter to other side of grid, then moves down 3 times
      moveFast();
      turnRight();
      yLocation = 0;
       while(canMove("south") && yLocation < 3){
        move();
        yLocation = yLocation + 1;
      }
      // Paints branch for the flower
      turnRight();
      setPaint(9);
      while(hasPaint()){
        paint("RosyBrown");
        move();
        paint("RosyBrown");
        move();
        paint("RosyBrown");
        turnLeft();
        move();
        turnRight();
      }
      // Paints Westernmost two flowers, then paints the remaining top flowers
      setPaint(4);
      move();
      paint("pink");
      turnRight();
      move();
      move();
      paint("pink");
      
      while(hasPaint()){
        turnRight();
        move();
        move();
        turnLeft();
        move();
        paint("pink");
        // Moves painter to paint bottom flowers
        if(!hasPaint()){
          turnRight();
          moveFast();
          turnRight();
          move();
          move();
        }
      }
      // Paints remaining flowers
      setPaint(2);
     while(hasPaint()){
        turnRight();
        move();
        move();
        turnLeft();
        move();
        paint("pink");
     }
      // Sends painter to bottom right corner
      turnLeft();
      moveToCorner();
    }
}
