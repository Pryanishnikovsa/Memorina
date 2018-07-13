import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.JTextComponent;
public class Game extends JFrame {

    JButton button[] = new JButton[67];
    JFrame fr = new JFrame();
    ImageIcon icon = new ImageIcon("C:\\Users\\USER\\Desktop/1529760734308.jpg");
    JPanel panel = new JPanel();

    public class TestActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){//Тута происходят все действия при нажатии на кнопку
            //System.out.println("123");
            //System.out.println(e.getSource().GetName());

            //Object com;
            //String str;

            //com = (JButton) e.getSource();
            //System.out.println(com.GetName());
            //tr = ((JTextComponent) com).getText();
            //System.out.print(((JTextComponent) com).getText()+"__");

        }
    }

    public void CreateBoard(){
        fr.add(panel);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(9,8));
        fr.setBounds(300,0,700,700);
        fr.setVisible(true);
        ActionListener actionListener = new TestActionListener();

        for(int i = 1;i<65;i++) {
           button[i] = new JButton(icon);
           button[i].setIcon(icon);
           button[i].setName(Integer.toString(i));
           fr.getContentPane().add(button[i]);
           button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 1; i < 65; i++) {
                        button[i].addActionListener(actionListener);
                    }
                }
            }
            );
            panel.add(button[i]);
        }

        JButton cancelbutton = new JButton("Выход");
        cancelbutton.addActionListener(new ActionListener() {//Слушатель для кнопки выход
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.dispose();//Закрывает frame
            }
        });
        button[66] = new JButton("Перезагрузка");
        panel.add(cancelbutton);
        panel.add(button[66]);

        fr.setVisible(true);
    }



    public static void main(String[] args){
        Game game = new Game();
        game.CreateBoard();

        int[][] ResultTable; // Двумерный массив с результатом
        int Length, Width; // Переменные длина и ширина поля
        Length = 8;
        Width = 8;
        //DistributeElements distributeElements = new DistributeElements();
        ResultTable = DistributeElements.CreateDistribution(Length,Width);
        int a,b; // Счетчики циклов

        // Выводим результат на экран
            for(a=0; a <= Length-1; a++){
                for(b=0; b <= Width-1; b++){
                    System.out.print(ResultTable[a][b] + ";");
                }
                System.out.println("");
            }
//    }
    }
}
