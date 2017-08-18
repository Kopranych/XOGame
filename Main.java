package XOGame;

import java.awt.*;
import java.util.Scanner;

import XOGame.modul.Point;
import XOGame.view.*;
import XOGame.modul.*;
import XOGame.view.Hello;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

import javax.swing.*;

/**
 * Created by kopra on 23.06.2017.
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException {

        GameWindow window = new GameWindow();
        MainGame game = new MainGame();
        JButton[][] buttons = new JButton[3][3];
        FieldGame field = new FieldGame();

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//задает отображение внутренних компонентов окна

        game.setField(field);
        game.setGameWindow(window);
        window.setButtons(buttons);
        field.setButtons(buttons);
        window.initWindow();
        game.startGame();

        int input = -1;
        while (input != 0) {
            input = -1;
            while (input < 0) {
                System.out.println("Здравствуйте!\n" +
                        "Выберите режим игры: 1 - Player1 vs Player2, 2 - Player1 vs Computer\n" +
                        "Для выхода нажмите 0");
                try {
                    input = Integer.valueOf(sc.nextLine());
                } catch (Exception e) {
                    input = -1;
                }
            }
            switch (input) {
                case 1:
                    playerVSplayer();
                    break;
                case 2:
                    playerVScomputer();
                    break;
            }
        }
    }

    public static void playerVSplayer() {

        int playerWin = 0;
        int countEmptyCell = 0;
        int emptyCell = 9;

        FieldGame spaceGame = new FieldGame();
        Hello hello = new Hello();
        Hello hello2 = new Hello();

        Player player = new Player();
        Player player2 = new Player();

        player.setHello(hello);
        player.setGameSpace(spaceGame);
        player2.setHello(hello2);
        player2.setGameSpace(spaceGame);

        player.hello.setPlayer(player);
        player.hello.hello();

        player2.hello.setPlayer(player2);
        player2.hello.hello();

        spaceGame.initGame();
        spaceGame.displayGame();
        while (countEmptyCell < emptyCell) {
            player.hello.stepPlayer();
            player.playerProgress(spaceGame.getCross());
            spaceGame.displayGame();
            playerWin = spaceGame.getWinner(spaceGame.fieldGame);
            countEmptyCell++;
            if (playerWin != 0 || countEmptyCell == emptyCell) break;
            player2.hello.stepPlayer();
            player2.playerProgress(spaceGame.getToe());
            spaceGame.displayGame();
            playerWin = spaceGame.getWinner(spaceGame.fieldGame);
            countEmptyCell++;
            if (playerWin != 0 || countEmptyCell == emptyCell) break;
        }
        hello.winnerPlayer(playerWin, player, player2);
    }

    public static void playerVScomputer() {
        int playerWin = 0;
        int countEmptyCell = 0;
        int emptyCell = 9;

        FieldGame field = new FieldGame();
        Hello helloPlayer = new Hello();
        Hello helloComputer = new Hello();
        Point point = new Point();
        Player player = new Player();
        Computer computer = new Computer();

        player.setHello(helloPlayer);
        player.setGameSpace(field);

        computer.setField(field);
        computer.setPoint(point);
        computer.setHello(helloComputer);
        helloComputer.setCompyter(computer);

        player.hello.setPlayer(player);
        player.hello.hello();
        field.initGame();
        field.displayGame();

        while (countEmptyCell < emptyCell) {
            player.hello.stepPlayer();
            player.playerProgress(field.getCross());
            field.displayGame();
            playerWin = field.getWinner(field.fieldGame);
            countEmptyCell++;
            if (playerWin != 0 || countEmptyCell == emptyCell) break;
            computer.getHello().stepComputer();
            computer.computerProgress();
            field.displayGame();
            playerWin = field.getWinner(field.fieldGame);
            countEmptyCell++;
            if (playerWin != 0 || countEmptyCell == emptyCell) break;
        }
        helloComputer.winnerComp(playerWin, player, computer);


    }
}