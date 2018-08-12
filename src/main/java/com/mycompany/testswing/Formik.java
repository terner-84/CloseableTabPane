/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testswing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author terner
 */
public class Formik extends JFrame implements ActionListener {
    private JFrame jfrm;
    private JButton btn;
    private JButton btnNext;
    private Dimension dim;
    private JTextArea jar;
    NewMDIApplication mdi;
    
    public Formik() {
        jfrm = new JFrame("Mega Aplikace pro poštovní úřad");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //jfrm.setLocationRelativeTo(null);
        
        dim = new Dimension(800, 600);
        jfrm.setSize(dim);
        
        btn = new JButton("btn1");
        btn.addActionListener(this);
        btnNext = new JButton("btnNext");
        btnNext.addActionListener(this);
        
        jar = new JTextArea("zde nic není");
        
        jfrm.add(btn);
        jfrm.add(btnNext);
        jfrm.add(jar);
        
        jfrm.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getActionCommand().equals("btn1")) {
            mdi = new NewMDIApplication(this);
            //jar.setText(mdi.getText());
        } else if (ev.getActionCommand().equals("btnNext")) {
            System.out.println("btn btnNext clicked");
        } else if (ev.getActionCommand().contains("mdi")) {
            jar.setText(mdi.getText());
        } else {
            System.out.println("else");
        }
    }
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Formik();
            }
        });
    }
}
