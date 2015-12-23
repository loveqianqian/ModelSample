package com.myloverqian.gui;

import javax.swing.*;

/**
 * Created by zhiwei on 2015/12/23.
 */
public class ToolFrame {
    private JPanel ToolFrame;
    private JButton getResult;
    private JTextPane showResult;



    public static void main(String[] args) {
        JFrame frame = new JFrame("ToolFrame");
        frame.setContentPane(new ToolFrame().ToolFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
