package ru.spaceaccordeonist.task14_9;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р","С", "Т", "У", "Х"};
        Random rnd = new Random(new Date().getTime());

        ArrayList<String> arrayList = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        System.out.println("Generating of license plates...");
        Instant start = Instant.now();
        int region;
        for (String a : letters) {
            for (String b : letters) {
                for (String c : letters) {
                    for (int i = 0; i < 1000; i++) {
                        for (int r = 0; r < 2; r++) {
                            region = rnd.nextInt(200);
                            String temp = String.format("%1s%03d%1s%1s%02d", a, i, b, c, region);
                            arrayList.add(temp);
                            hashSet.add(temp);
                            treeSet.add(temp);
                        }
                    }
                }
            }
        }
        Instant finish = Instant.now();

        System.out.printf("%,d license plates were generated in %d ms\n", arrayList.size(), Duration.between(start, finish).toMillis());
        System.out.print("Enter plate to find: ");
        String find = new Scanner(System.in).next();

        start = Instant.now();
        boolean containsAL = arrayList.contains(find);
        finish = Instant.now();
        Duration durationAL = Duration.between(start, finish);

        arrayList.sort(String::compareTo);
        start = Instant.now();
        boolean containsSortedAL = Collections.binarySearch(arrayList, find) > 0;
        finish = Instant.now();
        Duration durationSortedAL = Duration.between(start, finish);

        start = Instant.now();
        boolean containsHS = hashSet.contains(find);
        finish = Instant.now();
        Duration durationHS = Duration.between(start, finish);

        start = Instant.now();
        boolean containsTS = treeSet.contains(find);
        finish = Instant.now();
        Duration durationTS = Duration.between(start, finish);

        System.out.println("--------------");
        System.out.printf("Array.contains(): %s, done in %d ns\n", containsAL ? "found" : "not found", durationAL.toNanos());
        System.out.printf("binarySearch(): %s, done in %d ns\n", containsSortedAL ? "found" : "not found", durationSortedAL.toNanos());
        System.out.printf("HashSet.contains(): %s, done in %d ns\n", containsHS ? "found" : "not found", durationHS.toNanos());
        System.out.printf("TreeSet.contains(): %s, done in %d ns\n", containsTS ? "found" : "not found", durationTS.toNanos());

    }
}
