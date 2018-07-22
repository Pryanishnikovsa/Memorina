import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Game extends JFrame {


    JButton button[] = new JButton[200];
    JButton buttonRestart;
    JFrame fr = new JFrame();
    ImageIcon icon = new ImageIcon("C:\\Users\\USER\\Desktop/1529760734308.jpg");
    JPanel panel = new JPanel();
    int b;

    public class TestActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){//Тута происходят все действия при нажатии на кнопку
            Object com;

            com = e.getSource();
            System.out.println(((JButton) com).getName());
        }
    }

    public void CreateBoard(int Length, int Width){
        fr.add(panel);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(Length + 1,Width));
        panel.setBounds(300,12,700,700);
        fr.setBounds(300,1,700,700);
        fr.setVisible(true);
        ActionListener actionListener = new TestActionListener();

        b = 0;
        for(int i = 1;i<=Length;i++) {
            for(int c = 1;c<=Width;c++) {

               b = i + c;
                button[b] = new JButton(icon);
                button[b].setIcon(icon);
                button[b].setName(Integer.toString(i) + Integer.toString(c));
                fr.getContentPane().add(button[b]);
                button[b].addActionListener(actionListener);
                panel.add(button[b]);
            }

        }

        fr.setVisible(true);
    }

    public static void main(String[] args){
        int[][] ResultTable; // Двумерный массив с результатом
        int Length, Width; // Переменные длина и ширина поля
        Length = 8;
        Width = 8;

        Game game = new Game();
        game.CreateBoard(Length, Width);

        ResultTable = DistributeElements.CreateDistribution(Length,Width);
        int a,b; // Счетчики циклов

        // Выводим результат на экран
            for(a=0; a <= Length-1; a++){
                for(b=0; b <= Width-1; b++){
                    System.out.print(ResultTable[a][b] + ";");
                }
                System.out.println("");
            }

    }
}
