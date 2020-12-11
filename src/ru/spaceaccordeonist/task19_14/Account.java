package ru.spaceaccordeonist.task19_14;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class Account
{
    private final AtomicLong money = new AtomicLong();
    private final String accNumber;
    private final AtomicBoolean isBlocked = new AtomicBoolean();
    private boolean isTransacting = false;

    public Account(String accNumber, long money) {
        this.money.set(money);
        this.accNumber = accNumber;
    }

    public synchronized long getBalance() {
        return money.getAcquire();
    }

    public String getAccNumber() {
        return accNumber;
    }

    public boolean isBlocked() {
        return isBlocked.get();
    }

    public synchronized void setBlocked(boolean blocked) {
        isBlocked.set(blocked);
    }

    public boolean isTransacting() {
        return isTransacting;
    }

    public synchronized void setTransacting(boolean transacting) {
        isTransacting = transacting;
    }

    public void addMoney(long count){
        if(!isBlocked.get())
            money.addAndGet(count);
    }

    public void giveMoney(long count){
        if(!isBlocked.get())
            money.addAndGet(-count);
    }

    @Override
    public String toString() {
        return accNumber + ": " + money;
    }
}
