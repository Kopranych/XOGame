package XOGame.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kopra on 12.08.2017.
 */
public class XOJButton extends JButton {

    public XOJButton() {
        setFont(new Font("Courier", Font.ITALIC, 20));

    }

    public XOJButton(String buttonText){
        setText(buttonText);
    }

    public XOJButton(String buttonText, int whidth, int height) {
        this(buttonText);
        setSize(whidth, height);
    }
}
