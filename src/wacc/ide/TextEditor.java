package wacc.ide;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.text.*;

public class TextEditor extends JFrame {

  private JTextArea area = new JTextArea(20, 120);
  private JFileChooser finder = new JFileChooser(System.getProperty("user.dir"));
  private String currentFilename = "Untitled";
  private boolean changeFlag = false;

  // Actions
  private Action Open = new AbstractAction("Open", new ImageIcon("open.gif")) {
    public void actionPerformed(ActionEvent e) {
      saveOld();
      if (finder.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        readInFile(finder.getSelectedFile().getAbsolutePath());
      }
      SaveAs.setEnabled(true);
    }
  };

  private Action Save = new AbstractAction("Save", new ImageIcon("save.gif")) {
    public void actionPerformed(ActionEvent e) {
      if (!currentFilename.equals("Untitled"))
        saveFile(currentFilename);
      else
        saveFileAs();
    }
  };

  private Action SaveAs = new AbstractAction("Save as...") {
    public void actionPerformed(ActionEvent e) {
      saveFileAs();
    }
  };
  
  private Action Quit = new AbstractAction("Quit") {
    public void actionPerformed(ActionEvent e) {
      saveOld();
      System.exit(0);
    }
  };

  //adds some utility actions   
  private ActionMap m = area.getActionMap();
  private Action Cut = m.get(DefaultEditorKit.cutAction);
  private Action Copy = m.get(DefaultEditorKit.copyAction);
  private Action Paste = m.get(DefaultEditorKit.pasteAction);

  // Listener
  private KeyListener k = new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
      changeFlag = true;
      Save.setEnabled(true);
      SaveAs.setEnabled(true);
    }
  };

  public TextEditor() {
    // Initialises textarea and adds scroll bars
    area.setFont(new Font("Monospaced", Font.PLAIN, 12));
    JScrollPane scroll = new JScrollPane(area,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    add(scroll, BorderLayout.CENTER);

    // Creates menu
    JMenuBar JMB = new JMenuBar();
    setJMenuBar(JMB);
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMB.add(file);
    JMB.add(edit);

    // populates menu options
    // TODO: add Actions for each menu option
    file.add(Open);
    file.add(Save);
    file.add(Quit);
    file.add(SaveAs);
    file.addSeparator();
    for (int i = 0; i < 4; i++) {
      file.getItem(i).setIcon(null);
    }
    edit.add(Cut);
    edit.add(Copy);
    edit.add(Paste);

    edit.getItem(0).setText("Cut out");
    edit.getItem(1).setText("Copy");
    edit.getItem(2).setText("Paste");

    // When first initialised, there will be nothing to save, so Save and SaveAs
    // are disabled
    Save.setEnabled(false);
    SaveAs.setEnabled(false);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    area.addKeyListener(k);
    setTitle(currentFilename);
    setVisible(true);

  }

  public static void main(String[] arg) {
    new TextEditor();
  }

  private void saveFileAs() {
    if (finder.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
      saveFile(finder.getSelectedFile().getAbsolutePath());
  }

  private void saveOld() {
    if (changeFlag) {
      if (JOptionPane.showConfirmDialog(this, "Would you like to save "
          + currentFilename + " ?", "Save", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        saveFile(currentFilename);
    }
  }

  private void readInFile(String fileName) {
    try {
      FileReader r = new FileReader(fileName);
      area.read(r, null);
      r.close();
      currentFilename = fileName;
      setTitle(currentFilename);
      changeFlag = false;
    } catch (IOException e) {
      Toolkit.getDefaultToolkit().beep();
      JOptionPane.showMessageDialog(this, "File not found");
    }
  }

  private void saveFile(String filename) {
    try {
      FileWriter w = new FileWriter(filename);
      area.write(w);
      w.close();
      currentFilename = filename;
      setTitle(currentFilename);
      changeFlag = false;
      Save.setEnabled(false);
    } catch (IOException e) {
    }
  }

}
