package ru.spaceaccordeonist.task12_7;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        InputStream stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        Scanner scan = new Scanner(stream);

        int temp = 0;
        while (scan.hasNext()) {
            try {
                temp += Integer.parseInt(scan.next());
            }catch (NumberFormatException ignored){}
        }
        System.out.println(temp);
    }
}
