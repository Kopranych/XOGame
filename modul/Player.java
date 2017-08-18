package XOGame.modul;

import XOGame.view.Hello;

import java.util.Scanner;

/**
 * Created by kopra on 16.06.2017.
 */
public class Player implements Progressable {
    private String name;
    FieldGame gameSpace;
    public Hello hello;
    private static Point point;
    private volatile static boolean isShoot;

    public static boolean isShoot() {
        return isShoot;
    }

    public static void setShoot(boolean shoot) {
        isShoot = shoot;
    }

    public static Point getPoint() {

        return point;
    }

    public static void setPoint(Point point) {
        Player.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public void setGameSpace(FieldGame gameSpace) {
        this.gameSpace = gameSpace;
    }

    public void playerProgress(char symbol) {
        Scanner scan = new Scanner(System.in);
        boolean isBusy = true;
        String letter;
        do {
            System.out.println("Введите номер ячейки");
            letter = scan.nextLine();
            char cellNum = letter.charAt(0);
            for (int i = 0; i < gameSpace.fieldGame.length; i++) {
                for (int j = 0; j < gameSpace.fieldGame.length; j++) {
                    if (gameSpace.fieldGame[i][j] == cellNum) {
                        gameSpace.fieldGame[i][j] = symbol;
                        isBusy = false;
                    }
                }
            }
            if (isBusy) System.out.println("Эта ячейка занята, введите другую");
        } while (isBusy);
    }


    @Override
    public Point getProgress() {
        isShoot = false;
        while (!isShoot) ;
        return point;
    }
}

