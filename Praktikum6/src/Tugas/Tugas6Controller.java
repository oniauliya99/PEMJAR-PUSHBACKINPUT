/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PushbackReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Auliya-Oni
 */
public class Tugas6Controller {

    private List<Integer> list = new ArrayList<>();

    private FormT6 view;

    public Tugas6Controller(FormT6 view) {
        this.view = view;
        this.view.getBtn_baca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    proses();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Tugas6Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.view.getBtn_Simpan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
    }

    private void proses() throws FileNotFoundException {
        JFileChooser loadFile = view.getLoadFile();
        StyledDocument doc = view.getTxtPane().getStyledDocument();
        if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
            PushbackReader reader = new PushbackReader(new FileReader(loadFile.getSelectedFile()));
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(loadFile.getSelectedFile()));
                int count = 0, desimal, word=reader.read();
                char ascii;
                doc.insertString(0, "", null);
                while (word != -1) {
                    doc.insertString(doc.getLength(), (char) word + "", null);
                    word = reader.read();
                }
                int jumlah = 0, counter = 0, row = 0,words=0,amountWords=0;
                while ((desimal = lineNumberReader.read()) != -1) {
                    ascii = (char) desimal;
                    jumlah = lineNumberReader.getLineNumber();
                    if (counter == jumlah) {
                        row++;
                        counter++;
                    }  
                    String s = String.valueOf(ascii);
                    if (!s.equals("\n") && !s.equals(" ")) {
                        count++;
                    }
                    if (s.equals(" ")) {
                        words=words+1; 
                    }
                    if (s.equals("\n")) {
                        words=words+1; 
                    }
                    amountWords=words+1;
                }
                JOptionPane.showMessageDialog(null, "Success \n " + "Amount of Rows : " + row + "\n Amount of Words : " + amountWords + "\n Amount of Characters : " + count);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Tugas6Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | BadLocationException ex) {
                Logger.getLogger(Tugas6Controller.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Failed to Read Data", "", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(Tugas6Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    private void save() {
        JFileChooser loadFile = view.getLoadFile();
        if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(view)) {
            BufferedWriter writer = null;
            try {
                String contents = view.getTxtPane().getText();
                if (contents != null && !contents.isEmpty()) {
                    writer = new BufferedWriter(new FileWriter(loadFile.getSelectedFile()));
                    writer.write(contents);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Tugas6Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tugas6Controller.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (writer != null) {
                    try {
                        writer.flush();
                        writer.close();
                        view.getTxtPane().setText("");
                        JOptionPane.showMessageDialog(null, "Data Saved");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Failed to Save", "", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(Tugas6Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
