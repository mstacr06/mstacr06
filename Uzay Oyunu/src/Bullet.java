import java.awt.*;

public class Bullet extends GameObject {

    private int speed = 10;
    private boolean visible = true;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 4;
        this.height = 10;
    }

    @Override
    public void update() {
        y -= speed;
        if (y < 0) visible = false;
    }

    @Override
    public void draw(Graphics g) {
        if (visible) {
            g.setColor(Color.YELLOW);
            g.fillRect(x, y, width, height);
        }
    }

    public boolean isVisible() {
        return visible;
    }
}
