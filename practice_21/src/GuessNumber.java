import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessNumber extends JFrame {
    private int randomNum;
    private final int greatestNumber = 20;
    private int attempts = 3;
    private Random random = new Random();

    JTextArea jta1 = new JTextArea(1, 4);
    JScrollPane jScrollPane = new JScrollPane(jta1);
    JButton button = new JButton("Try");

    public GuessNumber() {
        super("Guess number");
        this.randomNum = random.nextInt(greatestNumber);
        setSize(300, 300);

        setLayout(new FlowLayout());
        add(jScrollPane);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int num = Integer.parseInt(jta1.getText());
                if (num == randomNum) {
                    JOptionPane.showMessageDialog(null, "You win!", "Win message", JOptionPane.INFORMATION_MESSAGE);
                    restart();
                }
                else if (num > randomNum) {
                    attempts -=1;
                    if (attempts == 0)
                        restart();
                    else
                        JOptionPane.showMessageDialog(null, "The hidden number is less, You have: " + attempts +" attempts left", "Try again", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    attempts -=1;
                    if (attempts == 0)
                        restart();
                    else
                        JOptionPane.showMessageDialog(null, "The hidden number is greater. You have: " + attempts +" attempts left", "Try again", JOptionPane.INFORMATION_MESSAGE);
                }
                jta1.setText("");
            }
        });
    }

    public void restart() {
        if (attempts == 0)
            JOptionPane.showMessageDialog(null, "You`ve lost\n" + greatestNumber + " - our choice", "Lost message", JOptionPane.INFORMATION_MESSAGE);
        randomNum = random.nextInt(greatestNumber);
        attempts = 3;
    }

    public static void main(String[] args) {
        new GuessNumber().setVisible(true);
    }
}
