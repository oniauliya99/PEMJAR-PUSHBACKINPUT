/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum6;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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
    public static void main(String[] args) {
        String s = "Polinema tetap jaya selalu di kancah nasional dan akan berlanjut ke internasional";
                     PushbackReader reader = new PushbackReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes())));
                     char[] words = new char[s.length()];
                     char help = ' ';
                     try {
                         reader.read(words);
                         System.out.println("" + new String(words));  
                         words = new char[8];
                         reader.unread(words.length);
                         for (int a=0;a<words.length;a++){
                             help = s.charAt(a);
                             words[a]= help;
                         }
                         System.out.println("-------------------------------------------0---");    
                         System.out.print("displaying 8 character of words from content is : ");
                         System.out.println("" + new String(words));
                         System.out.println("-----------------------------------------------");
                         
//                         reader.unread(words);
                     } catch (IOException ex) {
                         Logger.getLogger(ReadStreamPushBackInputStream.class.getName()).log(Level.SEVERE, null, ex);
                     }
    }
}
