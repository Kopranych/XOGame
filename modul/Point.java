package XOGame.modul;

import java.util.Random;

/**
 * Created by kopra on 27.06.2017.
 */
public class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point getRandomPoint(){
        Random generator = new Random();
        return new Point(generator.nextInt(3), generator.nextInt(3));
    }
}
