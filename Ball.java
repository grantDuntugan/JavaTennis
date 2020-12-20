import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
    private static final int DIAMETER = 30;
    //x-coordinate
    int x = 0;

    //y-coordinate
    int y = 0;

    //indicates x pos or x neg direction
    int xa = 1;

    //indicates y pos or y neg direction
    int ya = 1;

    //uses object to get the borders of the canvas
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move() {
        boolean changeDirection = true;
        //If cases determine whether ball should move left/right/up/down
        if (x + xa < 0) {
            xa = game.speed;
        }
        else if (x + xa > game.getWidth() - 30) {
            xa = -game.speed;
        }
        else if (y + ya < 0) {
            ya = game.speed;
        }
        else if (y + ya > game.getHeight() - 30) {
            game.gameOver();
        }
        else if (collision()) {
            ya = -game.speed;
            y = game.racquet.getTopY() - DIAMETER;
            game.speed++;
        } else {
            changeDirection = false;
        }

        //increments the position of the ball
        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    /**
     * this method paints the ball in the position of x and y
     * @param g graphics2d object
     */
    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
