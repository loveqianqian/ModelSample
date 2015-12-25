package com.myloverqian.gui;

import net.sf.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by zhiwei on 2015/12/25.
 */
public class ReadFile {
    private JButton test1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JTextArea showResult;
    private JLabel result;
    private JPanel mainPanel;
    private JPanel headPanel;
    private JPanel filePanel;
    private JTextField filePath;
    private JButton open;

    private String path;
    private int count = 0;

    public ReadFile() {
        open.addActionListener(new openActionPerformed());
        test1.addActionListener(new sampleActionPerformed1());
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
     * 加载路径按钮
     */
    private class openActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jfc.showDialog(new JLabel(), "swift");
            File file = jfc.getSelectedFile();
            System.out.println("directory:" + file.getAbsolutePath());
            filePath.setText(file.getAbsolutePath());
            path = file.getAbsolutePath();
        }
    }

    /**
     * 第一个分析方法
     */
    private class sampleActionPerformed1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            File file = new File(path);
            File[] list = file.listFiles();
            count = 0;
            StringBuffer sb = new StringBuffer();
            for (File tf : list) {
                FileInputStream fis = null;
                InputStreamReader isr = null;
                BufferedReader br = null;
                try {
                    fis = new FileInputStream(tf);
                    isr = new InputStreamReader(fis, "GBK");
                    br = new BufferedReader(isr);
                    String line = "";
                    while ((line = br.readLine()) != null) {
                        if (line.contains("检查报告数据")) {
                            String msg = line.substring(line.indexOf("检查报告数据：") + "检查报告数据：".length());
                            if (line.contains("呈\"剑鞘\"状") || line.contains("度\"S\"形")) {
                                sb.append("原来的值：" + "\n" + msg + "\n");
                                msg = msg.replace("呈\"剑鞘\"状", "呈(剑鞘)状");
                                msg = msg.replace("度\"S\"形", "度(S)形");
                            }
//                            JSONObject jsonObject = JSONObject.fromObject(msg);
//                            sb.append(jsonObject + "\n");
                            sb.append("现在的值：" + "\n" +msg + "\n");
                            count++;
                        }
                    }
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } finally {
                    try {
                        fis.close();
                        isr.close();
                        br.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                sb.append("总数:" + count);
            }
            showResult.setText(sb.toString());
        }
    }
}
