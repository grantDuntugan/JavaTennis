/**
 * Name: Grant Duntugan
 *
 * This file contains the functionality of a 1 player Pong. All code is from
 * http://www.edu4java.com and their tutorial on creating games. I try to
 * create comments and develop an understanding off of their code.
 */


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * The main functionality of this class is a panel for the game. Graphics
 * objects are painted into the panel which works as the visuals for the game.
 */
@SuppressWarnings("serial")
public class Game extends JPanel{

    //Creates a new ball for the game
    Ball ball = new Ball(this);

    //Creates a racquet for the game
    Racquet racquet = new Racquet(this);

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    /**
     * This method moves the ball in the panel. The move method is taken
     * from the Ball class.
     */
    private void move() {
        ball.move();
        racquet.move();
    }

    /**
     * This method paints the shapes onto the panel.
     * @param g a Graphics object
     */
    @Override
    public void paint(Graphics g) {
        //super.paint clears screen so there's no line when ball moves
        super.paint(g);

        //Converts Graphics object to Graphics2D(better version)
        Graphics2D g2d = (Graphics2D) g;

        //Makes the graphics clearer
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet.paint(g2d);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {
        //Initialize the frame for the game
        JFrame frame = new JFrame("Mini Tennis");

        //Initialize Game to run game
        Game game = new Game();

        //Adds the frame
        frame.add(game);

        //Sets size to 300x400
        frame.setSize(300, 400);

        //is visible until closed
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Game loop
        while(true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
