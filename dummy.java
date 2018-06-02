import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.File;

import java.util.*;

public class dummy {
    static int binarySearch(int[] array, int value, int low, int high) {
        int mid;
        if (high < low) {
            return -1;
        } else {
            mid = (low + high) / 2;
            if (array[mid] > value) {
                return binarySearch(array, value, low, mid-1);
            } else if (array[mid] < value) {
                return binarySearch(array, value, mid + 1, high);
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("out.txt"); // Your file
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        int i, value, answer;
        int[] array = new int[10000];
        for (i = 0; i < 10000; i++) {
            array[i] = sc.nextInt();
        }
        for (i = 0; i < 10000; i++) {
            value = sc.nextInt();
            answer = binarySearch(array, value, 0, 9999);
            System.out.printf("%d\n", answer);
        }
    }
}