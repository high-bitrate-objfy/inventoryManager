import javax.swing.*;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        //create new panel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        //create text field
        JTextField textData1 = new JTextField(20);
        textData1.setBounds(100, 20, 165, 25);
        panel.add(textData1);

        JTextField textData2 = new JTextField(20);
        textData2.setBounds(100, 20, 165, 25);
        panel.add(textData2);

        JTextField textData3 = new JTextField(20);
        textData3.setBounds(100, 20, 165, 25);
        panel.add(textData3);

        //add send button
        JButton send = new JButton("send text to file");
        send.setBounds(10, 80, 80, 25);
        panel.add(send);

        //data label
        JLabel dataLabel = new JLabel("text here");
        dataLabel.setBounds(10, 20, 80, 25);
        panel.add(dataLabel);
    }
}