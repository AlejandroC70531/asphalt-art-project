
import org.code.neighborhood.*;

public class PainterPlus extends Painter{
// Turns right by turning left 3 times
    public void turnRight(){
turnLeft();
turnLeft();
turnLeft();
 }
// Takes all the paint the painter is standing on
  public void takeAllPaint(){
    while(isOnBucket())
      takePaint();
  }
// Moves forward until a barricade is reached
  public void moveFast(){
    while(canMove())
      move();
  }
// Paints squares until there is no more paint
  public void paintToEmpty(String color){
    while(hasPaint()){
      paint(color);
      move();
    }
  } 
/*Paints in a donut pattern by painting a square, moving forward, 
 *painting again, turning right, and moving until all paint is used
 */
  public void paintDonut(String color){
    while(hasPaint()){
    paint(color);
    move();
    paint(color);
    turnRight();
    move();
    }
  }
  //Moves the painter backwards by turning left twice, moving, then turning left twice again
  public void moveBackwards() {
 turnLeft();
 turnLeft();
 move();
 turnLeft();
 turnLeft();
}

}
  
