/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum6;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.PushbackReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Auliya-Oni
 */
public class ReadStreamPushBackInputStream2 {

    public static void main(String[] args) throws FileNotFoundException {
        File myObj = new File("coba.txt");
        Scanner myReader = new Scanner(myObj);
        System.out.println("===============================================Content Result===================================");
        String data=" ";
        int i=0;
        String dt[] = {"","",""};
        String hepp =" ";
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            dt[i]=data;
            i++;
        }
        hepp=dt[0]+" "+dt[1]+" "+dt[2];
        char p =' ';
        PushbackReader reader2 = new PushbackReader(new InputStreamReader(new ByteArrayInputStream(hepp.getBytes())));
        char[] words = new char[hepp.length()];
                     try {
                         reader2.read(words);
                         System.out.println("" + new String(words));
                         words = new char[10];
                         reader2.unread(words.length);
                         for (int a=0;a<words.length;a++){
                             p = hepp.charAt(a);
                             words[a]= p;
                        } 
                         System.out.println("" + new String(words));
                     } catch (IOException ex) {
                         Logger.getLogger(ReadStreamPushBackInputStream2.class.getName()).log(Level.SEVERE, null, ex);
                     }
    }
}
