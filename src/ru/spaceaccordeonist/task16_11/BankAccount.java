package ru.spaceaccordeonist.task16_11;

import java.util.ArrayList;
import java.util.Date;

public class BankAccount {
    private final String id;
    private final String type;
    private final String currency;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    BankAccount(String id, String type, String currency){
        this.id = id;
        this.type = type;
        this.currency = currency;
    }

    public double getIncome(){
        double income = 0;
        for (var transaction: transactions) {
            income += transaction.income;
        }
        return income;
    }

    public double getCompanyOutcome(String name){
        double outcome = 0;
        for (var transaction: transactions) {
            if(transaction.company.equals(name))
                outcome += transaction.outcome;
        }
        return outcome;
    }

    public double getOutcome(){
        double outcome = 0;
        for (var transaction: transactions) {
            outcome += transaction.outcome;
        }
        return outcome;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == this.getClass()){
            BankAccount o = (BankAccount) obj;
            return o.id.equals(id) && o.type.equals(type) && o.currency.equals(currency);
        } else
            return false;
    }

    public void addTransaction(Date date, String reference, String info, double income, double outcome){
        Transaction transaction = new Transaction(date, reference, info, income, outcome);
        if(transaction.isValid()){
            transactions.add(transaction);
        }
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCurrency() {
        return currency;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public class Transaction{
        private Date date;
        private String reference, info, companyId, company;
        private double income, outcome;


        public Transaction(Date date, String reference, String info, double income, double outcome) {
            this.date = date;
            this.reference = reference;
            this.info = info;
            this.income = income;
            this.outcome = outcome;
            companyId = info.substring(info.lastIndexOf(" ") + 1);

            int index;
            if (!info.contains("/"))
                index = info.indexOf("\\");
            else if (!info.contains("\\"))
                index = info.indexOf("/");
            else
                index = Math.min(info.indexOf("/"), info.indexOf("\\"));

            info = info.substring(index + 1);
            info = info.replace('\\', '\0');
            info = info.replace('/', '\0');
            index = 0;
            boolean lastSpace = false;
            boolean isName = true;
            while (isName && index < info.length()){
                if(info.charAt(index) == ' '){
                    if(lastSpace)
                        isName = false;
                    else {
                        lastSpace = true;
                        index++;
                    }
                } else
                    index++;
            }
            company = info.substring(0, index);
        }

        public boolean isValid(){
            return date != null && date.before(new Date())
                    && reference != null && !reference.isEmpty()
                    && info != null && !info.isEmpty()
                    && income >= 0 && outcome >= 0;
        }

        public Date getDate() {
            return date;
        }

        public String getReference() {
            return reference;
        }

        public String getInfo() {
            return info;
        }

        public double getIncome() {
            return income;
        }

        public double getOutcome() {
            return outcome;
        }

        public String getCompanyId() {
            return companyId;
        }

        public String getCompany() {
            return company;
        }

        @Override
        public String toString() {
            return info;
        }
    }
}
