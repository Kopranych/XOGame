package XOGame.controller;

import XOGame.modul.FieldGame;
import XOGame.modul.Player;
import XOGame.modul.Point;
import ex5.Animal;

/**
 * Created by kopra on 23.07.2017.
 */
public class GameController{
    public static void doShoot(Point point) {
        Player.setPoint(point);
        Player.setShoot(true);
    }
}
