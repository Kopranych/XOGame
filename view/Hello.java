package XOGame.view;

import XOGame.modul.Computer;
import XOGame.modul.Player;

import java.util.Scanner;

/**
 * Created by kopra on 23.06.2017.
 */
public class Hello {
    Player player;
    Computer computer;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCompyter(Computer compyter) {
        this.computer = compyter;
    }


    public void hello() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите своё имя");
        player.setName(sc.nextLine());
        System.out.println("Приветствую вас " + player.getName());
    }

    public void stepPlayer() {
        System.out.println("Ходит игрок " + player.getName());
    }

    public void stepComputer() {
        System.out.println("Ходит  " + computer.getName());
    }

    public void winnerPlayer(int win, Player man, Player man2) {
        int player = 1;
        int player2 = 2;
        if (win == player) {
            System.out.println("Победитель " + man.getName() + "!");
        } else if (win == player2)
            System.out.println("Победитель " + man2.getName() + "!");
        else System.out.println("Ничья!");
    }

    public void winnerComp(int win, Player man, Computer man2) {
        int player = 1;
        int player2 = 2;
        if (win == player) {
            System.out.println("Победитель " + man.getName() + "!");
        } else if (win == player2)
            System.out.println("Победитель " + man2.getName() + "!");
        else System.out.println("Ничья!");
    }
}
