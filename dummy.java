import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.File;

class dummy {

    public static void main(String[] args) {
        try {
            File file = new File("out.txt"); // Your file
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        System.out.println("This goes to out.txt");
        deep();
    }

    static void deep() {
        System.out.println("sout bae");
    }
}