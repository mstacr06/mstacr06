import java.awt.*;

public class Enemy extends GameObject {

    private int speedY = 1;
    private int speedX = 2;
    private boolean moveRight = true;
    private boolean isHit = false;
    private int hitTimer = 0;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 30;
        this.height = 20;
    }

    @Override
    public void update() {
        y += speedY;

        if (moveRight) {
            x += speedX;
            if (x > 770) moveRight = false;
        } else {
            x -= speedX;
            if (x < 0) moveRight = true;
        }

        if (isHit) {
            hitTimer--;
            if (hitTimer <= 0) isHit = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        if (isHit) g.setColor(Color.ORANGE);
        else g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public int getY() { return y; }

    public void hit() {
        isHit = true;
        hitTimer = 10;
    }
}
