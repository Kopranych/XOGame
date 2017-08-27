package XOGame.controller;

import XOGame.view.XOJButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kopra on 19.08.2017.
 */
public class ListenerMenuBattons implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(e.getSource() instanceof JButton)){
            return;
        }

        XOJButton tempButton = (XOJButton)e.getSource();
        String temp = e.getActionCommand();

        if(temp.equals("START")){
            GameController.startGame();
        }
    }
}
