package XOGame.modul;

import XOGame.view.GameWindow;

import javax.swing.*;

/**
 * Created by kopra on 15.06.2017.
 */
public class FieldGame {
    private static final int XCOORD = 3;
    private static final int YCOORD = 3;
    private char cross = 'X';
    private final char toe = 'O';
    public char[][] fieldGame = new char[YCOORD][XCOORD];
    static private GameWindow window;
    private JButton[][] buttons;

    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    public void setWindow(GameWindow window) {
        this.window = window;
    }


    JButton[][] tempButton = new JButton[3][3];

    public enum Type{X, O, NOT_SET}

    Type[][] cells;

    public char getCross() {
        return cross;
    }

    public void setCross(char cross) {
        this.cross = cross;
    }

    public char getToe() {
        return toe;
    }

    public FieldGame(){
        cells = new Type[YCOORD][XCOORD];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = Type.NOT_SET;
            }

        }
    }

    public void initGame() {
        int numbercells = 1;
        String letter;
        for (int i = 0; i < fieldGame.length; i++) {
            for (int j = 0; j < fieldGame.length; j++) {
                letter = Integer.toString(numbercells++);//переводим числа в строку
                fieldGame[i][j] = letter.charAt(0);//строку переводим в символ
            }
        }
    }


    public boolean doShoot(Point point, FieldGame.Type type){

        boolean isBusy;

            if(cells[point.getX()][point.getY()] != type.X &&
                    cells[point.getY()][point.getX()] != type.O) {
                cells[point.getY()][point.getX()] = type;
                if (type == type.O)
                    buttons[point.getY()][point.getX()].setText("O");
                else buttons[point.getY()][point.getX()].setText("X");

                isBusy = true;
            }else isBusy = false;
            return isBusy;

    }

    public void displayGame() {
        for (int i = 0; i < fieldGame.length; i++) {
            for (int j = 0; j < fieldGame.length; j++) {
                System.out.print(" " + fieldGame[i][j]);
                if (j < 2) {
                    System.out.print(" |");
                }
            }
            System.out.println(" ");
            if (i < 2) {
                System.out.println("---|---|---");
            }
        }
    }

    public boolean getWinner(Type t) {

        boolean isWin = false;

        for (int i = 0; i < cells.length; i++) {
            if (cells[i][0] == t && cells[i][1] == t && cells[i][2] == t) {
                isWin = true;
            }
        }
        for (int i = 0; i < cells.length; i++) {
            if (cells[0][i] == t && cells[1][i] == t && cells[2][i] == t) {
                isWin = true;
            }
        }
        if (cells[0][0] == t && cells[1][1] == t && cells[2][2] == t) {
                isWin = true;
        }
        if (cells[2][0] == t && cells[1][1] == t && cells[0][2] == t) {
                isWin = true;
        }
        return isWin;
    }

    public int getWinner(char[][] fieldGame) {

        int player1 = 1;
        int player2 = 2;
        int draw = 0;

        for (int i = 0; i < fieldGame.length; i++) {
            if (fieldGame[i][0] == fieldGame[i][1] && fieldGame[i][1] == fieldGame[i][2]) {
                if (fieldGame[i][i] == cross)
                    return player1;
                else return player2;
            }
        }
        for (int i = 0; i < fieldGame.length; i++) {
            if (fieldGame[0][i] == fieldGame[1][i] && fieldGame[1][i] == fieldGame[2][i]) {
                if (fieldGame[i][i] == cross)
                    return player1;
                else return player2;
            }
        }
        if (fieldGame[0][0] == fieldGame[1][1] && fieldGame[1][1] == fieldGame[2][2]) {
            if (fieldGame[1][1] == cross)
                return player1;
            else return player2;
        }
        if (fieldGame[2][0] == fieldGame[1][1] && fieldGame[1][1] == fieldGame[0][2]) {
            if (fieldGame[1][1] == cross)
                return player1;
            else return player2;
        }
        return draw;
    }
}
