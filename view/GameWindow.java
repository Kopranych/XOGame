package XOGame.view;

import XOGame.controller.GameController;
import XOGame.controller.ListenerMenuBattons;
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


    private JPanel panel = new XOJPanel();
    private static JButton[][] buttons;
    private FieldGame fieldGame = new FieldGame();
    private JFrame window;
    private XOJPanel panelMenu = new XOJPanel();
    private XOJPanel panelStateGame = new XOJPanel();
    private XOJButton[] buttonsMenu = new XOJButton[1];
    private XOJLabel labelStateGame = new XOJLabel("Game");

    private static boolean isContinue;

    public static void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    public void setFieldGame(FieldGame fieldGame) {
        this.fieldGame = fieldGame;
    }

    public void continueGame() {
        isContinue = false;
        while (!isContinue) ;
    }

    public void initMenu() {

        window.setLayout(new GridLayout(1, 1));
        panelMenu.setLayout(new FlowLayout());

        buttonsMenu[0] = new XOJButton("START");
        buttonsMenu[0].addActionListener(new ListenerMenuBattons());

        panelMenu.add(buttonsMenu[0]);
        window.getContentPane().add(panelMenu);
        window.setVisible(true);

        continueGame();
    }

    public void setLabelStateGame(XOJLabel labelStateGame) {
        this.labelStateGame = labelStateGame;
    }

    public void initWindowFieldGame() {
        //panel.setLayout(new FlowLayout());//по умолчания для JPanel
        panelStateGame.add(labelStateGame);
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

        window.add(panel, BorderLayout.CENTER);//добавляем панель в окно
        window.add(panelStateGame, BorderLayout.NORTH);
        window.setVisible(true);

    }

    public void clearWindow(XOJFrame window) {

        this.window = window;
        for (int i = 0; i < buttons.length; i++) {
            panel.remove(i);
        }
        this.window.remove(panel);
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
            labelStateGame.setText("Победил комп!");
            isWin = true;
        }
        if (field.getWinner(FieldGame.Type.X)) {
            labelStateGame.setText("Победил игрок!");
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
