package XOGame.modul;

import XOGame.view.GameWindow;

import javax.swing.*;


/**
 * Created by kopra on 23.07.2017.
 */
public class MainGame {

    public static FieldGame field;
    public static Computer computer = new Computer();
    public static Player player = new Player();
    public static GameWindow gameWindow;
    private JButton buttons[][];

    public static void setGameWindow(GameWindow gameWindow) {
        MainGame.gameWindow = gameWindow;
    }

    public void setField(FieldGame field) {
        MainGame.field = field;
    }

    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    public static void startGame() {
        boolean isShoot = false;

        gameWindow.showField(field.cells);
        for (int i = 0; i < 10; i++) {
            while(!isShoot){
                isShoot = field.doShoot(computer.getProgress(), "O",FieldGame.Type.O);
            }
            isShoot = false;
            gameWindow.showField(field.cells);
            if(gameWindow.show_winner(field)) {
                break;
            }
            while(!isShoot){
                isShoot = field.doShoot(player.getProgress(), "X",FieldGame.Type.X);
            }
            isShoot = false;
            gameWindow.showField(field.cells);
            if(gameWindow.show_winner(field)){
                break;
            }
        }

    }
}
