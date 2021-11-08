package ex3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class editorGUI extends JFrame {

    private final ICreateDocument createDocument;

    public editorGUI(ICreateDocument createDocument) {
        super(createDocument.name());
        this.createDocument = createDocument;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createMenu());
        setJMenuBar(menuBar);
        setVisible(true);
    }

    private JMenu createMenu() {
        JMenu file = new JMenu("File");
        JMenuItem newFile = new JMenuItem("New");
        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Create " + createDocument.name());
                createDocument.createNew();
            }
        });
        JMenuItem openFile = new JMenuItem("Open");
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open " + createDocument.name());
                createDocument.createOpen();
            }
        });
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem exitFile = new JMenuItem("Exit");
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(exitFile);
        return file;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String typeDocument = in.next();
        switch (typeDocument) {
            case "Text":
                new editorGUI(new CreateTextDocument());
            case "Music":
                new editorGUI(new CreateMusicDocument());
            case "Image":
                new editorGUI(new CreateImageDocument());
        }
    }
}

