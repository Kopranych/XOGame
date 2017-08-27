package XOGame.view;

import javax.swing.*;

/**
 * Created by kopra on 11.08.2017.
 */
public class XOJFrame extends JFrame {
    public XOJFrame(String TitleName, int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(TitleName);
        setResizable(false);//запрет на изменение размера окна
        setIconImage(new ImageIcon("gameicon.png").getImage());
    }
}
