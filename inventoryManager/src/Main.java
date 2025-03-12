import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //main frame... ahhahahahahahahahgahahahahjghahghahaijajagkldsahjgkdxzlkjxzghlkzj
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,500);

        //create new panel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }
    public static void placeComponents(JPanel panel) {
        //create text fields
        JTextField dataField = new JTextField(20);
        dataField.setBounds(50,50,75,75);
        panel.add(dataField);

        JTextField dataField1 = new JTextField(20);
        dataField1.setBounds(50,50,75,75);
        panel.add(dataField1);

        JTextField dataField2 = new JTextField(20);
        dataField2.setBounds(50,50,75,75);
        panel.add(dataField2);

        //add send button
        JButton send = new JButton("send text to file");
        send.setBounds(10, 80, 80, 25);
        panel.add(send);

        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String data1 = dataField.getText();
                String data2 = dataField1.getText();
                String data3 = dataField2.getText();
                if (data1 != null){
                    try {
                        //try to add all data from these 3 fuckers.
                        addData(data1);
                        addData(data2);
                        addData(data3);
                        updateData();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
    public static void addData(String textFieldValue) throws IOException {
        File inventoryData = new File("inventoryData.txt");        //does file exist? if not, create it!
        try {
            //new file if not already there. P.S. change the location of this to run at script start to save resources. please.
            if (inventoryData.createNewFile()) {
                System.out.println("file made, bitch." + inventoryData.getName());
            } else {
                System.out.println("file exists");
            }
        } catch (IOException e) {
            System.out.println("my program works fine, its your fault.");
        }

        //get path to file!
        Path path
                = Paths.get("inventoryData.txt");
        //attempt to write string to file.
        appendData(inventoryData, textFieldValue);
    }
    public static void appendData(File inventoryData, String data1)
        throws IOException {
        //write to the txt file
            BufferedWriter writer = new BufferedWriter(new FileWriter(inventoryData, true));
            writer.append(' ');
            writer.append(data1);
            //add a little | to the end so we can differentiate between the data types later on
            writer.append("|");

            //add new line to differentiate new ones
        String line = System.lineSeparator();
            writer.append(line);
            //make sure you close the writer or everything will explode
            writer.close();
    }
    public static void updateData() {
        //MAKE A STRING ARRAY LIST. ARRAYS DON'T WORK.
        ArrayList<String> fuckYou = new ArrayList<String>();
        try {
            //read the inventory data text file!!!
            Scanner reader = new Scanner(new FileReader("inventoryData.txt"))
                    //delimit it or something i'll be honest i kind of totally forgot about this and i don't think i did it right!
                    .useDelimiter("|\\s*");
            //WHILE THERE ARE MORE LINES
            while (reader.hasNextLine()) {
                //ADD NEXT LINE TO THE ARRAY LIST FROM EARLIER
                fuckYou.add(reader.nextLine());
            }
            //CREATE NEW FRAME FOR DATA TO GO IN. DON'T ASK WHY IT'S CALLED SEX.
            JFrame sex = new JFrame("sex");
            sex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sex.setSize(1000,500);
            JScrollPane scrollPane = new JScrollPane();
            sex.add(scrollPane);
            //idk why i put this here but. ADD ALL THE STRINGS IN THE ARRAY TO ONE LINE SO WE CAN PRINT IT OUT!!!
            String str = String.join(",", fuckYou);
            System.out.println(fuckYou);
            //stuff that doesn't work
            JTextArea textArea = new JTextArea(str);
            scrollPane.add(textArea);
            textArea.setEditable(false);
            sex.setVisible(true);

            scrollPane.setBounds(50,50,75,75);
            textArea.setBounds(50,50,75,75);
            //do not delete this because it'll result in an infinite loop, so sorry
            reader.close();
            //FILE EXCEPTION
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }
}