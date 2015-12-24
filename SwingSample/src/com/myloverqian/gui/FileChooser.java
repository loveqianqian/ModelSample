package com.myloverqian.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by zhiwei on 2015/12/24.
 */
public class FileChooser extends JFrame implements ActionListener {
    JButton open = null;

    public static void main(String[] args) {
        new FileChooser();
    }

    public FileChooser() {
        open = new JButton("open");
        this.add(open);
        this.setBounds(400, 200, 100, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        open.addActionListener(this);
    }

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
