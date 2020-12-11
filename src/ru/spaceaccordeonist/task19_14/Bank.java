package ru.spaceaccordeonist.task19_14;

import com.sun.jdi.request.MonitorWaitedRequest;

import java.util.HashMap;
import java.util.Random;

public class Bank
{
    private final HashMap<String, Account>accounts;
    private final Random random = new Random();

    public Bank(){
        this(new HashMap<>());
    }
    public Bank(HashMap<String, Account> accounts){
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        if(!accounts.containsKey(account.getAccNumber())){
            this.accounts.put(account.getAccNumber(), account);
        }
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount)
    throws InterruptedException {
        if(amount >= 50000 && isFraud(fromAccountNum, toAccountNum, amount)){
            blockForFraud(fromAccountNum, toAccountNum);
            System.out.printf("Transaction denied: %s > %s => %s fraud! accounts are blocked\n",
                    fromAccountNum, toAccountNum, amount);
        } else{
            boolean started = false;
            boolean delivered = false;
            boolean transacted = false;
            do {
                do {
                    TransactionResult result = startTransactionIfPossible(fromAccountNum);
                    switch (result) {
                        case BLOCKED:
                            System.out.printf("Transaction closed: %s > %s - account blocked %s\n",
                                    fromAccountNum, toAccountNum, fromAccountNum);
                            accounts.get(fromAccountNum).setTransacting(false);
                            return;
                        case TRANSACTING:
                            Thread.sleep(10);
                            break;
                        case DONE:
                            started = true;
                            break;
                    }
                } while (!started);

                do {
                    TransactionResult result = startTransactionIfPossible(toAccountNum);
                    switch (result) {
                        case BLOCKED:
                            System.out.printf("Transaction closed: %s > %s - account blocked %s\n",
                                    fromAccountNum, toAccountNum, fromAccountNum);
                            accounts.get(fromAccountNum).setTransacting(false);
                            return;
                        case TRANSACTING:
                            accounts.get(fromAccountNum).setTransacting(false);
                            delivered = true;
                            break;
                        case DONE:
                            if(accounts.get(fromAccountNum).getBalance() >= amount) {
                                accounts.get(fromAccountNum).giveMoney(amount);
                                accounts.get(toAccountNum).addMoney(amount);
                                System.out.printf("Transaction: %s > %s => %d\n", fromAccountNum, toAccountNum, amount);
                            } else {
                                System.out.printf("Transaction denied: %s > %s => not enough money\n",
                                        fromAccountNum, toAccountNum);
                            }
                            accounts.get(fromAccountNum).setTransacting(false);
                            accounts.get(toAccountNum).setTransacting(false);
                            delivered = true;
                            transacted = true;
                            break;
                    }
                } while (!delivered);
            }while (!transacted);
        }
    }

    enum TransactionResult{
        BLOCKED, TRANSACTING, DONE
    }
    public TransactionResult startTransactionIfPossible(String accountNum)
    {
        synchronized (accounts.get(accountNum)){
            if(accounts.get(accountNum).isBlocked())
                return TransactionResult.BLOCKED;
            else if (accounts.get(accountNum).isTransacting())
                return TransactionResult.TRANSACTING;
            else {
                accounts.get(accountNum).setTransacting(true);
                return TransactionResult.DONE;
            }
        }
    }

    public synchronized void blockForFraud(String fromAccountNum, String toAccountNum)
    {
        accounts.get(fromAccountNum).setBlocked(true);
        accounts.get(toAccountNum).setBlocked(true);
    }

    public long getBalance(String accountNum)
    {
        if(accounts.containsKey(accountNum)){
            synchronized (accounts.get(accountNum)){
                return accounts.get(accountNum).getBalance();
            }
        } else {
            return 0;
        }
    }

    public long getTotalSum()
    {
        long result = 0;
        for(String key : accounts.keySet()){
            result += accounts.get(key).getBalance();
        }
        return result;
    }
}
