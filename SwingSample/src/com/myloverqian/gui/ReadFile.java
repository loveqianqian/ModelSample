package com.myloverqian.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by zhiwei on 2015/12/25.
 */
public class ReadFile implements ActionListener {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JTextPane textPane1;
    private JLabel result;
    private JPanel mainPanel;
    private JPanel headPanel;
    private JPanel filePanel;
    private JTextField textField1;
    private JButton open;

    public ReadFile() {
        open.addActionListener(this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ReadFile");
        frame.setBounds(400, 200, 600, 600);
        frame.setContentPane(new ReadFile().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.showDialog(new JLabel(), "swift");
        File file = jfc.getSelectedFile();
        if (file.isDirectory()) {
            System.out.println("directory:" + file.getAbsolutePath());
        }
        System.out.println(jfc.getSelectedFile().getName());
    }
}
