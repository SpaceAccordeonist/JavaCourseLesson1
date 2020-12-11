package ru.spaceaccordeonist.task19_14;

import java.util.ArrayList;
import java.util.Random;

public class TransferTask implements Runnable{
    private static final int  MAX_TRANSACTION = 60000;
    private static final int  TRANSACTIONS_COUNT = 20;
    @Override
    public void run(){
        Random rnd = new Random();

        for(int i = 0; i < TRANSACTIONS_COUNT; i++){
            //Выбор случайных аккаунтов
            String rndKeyTo = new ArrayList<>(Main.bank.getAccounts().keySet()).get(
                    rnd.nextInt(new ArrayList<>(Main.bank.getAccounts().keySet()).size()));
            String rndKeyFrom;
            do{
                rndKeyFrom = new ArrayList<>(Main.bank.getAccounts().keySet()).get(
                        rnd.nextInt(new ArrayList<>(Main.bank.getAccounts().keySet()).size()));
            }while (rndKeyTo.equals(rndKeyFrom));

            try {
                Main.bank.transfer(rndKeyFrom, rndKeyTo,
                        Math.abs(rnd.nextLong() + 1) % MAX_TRANSACTION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
