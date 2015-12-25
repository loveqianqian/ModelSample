package com.myloverqian.gui;

import net.sf.json.JSONObject;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhiwei on 2015/12/25.
 */
public class ReadFile {
    private JButton test1;
    private JButton test2;
    private JButton test4;
    private JButton button4;
    private JButton test3;
    private JButton button6;
    private JTextPane showResult;
    private JLabel result;
    private JPanel mainPanel;
    private JPanel headPanel;
    private JPanel filePanel;
    private JTextField filePath;
    private JButton open;
    private JPanel resultPanel;
    private JTextPane showResultNew;
    private JTextPane countResult;
    private JLabel orgName;
    private JLabel newName;
    private JPanel countPanel;
    private JLabel countName;

    private String path;
    private int count = 0;

    public ReadFile() {
        open.addActionListener(new openActionPerformed());
        test1.addActionListener(new sampleActionPerformed1());
        test2.addActionListener(new sampleActionPerformed2());
        test3.addActionListener(new sampleActionPerformed3());
        test4.addActionListener(new sampleActionPerformed4());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ReadFile");
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        frame.setBounds(300, 200, 800, 800);
        frame.setContentPane(new ReadFile().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * open file
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

    private class sampleActionPerformed1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            File file = new File(path);
            File[] list = file.listFiles();
            count = 0;
            StringBuffer orgSb = new StringBuffer();
            StringBuffer newSb = new StringBuffer();
            StringBuffer countSb = new StringBuffer();
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
                                orgSb.append(msg + "\n");
                                msg = msg.replace("呈\"剑鞘\"状", "呈(剑鞘)状");
                                msg = msg.replace("度\"S\"形", "度(S)形");
                            }
//                            JSONObject jsonObject = JSONObject.fromObject(msg);
//                            sb.append(jsonObject + "\n");
                            newSb.append(msg + "\n");
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
                countSb.append(count);
            }
            showResult.setText(orgSb.toString());
            showResultNew.setText(newSb.toString());
            countResult.setText(countSb.toString());
        }
    }

    private class sampleActionPerformed2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            File file = new File(path);
            File[] list = file.listFiles();
            count = 0;
            Set<String> reqs = new HashSet<String>();
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
                        if (line.contains("\"OPERATOR\":\"7516\"") || line.contains("\"OPERATOR\":\"1179\"")) {
                            String req = line.substring(line.indexOf("\"REQNO\":\"") + "\"REQNO\":\"".length(), line.indexOf("\",\"CONFIRMTIME\""));
                            reqs.add(req);
                            count++;
                        }
                    }
                } catch (Exception e1) {
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
            }
            for (String temp : reqs) {
                sb.append(temp);
            }
            showResult.setText(sb.toString());
            countResult.setText(reqs.size() + "");
        }
    }

    private class sampleActionPerformed3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            File file = new File(path);
            File[] list = file.listFiles();
            count = 0;
            Pattern pattern = Pattern.compile("//d{10}");
            Matcher matcher = null;
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
                        matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            sb.append(line);
                            count++;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                } finally {
                    try {
                        fis.close();
                        isr.close();
                        br.close();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                showResult.setText(sb.toString());
            }
        }
    }

    private class sampleActionPerformed4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            File file = new File(path);
            File[] list = file.listFiles();
            Set<String> charge = new HashSet<String>();
            Set<String> error = new HashSet<String>();
            Map<String, String> map = new HashMap<String, String>();
            Set<String> msgs = new HashSet<String>();
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
                        if (line.contains("GatherServiceImpl.java:1378")) {
                            String lis = line.substring(104, 114);
                            String res = line.substring(line.length() - 2);
                            String olRes = map.get(lis);
                            if (!"00".equals(olRes)) {
                                map.put(lis, res);
                            }
                            count++;
                        }
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue().equals("02")) {
                    System.out.println(entry.getKey());
                    charge.add(entry.getKey());
                }
            }


            System.out.println(charge.size());

            Set<String> users = new HashSet<String>();
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
                        for (String req : charge) {
                            if (line.contains(req) && line.contains("GatherServiceImpl.java:1298")) {
                                msgs.add(line.substring(111));
                                String user = line.substring(237, 241);
                                users.add(user);
                            }
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                } finally {
                    try {
                        fis.close();
                        isr.close();
                        br.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }

            for (String tempUser : users) {
                System.out.println(tempUser);
            }
            for (String msg : msgs) {
                System.out.println(msg);
            }
        }
    }
}
