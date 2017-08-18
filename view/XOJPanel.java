package XOGame.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by kopra on 12.08.2017.
 */
public class XOJPanel extends JPanel {

    public XOJPanel(LayoutManager layout, int rows, int cols) {
        setLayout(new GridLayout(rows,cols));
    }
    public XOJPanel(){
        setBorder(BorderFactory.createEtchedBorder());
        setSize(20,20);
    }
}
