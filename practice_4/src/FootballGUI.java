import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FootballGUI extends JFrame {
    int milanGoals = 0;
    int realGoals = 0;
    JLabel score = new JLabel("Result: 0 X 0");
    JLabel lastScorer = new JLabel("Last scorer: N/A");
    JLabel winner = new JLabel("WINNER:Draw");
    JButton acMilan = new JButton("AC Milan");
    JButton realMadrid = new JButton("Real Madrid");
    public FootballGUI(){
        super("Football Match");
        setLayout(null);
        acMilan.setBounds(50,50,200,50);
        realMadrid.setBounds(300,50,200,50);
        score.setBounds(235,100,150,100);
        lastScorer.setBounds(235,200,150,100);
        winner.setBounds(235,300,150,100);
        acMilan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanGoals++;
                score.setText("Result: " + milanGoals + " X " + realGoals);
                lastScorer.setText("Last scorer: AC Milan");
                winner.setText(setWinner());
            }
        });
        realMadrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realGoals++;
                score.setText("Result: " + milanGoals + " X " + realGoals);
                lastScorer.setText("Last scorer: Real Madrid");
                winner.setText(setWinner());
            }
        });
        add(acMilan);
        add(realMadrid);
        add(score);
        add(winner);
        add(lastScorer);
        setSize(600,500);
    }
    public String setWinner(){
        if (milanGoals > realGoals){
            return "WINNER: AC Milan";
        }
        else if (realGoals > milanGoals){
            return "WINNER: Real Madrid";
        }
        else return "WINNER: Draw";
    }
}
