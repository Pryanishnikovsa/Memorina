import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.*;

public class TestFrame {
    public static void showIcon(JButton button, ImageIcon icon) {
        button.setIcon(icon);
    }



    public static void createGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Image image;
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ImageIcon icon = new ImageIcon(this.getClass().getResource("/ball.gpg"));
        //icon.setImage();
        ImageIcon icon = new ImageIcon("C:\\temp/ball.jpg");

        // POSITION OF THE PICTURE1

        JButton leftButton = new JButton("qwe", icon);
        //leftButton.setIcon(icon);123
        showIcon(leftButton, icon);
        frame.getContentPane().add(leftButton);

        frame.setPreferredSize(new Dimension(200, 100));

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }
}