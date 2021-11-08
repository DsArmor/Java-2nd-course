import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabClassUI extends JFrame{
    private final LabClass labClass;

    public LabClassUI(LabClass labClass) {
        super("First program");
        this.labClass = labClass;
        setSize(600, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar bar = new JMenuBar();
        JMenu sort = new JMenu("Sort");
        JMenuItem sortByGPA = new JMenuItem("Sort by GPA");

        JPanel panel = new JPanel(new FlowLayout());

        JTextField searchField = new JTextField("Введите фамилию",30);
        JButton findButton = new JButton("Найти студента");
        Object[] headers = {"Id","Фамилия","Средний балл"};
        Object[][] data = new Object[labClass.getStudents().size()][headers.length];
        fillTableData(data);
        JTable studTable = new JTable(new DefaultTableModel(data,headers));
        findButton.setToolTipText("Нажмите, чтобы найти студента");
        panel.add(searchField);
        panel.add(findButton);
        getContentPane().add(new JScrollPane(studTable), BorderLayout.CENTER);

        getContentPane().add(panel, BorderLayout.NORTH);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    checkTextField(searchField);
                    if(labClass.find(searchField.getText())){
                        JOptionPane.showMessageDialog(null,"Существует");
                    }
                } catch (EmptyStringException | StudentNotFoundException except) {
                    JOptionPane.showMessageDialog(null,except.getMessage());
                }
            }
        });
        sortByGPA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labClass.sortByGPA();

                DefaultTableModel dtm = (DefaultTableModel) studTable.getModel();
                int n =  labClass.getStudents().size();
                for (int i = n - 1; i >= 0; i--)
                {
                    dtm.removeRow(i);
                    Student st = labClass.getStudents().get(i);
                    dtm.insertRow(i, new Object[]{st.getId(), st.getName(),st.getGPA()});
                }
                fillTableData(data);
            }
        });
        sort.add(sortByGPA);
        bar.add(sort);
        setJMenuBar(bar);
        setVisible(true);
    }

    private void checkTextField(JTextField searchField)
    {
        if (searchField.getText().equals(""))
            throw new EmptyStringException();
    }

    private void fillTableData(Object[][] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            data[i][0] = labClass.getStudents().get(i).getId();
            data[i][1] = labClass.getStudents().get(i).getName();
            data[i][2] = labClass.getStudents().get(i).getGPA();
        }
    }

}
