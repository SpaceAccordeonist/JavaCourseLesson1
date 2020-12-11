package ru.spaceaccordeonist.task19_14;

import java.util.HashMap;
import java.util.Random;

public class Main {
    public static volatile Bank bank;
    public static final long ACCOUNT_BOUND = 1000000;
    public static void main(String[] args) throws InterruptedException {
        Random rnd = new Random();
        HashMap<String, Account> accounts = new HashMap<>();
        for(int i = 0; i < 100; i++){
            String accountNum = "acc" + (100 + rnd.nextInt(899));
            accounts.put(accountNum,  new Account(accountNum, Math.abs(rnd.nextLong() + 1) % ACCOUNT_BOUND));
        }
        bank = new Bank(accounts);
        System.out.println("Current money: " + bank.getTotalSum());

        accounts.values().forEach(System.out::println);

        int limit = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[limit];
        if(limit != 0) {
            for (int i = 0; i < limit; i++) {
                threads[i] = new Thread(new TransferTask());
                threads[i].start();
            }
        }

        boolean isActive;
        do{
            isActive = false;
            for (int i = 0; i < limit; i++) {
                if (threads[i].isAlive()) {
                    isActive = true;
                    break;
                }
            }
            Thread.sleep(100);
        }while (isActive);

        System.out.println("After transactions: " + bank.getTotalSum());
        accounts.values().forEach(System.out::println);
    }
}
