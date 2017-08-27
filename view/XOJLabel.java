package XOGame.view;

import javax.swing.*;
import java.awt.*;

public class XOJLabel extends JLabel {
    public XOJLabel(String name){
        setText(name);
        setFont(new Font("Courier", Font.BOLD, 20));
    }
}
