package XOGame.view;

import XOGame.controller.GameController;
import XOGame.modul.Point;
import XOGame.modul.FieldGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kopra on 22.07.2017.
 */
public class GameWindow extends JFrame implements GUIvable {
    private static final int WIDTH_WINDOW = 350;
    private static final int HEIGHT_WINDOW = 350;
    private static final String TITLE_GAME = "XO Game";

    JPanel panel = new XOJPanel();
    static JButton[][] buttons;
    FieldGame fieldGame = new FieldGame();
    JFrame window = new XOJFrame(TITLE_GAME, WIDTH_WINDOW, HEIGHT_WINDOW);

    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }



    public void setFieldGame(FieldGame fieldGame) {
        this.fieldGame = fieldGame;
    }

    public void initWindow() {

        //       panel.setLayout(new FlowLayout());//по умолчания для JPanel
        panel.setLayout(new GridLayout(3, 3, 4, 4));
        int numbcell = 1;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                JButton buttonTemp = new XOJButton();
//                buttonTemp.setText(Integer.toString(numbcell++));//переводим числа в строку
                buttonTemp.setText("");
                buttons[i][j] = buttonTemp;
                panel.add(buttonTemp);
                int finalJ = j;
                int finalI = i;
                buttonTemp.addActionListener(new ActionListener() {//слушатель для кнопки
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String buttonText = e.getActionCommand();//передаем на какую кнопку нажали
//                        buttons[finalJ][finalI] = (JButton) e.getSource();
//                        buttons[finalJ][finalI].setText("X");
                        //обращение к контроллеру и осуществление выстрела по нажатой кнопке
                        GameController.doShoot(new Point(finalJ, finalI));
                    }
                });
            }

        }

        window.add(panel);//добавляем панель в окно
        window.setVisible(true);
    }

    @Override
    public void hello() {
        System.out.println("Здравствуйте!\n" +
                "Выберите режим игры: 1 - Player1 vs Player2, 2 - Player1 vs Computer\n" +
                "Для выхода нажмите 0");
    }

    @Override
    public boolean show_winner(FieldGame field) {
        boolean isWin = false;
        if (field.getWinner(FieldGame.Type.O)) {
            System.out.println("Победил комп!");
            isWin = true;
        }
        if (field.getWinner(FieldGame.Type.X)) {
            System.out.println("Победил игрок!");
            isWin = true;
        }
        return isWin;
    }

    public void showField(FieldGame.Type[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                switch (cells[i][j]) {
                    case O:
                        System.out.print("O");
                        break;
                    case X:
                        System.out.print("X");
                        break;
                    case NOT_SET:
                        System.out.print(".");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
