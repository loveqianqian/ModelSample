/*
 * Created by JFormDesigner on Mon Dec 28 22:13:54 CST 2015
 */

package com.myloverqian.gui;

import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.myloverqian.util.*;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zhiwei
 */
public class FileSample extends JFrame {
    private static String locationPath = "";
    private static int count = 0;

    public FileSample() {
        initComponents();
    }

    public static void main(String[] args) {
        new FileSample().setVisible(true);
    }

    private void fileActionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showDialog(new JPanel(), "\u9009\u62e9\u6587\u4ef6");
        File file = chooser.getSelectedFile();
        if (file.isDirectory()) {
            path.setText(file.getAbsolutePath());
            locationPath = file.getAbsolutePath();
        }
    }

    private void method1ActionPerformed(ActionEvent e) {
        count = 0;
        Separate1 separate1 = new Separate1();
        String result = "";
        try {
            result = separate1.methodSelf(count, locationPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        showResult.setText("显示结果：" + result);
    }

    private void methoed2ActionPerformed(ActionEvent e) {
        count = 0;
        Separate2 separate2 = new Separate2();
        String result = "";
        try {
            result = separate2.methodSelf(count, locationPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        showResult.setText("显示结果：" + result);
    }

    private void method3ActionPerformed(ActionEvent e) {
        count = 0;
        Separate3 separate3 = new Separate3();
        String result = "";
        try {
            result = separate3.methodSelf(count, locationPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        showResult.setText("显示结果：" + result);
    }

    private void method4ActionPerformed(ActionEvent e) {
        count = 0;
        Separate4 separate4 = new Separate4();
        String result = "";
        try {
            result = separate4.methodSelf(count, locationPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        showResult.setText("显示结果：" + result);
    }

    private void method5ActionPerformed(ActionEvent e) {
        count = 0;
        Separate5 separate5 = new Separate5();
        String result = "";
        try {
            result = separate5.methodSelf(count, locationPath);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        showResult.setText("显示结果：" + result);
    }

    private void method6ActionPerformed(ActionEvent e) {
        String result = "=2015-12-18 01:55:24,441 INFO  [http-8080-5] impl.GatherServiceImpl " +
                "(GatherServiceImpl.java:1298)     - 检验确认数据：";
        showResult.setText("显示结果：" + String.valueOf(result.length()));
    }

    private void saveButtonActionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showDialog(new JPanel(), "\u9009\u62e9\u6587\u4ef6");
        File file = chooser.getSelectedFile();
        String saveLocationPath = "";
        if (file.isDirectory()) {
            saveLocationPath = file.getAbsolutePath();
        }
        String saveLocationName = "logFile" + System.currentTimeMillis() + ".txt";
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(saveLocationPath + "\\" + saveLocationName,
                    true));
            bufferedWriter.write(showResult.getText().toString());
            JOptionPane.showConfirmDialog(this, "保存成功", "保存文件", JOptionPane.YES_OPTION);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, "保存失败", "保存文件", JOptionPane.YES_OPTION);
            e1.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void allButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        file = new JMenuItem();
        method1 = new JMenuItem();
        methoed2 = new JMenuItem();
        method3 = new JMenuItem();
        method4 = new JMenuItem();
        method5 = new JMenuItem();
        method6 = new JMenuItem();
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        pathName = new JLabel();
        path = new JLabel();
        scrollPane1 = new JScrollPane();
        showResult = new JTextArea();
        buttonBar = new JPanel();
        saveButton = new JButton();
        allButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //---- file ----
            file.setText("\u6587\u4ef6");
            file.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fileActionPerformed(e);
                }
            });
            menuBar1.add(file);

            //---- method1 ----
            method1.setText("\u65b9\u6cd51");
            method1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    method1ActionPerformed(e);
                    method1ActionPerformed(e);
                }
            });
            menuBar1.add(method1);

            //---- methoed2 ----
            methoed2.setText("\u65b9\u6cd52");
            methoed2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    methoed2ActionPerformed(e);
                }
            });
            menuBar1.add(methoed2);

            //---- method3 ----
            method3.setText("\u65b9\u6cd53");
            method3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    method3ActionPerformed(e);
                }
            });
            menuBar1.add(method3);

            //---- method4 ----
            method4.setText("\u65b9\u6cd54");
            method4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    method4ActionPerformed(e);
                }
            });
            menuBar1.add(method4);

            //---- method5 ----
            method5.setText("\u65b9\u6cd55");
            method5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    method5ActionPerformed(e);
                }
            });
            menuBar1.add(method5);

            //---- method6 ----
            method6.setText("\u65b9\u6cd56");
            method6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    method6ActionPerformed(e);
                }
            });
            menuBar1.add(method6);
        }
        setJMenuBar(menuBar1);

        //======== dialogPane ========
        {
            dialogPane.setBorder(Borders.createEmptyBorder("7dlu, 7dlu, 7dlu, 7dlu"));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BorderLayout());

                //======== panel1 ========
                {
                    panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));

                    //---- pathName ----
                    pathName.setText("\u9009\u62e9\u7684\u4f4d\u7f6e:");
                    panel1.add(pathName);
                    panel1.add(path);
                }
                contentPanel.add(panel1, BorderLayout.NORTH);
            }
            dialogPane.add(contentPanel, BorderLayout.PAGE_START);

            //======== scrollPane1 ========
            {

                //---- showResult ----
                showResult.setText("\u663e\u793a\u7ed3\u679c:");
                showResult.setEditable(false);
                scrollPane1.setViewportView(showResult);
            }
            dialogPane.add(scrollPane1, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(Borders.createEmptyBorder("5dlu, 0dlu, 0dlu, 0dlu"));
                buttonBar.setLayout(new FormLayout(
                    "$glue, $button, $rgap, $button",
                    "pref"));

                //---- saveButton ----
                saveButton.setText("\u4fdd\u5b58");
                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        saveButtonActionPerformed(e);
                    }
                });
                buttonBar.add(saveButton, CC.xy(2, 1));

                //---- allButton ----
                allButton.setText("\u6267\u884c\u6240\u6709");
                allButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        allButtonActionPerformed(e);
                    }
                });
                buttonBar.add(allButton, CC.xy(4, 1));
            }
            dialogPane.add(buttonBar, BorderLayout.PAGE_END);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(400, 300);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenuItem file;
    private JMenuItem method1;
    private JMenuItem methoed2;
    private JMenuItem method3;
    private JMenuItem method4;
    private JMenuItem method5;
    private JMenuItem method6;
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel pathName;
    private JLabel path;
    private JScrollPane scrollPane1;
    private JTextArea showResult;
    private JPanel buttonBar;
    private JButton saveButton;
    private JButton allButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
