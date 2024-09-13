import org.code.neighborhood.*;

/*
 * MuralPainter is a PainterPlus that paints
 * murals in The Neighborhood
 */
public class BackgroundPainter extends PainterPlus {

  /*
   * Paints each row of The Neighborhood with the color
   * where size is the size of the grid
   * with two different color sections
   */
  public void paintTwoSegmentBackground(String color1, String color2, int size) {
    while (canMove("south")) {
      paintLine(color1, size);
      turnToWest();

      if (canMove("south")) {
        paintLine(color1, size);
        turnToEast();
      }
      
    }

    paintLine(color1, size);
    turnAround();
    moveToCorner();
    turnAround();
    
    //Moves to the start of the second segment
    if (canMove("north")){
      move();
      move();
      move();
      move();
      turnLeft();
     // Paints second segment 
     while (canMove("south")) {
      paintLine(color2, size);
      turnToWest();

      if (canMove("south")) {
        paintLine(color2, size);
        turnToEast();
      }
       

    }
      // Paints one more line then moves painter to bottom right corner
      paintLine(color2, size);
      turnAround();
      moveToCorner();
  }
}

  /*
   * Paints a line with the color where the length
   * of the line is specified by spaces
   */
  public void paintLine(String color, int spaces) {
    setPaint(spaces);

    while (hasPaint()) {
      paint(color);

      if (canMove()) {
        move();
      }
    }
  }

  /*
   * Turns the MuralPainter to the next row to
   * face west if it is currently facing east
   */
  public void turnToWest() {
    if (isFacingEast()) {
      turnRight();
      move();
      turnRight();
    }
  }

  /*
   * Turns the MuralPainter to the next row to
   * face east if it is currently facing west
   */
  public void turnToEast() {
    if (isFacingWest()) {
      turnLeft();
      move();
      turnLeft();
    }
  }

  /*
   * Turns the MuralPainter around to face the opposite direction
   */
  public void turnAround() {
    turnLeft();
    turnLeft();
  }

  /*
   * Resets the MuralPainter object to the starting location
   */
  public void resetPosition() {
    if (isFacingEast()) {
      turnLeft();

      while (canMove()) {
        move();
      }

      turnLeft();

      while (canMove()) {
        move();
      }

      turnAround();
    }
  }

  /*
   * Moves the MuralPainter to the bottom right corner
   */
  public void moveToCorner() {
    while (canMove()) {
      move();
    }
    
    turnRight();

    while (canMove()) {
      move();
    }
  }
  /*
  * Paint the size of the circle a chosen color
  * and the size is the size of the largest part of the side
  */
  public void paintCircleSide(String color, int lineSize){
    // Paints the starting segment of the circle
    turnRight();
    move();
    setPaint(1);
    paint(color);
    // Paints the main segment of the circle
    turnLeft();
    move();
    turnRight();
    move();
    paintLine(color, lineSize);
    // Paints the ending segment of the circle
    turnRight();
    move();
    setPaint(1);
    paint(color);
    turnLeft();
    move();
  }
  
  
}
