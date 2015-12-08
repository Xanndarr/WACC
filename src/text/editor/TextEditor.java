package text.editor;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.text.*;

public class TextEditor extends JFrame {
  
  private JTextArea area = new JTextArea(20, 120);
  private JFileChooser fileLoc = new JFileChooser(System.getProperty("user.dir"));
  private String currentFilename = "Untitled";
  private boolean changeFlag = false;
  
  
  
  
  
  //Listener
  private KeyListener k = new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        changeFlag = true;
        Save.setEnabled(true);
        SaveAs.setEnabled(true);
    }
  };
  
  
  public TextEditor() {
    //Initialises textarea and adds scroll bars
    area.setFont(new Font("Monospaced", Font.PLAIN, 12));
    JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    add(scroll, BorderLayout.CENTER);
    
    //Creates menu
    JMenuBar JMB = new JMenuBar();
    setJMenuBar(JMB);
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMB.add(file); JMB.add(edit);
    
    //populates menu options 
    //TODO: add Actions for each menu option
    file.add(New);
    file.add(Open);
    file.add(Save);
    file.add(Quit);
    file.add(SaveAs);
    file.addSeparator();
    for(int i=0; i<4; i++){
        file.getItem(i).setIcon(null);
    }
    edit.add(Cut);
    edit.add(Copy);
    edit.add(Paste);
    
    edit.getItem(0).setText("Cut out");
    edit.getItem(1).setText("Copy");
    edit.getItem(2).setText("Paste");
    
    //When first initialised, there will be nothing to save, so Save and SaveAs are disabled
    Save.setEnabled(false);
    SaveAs.setEnabled(false);
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    area.addKeyListener(k);
    setTitle(currentFile);
    setVisible(true);
    
  }
  

  
  

}
