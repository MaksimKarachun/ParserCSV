package com.company;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            Double allReceipt = 0.0;
            Double allExpense = 0.0;

            List<Transaction> transactionList = Transaction.getTransactions("res/movementList.csv");

            for (Transaction transaction : transactionList) {
                allReceipt = allReceipt + transaction.receipt;
                allExpense = allExpense + transaction.expense;
            }

            System.out.println("Общий приток средств на счет: " + allReceipt + " RUR");
            System.out.println("Общий расход средст по счету: " + allExpense + " RUR");

            System.out.println();

            Map<String, Double> expense = Transaction.getListOfExpenses(transactionList);
            System.out.println("Детальная выписка по счету " + "\n");
            for (Map.Entry<String, Double> entry : expense.entrySet()) {
                System.out.println("Наименование расхода: " + entry.getKey() + " RUR" + "\n" + "Расход по счету: " + entry.getValue() + " RUR" + "\n");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

