import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Player extends GameObject {

    private int dx;
    private int lives = 3;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 20;
    }

    @Override
    public void update() {
        x += dx;
        if (x < 0) x = 0;
        if (x > 760) x = 760;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) dx = -5;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) dx = 5;
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) dx = 0;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getLives() { return lives; }

    public void loseLife(int score) {
    lives--;
    if (lives <= 0) {
        JOptionPane.showMessageDialog(null, "Game Over!\nFinal Score: " + score);
        System.exit(0);
    }
}
}
