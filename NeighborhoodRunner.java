import org.code.neighborhood.*;

public class NeighborhoodRunner {
  public static void main(String[] args) {

BackgroundPainter ieyasu = new BackgroundPainter();
MtFujiPainter nobunaga = new MtFujiPainter();
    
// Painter paints the background
    ieyasu.paintTwoSegmentBackground("LightSkyBlue", "DarkBlue", 16);
// Painter paints the drawing of Mt. Fuji
    nobunaga.paintMtFuji();

    
  }
}
