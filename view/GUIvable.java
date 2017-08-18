package XOGame.view;

import XOGame.modul.FieldGame;

import javax.swing.*;

/**
 * Created by kopra on 27.07.2017.
 */
public interface GUIvable {
    void initWindow();
    void hello();
    boolean show_winner(FieldGame field);
}
