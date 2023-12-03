package ait.byteio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteInputStream {
    public static void main(String[] args) {
        try (FileInputStream fin = new FileInputStream("./dest/test")) {
            System.out.println("Avaible = "+fin.available());//сколько байтов записано в файле?
            // 4(столько и записали)
            int a = fin.read();//вычитаваем первый байт
            System.out.println(a);//65 - записано в первый байт
            System.out.println("Avaible = "+fin.available()); //сколько осталось вычитать байтов?
            // 1 вычитали и осталось для чтения еще 3 - печатает цифру 3
            a = fin.read();
            System.out.println(a);//d n
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
