import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    Timer timer;
    Player player;
    ArrayList<Bullet> bullets;
    ArrayList<Enemy> enemies;
    ArrayList<Point> stars;
    int score = 0;

    public GamePanel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);

        player = new Player(375, 500);
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        stars = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            stars.add(new Point((int)(Math.random() * 800), (int)(Math.random() * 600)));
        }

        spawnEnemies();
        timer = new Timer(16, this);
        timer.start();
    }

    public void spawnEnemies() {
        for (int i = 0; i < 6; i++) {
            enemies.add(new Enemy(100 + i * 100, 50));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Arka plan yıldızlar
        g.setColor(Color.GRAY);
        for (Point star : stars) {
            g.fillRect(star.x, star.y, 2, 2);
        }

        player.draw(g);

        for (Bullet b : bullets) {
            b.draw(g);
        }

        for (Enemy e : enemies) {
            e.draw(g);
        }

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
        g.drawString("Lives: " + player.getLives(), 700, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();

        for (Point star : stars) {
            star.y += 1;
            if (star.y > 600) {
                star.y = 0;
                star.x = (int)(Math.random() * 800);
            }
        }

        bullets.removeIf(b -> {
            b.update();
            return !b.isVisible();
        });

        enemies.forEach(Enemy::update);
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        Iterator<Bullet> bulletIt = bullets.iterator();
        while (bulletIt.hasNext()) {
            Bullet bullet = bulletIt.next();
            Iterator<Enemy> enemyIt = enemies.iterator();
            while (enemyIt.hasNext()) {
                Enemy enemy = enemyIt.next();
                if (bullet.getBounds().intersects(enemy.getBounds())) {
                    bulletIt.remove();
                    enemy.hit(); // yanıp sönme
                    enemyIt.remove();
                    score += 10;
                    break;
                }
            }
        }

        Iterator<Enemy> enemyIt = enemies.iterator();
        while (enemyIt.hasNext()) {
            Enemy enemy = enemyIt.next();
            if (enemy.getY() > 550) {
                enemyIt.remove();
                player.loseLife(score); // score'u gönderiyoruz

                break;
            }
        }

        if (enemies.isEmpty()) {
            spawnEnemies();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bullets.add(new Bullet(player.getX() + 18, player.getY()));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
