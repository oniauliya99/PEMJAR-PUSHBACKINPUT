/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.PushbackReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Auliya-Oni
 */
public class ReadStreamPushBackInputStream {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("coba.txt" );
        PushbackReader stream = new PushbackReader(new InputStreamReader(inputStream));
        char[] words = new char [32];
                 try {
                      stream.read(words,0, 30);
                      System.out.println("" + new String(words));
                 } catch (IOException ex) {
                     Logger.getLogger(ReadStreamPushBackInputStream.class.getName()).log(Level.SEVERE, null, ex);
                 }
    }
}
