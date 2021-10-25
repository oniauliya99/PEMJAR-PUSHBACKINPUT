/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Auliya-Oni
 */
public class ReadStreamPushBackReader {
    public static void main(String[] args) {
        String s = "Polinema tetap jaya selalu di kancah nasional dan akan berlanjut ke internasional";
                     PushbackReader reader = new PushbackReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes())));
                     char[] words = new char[s.length()];
                     try {
                         reader.read(words);
                         System.out.println("" + new String(words));
                         words = new char[8];
//                         reader.unread(words);
                     } catch (IOException ex) {
                         Logger.getLogger(ReadStreamPushBackReader.class.getName()).log(Level.SEVERE, null, ex);
                     }
    }
}
