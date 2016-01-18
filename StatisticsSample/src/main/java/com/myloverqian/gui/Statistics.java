package com.myloverqian.gui;

import java.awt.event.*;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.myloverqian.control.GenerateFile;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author zhiwei
 */
public class Statistics extends JDialog {

    private static String pathUrl = "";

    public Statistics(Frame owner) {
        super(owner);
        initComponents();
    }

    public Statistics(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        GenerateFile generate = new GenerateFile(pathUrl);
        generate.generateMethod();
    }

    private void selectButtonActionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showDialog(new JPanel(), "save location");
        File file = fileChooser.getSelectedFile();
        if (file.isDirectory()) {
            path.setText(file.getAbsolutePath());
            pathUrl = file.getAbsolutePath();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        panel1 = new JPanel();
        path = new JTextField();
        Spacer vSpacer1 = new Spacer();
        Spacer hSpacer1 = new Spacer();
        buttonBar = new JPanel();
        okButton = new JButton();
        Select = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(Borders.createEmptyBorder("7dlu, 7dlu, 7dlu, 7dlu"));
            dialogPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setLayout(new GridLayoutManager(5, 6, new Insets(0, 0, 0, 0), -1, -1));
                panel1.add(path, new GridConstraints(1, 0, 1, 6,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
                panel1.add(vSpacer1, new GridConstraints(2, 4, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        null, null, null));
                panel1.add(hSpacer1, new GridConstraints(3, 0, 1, 4,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        null, null, null));
            }
            dialogPane.add(panel1, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(Borders.createEmptyBorder("5dlu, 0dlu, 0dlu, 0dlu"));
                buttonBar.setLayout(new FormLayout(
                        "$glue, $button, $rgap, $button",
                        "pref"));

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        okButtonActionPerformed(e);
                    }
                });
                buttonBar.add(okButton, CC.xy(2, 1));

                //---- Select ----
                Select.setText("Select");
                Select.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        selectButtonActionPerformed(e);
                    }
                });
                buttonBar.add(Select, CC.xy(4, 1));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel panel1;
    private JTextField path;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton Select;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
