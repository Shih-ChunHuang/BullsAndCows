package UI;

import model.PlayGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import com.apple.eawt.Application;

/**
 * Created by Shih-Chun on 2017-05-10.
 */
public class UserView {
    private JButton Start;
    private JPanel mainPanel;
    private JButton Exit;
    private JPanel secondPanel;
    private JLabel Intro;
    private JLabel Intro2;
    private JLabel Intro3;
    private JLabel Intro4;
    public String input;



    public UserView() {
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = JOptionPane.showInputDialog(null, "Guess a four digit number:");
                PlayGame game = new PlayGame();
                boolean isFinished = game.gameProcess(input);
                if (isFinished){
                    JOptionPane.showMessageDialog(null, "Congrats! You got it!");

                }else{
                    JOptionPane.showMessageDialog(null, "Bye Bye!");
                }
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private static class SetIcon extends JFrame{

        public SetIcon() {


            Image icon = new ImageIcon(getClass().getResource("/cow.png")).getImage();
            setIconImage(icon);
            Application.getApplication().setDockIconImage(icon);

//            setIconImage(new ImageIcon("src/res/cow.png").getImage());
//            Application.getApplication().setDockIconImage(
//                    new ImageIcon("src/res/cow.png").getImage());
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {


        JFrame view = new JFrame("Welcome to Bulls and Cows");


//        String curDir = System.getProperty("user.dir");
//        File gradeList = new File("src/res/cow.png");
//        System.out.println("Current sys dir: " + curDir);
//        System.out.println("Current abs dir: " + gradeList.getAbsolutePath());
//
//
//        if(!gradeList.exists()) {
//            System.out.println("Failed to find file");
//
//        }
//
//        BufferedImage myPicture = ImageIO.read(gradeList);
//
//        view.setIconImage(myPicture);



//        Image openIcon = new ImageIcon("src/res/cow.png").getImage();
//        view.setIconImage(openIcon);




        view.setContentPane(new UserView().mainPanel);

        SetIcon s = new SetIcon();
        s.setVisible(true);

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.pack();
        view.setVisible(true);


        }



}
