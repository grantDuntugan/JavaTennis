import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel{

    int x = 0;
    int y = 0;

    private void moveBall() {
        x++;
        y++;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, 30, 30);
    }

    public static void main(String[] args) throws InterruptedException {
        //Initialize the frame for the game
        JFrame frame = new JFrame("Mini Tennis");

        Game game = new Game();

        //Adds the frame
        frame.add(game);

        //Sets size to 300x300
        frame.setSize(300, 400);

        //is visible until closed
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true) {
            game.moveBall();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
