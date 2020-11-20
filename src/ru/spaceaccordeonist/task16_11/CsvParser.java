package ru.spaceaccordeonist.task16_11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

public class CsvParser {
    public static final String FILE_PATH = "src/ru/spaceaccordeonist/task16_11/movementList.csv";
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        try(FileReader fileReader = new FileReader(Paths.get(FILE_PATH).toFile(), Charset.forName("windows-1251"));
            BufferedReader reader = new BufferedReader(fileReader)){
            String bufferLine;
            reader.readLine(); //Пропуск первой строки
            while((bufferLine = reader.readLine()) != null){
                ArrayList<String> tokens= new ArrayList<>();
                for(int i = 0; i < 7; i++){
                    tokens.add(bufferLine.substring(0, bufferLine.indexOf(",")));
                    bufferLine = bufferLine.substring(bufferLine.indexOf(",") + 1);
                }
                tokens.add(bufferLine);
                BankAccount account = new BankAccount(tokens.get(1), tokens.get(0), tokens.get(2));
                if(!accounts.contains(account))
                    accounts.add(account);
                else
                    account = accounts.get(accounts.indexOf(account));
                if(tokens.get(6).startsWith("\"") && tokens.get(6).endsWith("\"")){
                    String temp = tokens.get(6).substring(1, tokens.get(6).length() - 1);
                    temp = temp.replace(",", ".");
                    tokens.remove(6);
                    tokens.add(6, temp);
                }
                if(tokens.get(7).startsWith("\"") && tokens.get(7).endsWith("\"")){
                    String temp = tokens.get(7).substring(1, tokens.get(7).length() - 1);
                    temp = temp.replace(",", ".");
                    tokens.remove(7);
                    tokens.add(7, temp);
                }
                account.addTransaction(
                        DateFormat.getDateInstance(DateFormat.SHORT).parse(tokens.get(3)),
                        tokens.get(4), tokens.get(5), Double.parseDouble(tokens.get(6)),
                        Double.parseDouble(tokens.get(7)));
            }
        } catch (IOException | ParseException e){
            e.printStackTrace();
        }

        accounts.forEach(bankAccount -> {
            System.out.printf("Total income: %.2f %s\n", bankAccount.getIncome(), bankAccount.getCurrency());
            System.out.printf("Total outcome: %.2f %s\n", bankAccount.getOutcome(), bankAccount.getCurrency());
            System.out.println("Your transactions:");
            HashSet<String> checked = new HashSet<>();
            bankAccount.getTransactions().forEach(transaction -> {
                if(!checked.contains(transaction.getCompanyId())){
                    checked.add(transaction.getCompanyId());
                    System.out.printf("%s expenses is %.2f %s\n",
                            transaction.getCompany(),
                            bankAccount.getCompanyOutcome(transaction.getCompany()),
                            bankAccount.getCurrency());
                }
            });
        });
    }
}
