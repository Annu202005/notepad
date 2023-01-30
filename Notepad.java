/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.notepad;

/**
 *
 * @author DELL
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.text.*;
import java.io.*;
import java.lang.*;

public class Notepad extends JFrame implements ActionListener {
JTextArea t;
JFrame f;
Notepad() //intialising the frame and text area
{
    f= new JFrame("Notepad");
    t= new JTextArea();

JMenuBar menu= new JMenuBar(); //creating menu
JMenu file= new JMenu("file");
JMenuItem f1= new JMenuItem("new");
JMenuItem f2= new JMenuItem("open");
JMenuItem f3= new JMenuItem("save");
JMenuItem f4= new JMenuItem("print");
f1.addActionListener(this); //adding action listener to individual items
f2.addActionListener(this);
f3.addActionListener(this);
f4.addActionListener(this);

file.add(f1); //adding it to the menu
file.add(f2);
file.add(f3);
file.add(f4);

JMenu edit= new JMenu("edit");
JMenuItem f5= new JMenuItem("cut");
JMenuItem f6= new JMenuItem("copy");
JMenuItem f7= new JMenuItem("paste");
f5.addActionListener(this); //adding action listener to individual items
f6.addActionListener(this);
f7.addActionListener(this);


edit.add(f5); //adding it to the edit menu
edit.add(f6);
edit.add(f7);

JMenuItem close= new JMenuItem("close");
menu.add(file);
menu.add(edit);
menu.add(close);
f.setJMenuBar(menu);
f.add(t);
f.setSize(1000,1000);
f.show();
}

@Override
public void actionPerformed(ActionEvent e) //functionality implement
{ String s= e.getActionCommand();
switch(s){   //processing the string s
    case "new":
    t.setText("");
    break;
    case "open":
         JFileChooser j=new JFileChooser("C:");
                int r=j.showOpenDialog(null);
                if(r==JFileChooser.APPROVE_OPTION){
                    File fi=new File(j.getSelectedFile().getAbsolutePath());
                    String s1,s2;
                    try {
                        FileReader fr=new FileReader(fi);
                        BufferedReader br=new BufferedReader(fr);
                        s1=br.readLine();
                        while((s2=br.readLine())!=null){
                            s1=s1+"\n"+s2;
                        }
                        t.setText(s1);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(f,"operation canceled");
                }
                
    break;
    case "save":
         JFileChooser ji=new JFileChooser("C:");
                int ri=ji.showSaveDialog(null);
                if(ri==JFileChooser.APPROVE_OPTION){
                    File fi=new File(ji.getSelectedFile().getAbsolutePath());

                    try {
                        FileWriter fr=new FileWriter(fi);
                        BufferedWriter br=new BufferedWriter(fr);
                        br.write(t.getText());
                        br.flush();
                        br.close();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(f,"operation canceled");
                }
    break;
    case "print":
        try{
            t.print();
            
        } catch (PrinterException ex){
            throw new RuntimeException(ex);
        }
    break;
    case "cut":
        t.cut();
    break;
    case "copy":
        t.copy();
    break;
    case "paste":
        t.paste();
    break;

case "close":
f.setVisible(false);
break;
}
}
    public static void main(String[] args) {
        Notepad notepad= new Notepad();
    }

   
}
