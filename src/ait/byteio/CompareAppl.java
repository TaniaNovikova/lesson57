package ait.byteio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
* Task 1

In the CompareAppl class, implement the logic for comparing two files in the main method.
* File names are accepted through the args array. We consider two files to be identical,
*  if they have the same length and the same bytes are in the same positions.
* The result should be printed to the console as a message.

*/
public class CompareAppl {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            System.out.println("Wrong number of arguments");
            return;
        }
        System.out.println("File1 =" + args[0]);
        System.out.println("File2 =" + args[1]);
        try {
            FileInputStream file1 = new FileInputStream(args[0]);
            FileInputStream file2 = new FileInputStream(args[1]);
            int a = file1.read();
            int b = file2.read();
            int len1 = file1.available();
            int len2 = file2.available();
            if (len1 != len2) {
                System.out.println("File1 is not equal File2");
                return;
            }
            while (a != -1) {
                if (a == b) {
                    a = file1.read();
                    b = file2.read();

                } else {
                    System.out.println("File1 is not equal File2");
                    return;
                }
            }
            System.out.println("File1 is equal File2");

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}

