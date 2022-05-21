package _5_6_practices;

import model.Trader;
import model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class TradersExecutingTransactionsExample {

    public static void main(String[] args) {
        //Domain to work on

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        var transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        var transactionsByYear = getAllTransactionsByYear(transactions, 2011);
        transactionsByYear.forEach(System.out::println);

        var tradersCities = getCitiesWhereTradersWork(transactions);
        tradersCities.forEach(System.out::println);
        System.out.println(tradersCities);

        var tradersFromCambridgeSortedByName = getTradersFromCity(transactions, "Cambridge");
        tradersFromCambridgeSortedByName.forEach(System.out::println);

        var allTradersNameSortedAlphabetically = getAllTradersNameSortedAlphabetically(transactions);
        System.out.println(allTradersNameSortedAlphabetically);

        var milanBased = getTradersFromCity(transactions, "cambridge");
        System.out.println(milanBased);

        var anyTrader = areThereTradersBasedInCity(transactions, "milan");
        System.out.println(anyTrader);

        var transactionValues = getTransactionValuesFromTraders(transactions, "cambridge");
        transactionValues.forEach(System.out::println);

        var highestValueOfAllTransactions = getHighestValueOfAllTransactions(transactions);
        System.out.println(highestValueOfAllTransactions);
    }

    /**
     * Find all transactions in the year 2011 and sort them by value (small to high)
     *
     * @param transactions
     * @param year
     * @return
     */
    static List<Transaction> getAllTransactionsByYear(List<Transaction> transactions, int year) {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == year)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    /**
     * What are all the unique cities where traders work?
     *
     * @param transa
     * @return
     */
    static Set<String> getCitiesWhereTradersWork(List<Transaction> transa) {
        return transa.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
    }

    /**
     * Find all traders from Cambridge and sort them by name
     *
     * @param transactions
     * @param city
     * @return
     */
    static List<Trader> getTradersFromCity(List<Transaction> transactions, String city) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase(city))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    /**
     * Returns a string of all traders' names sorted alphabetically
     *
     * @param transactions
     * @return
     */
    static String getAllTradersNameSortedAlphabetically(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        //.collect(Collectors.toList());
        //.reduce ("", (x1,x2) -> x1+x2) combines the names one by one to form a String that conatenates all the names
        // This is inefficient as all String are repeatedly concatenated, creating new String object at each iteration.
        //collect(joining()); better as it internally makes use of StringBuilder
    }

    /**
     * Return boolean if there is/are trader(s) based in given city
     *
     * @param transactions
     * @param city
     * @return
     */
    static boolean areThereTradersBasedInCity(List<Transaction> transactions, String city) {
        return transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equalsIgnoreCase(city));
    }

    /**
     * Prints all transactions' values from the traders living in given city
     *
     * @param transactions
     * @param city
     * @return
     */
    static List<Integer> getTransactionValuesFromTraders(List<Transaction> transactions, String city) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase(city))
                .map(transaction -> transaction.getValue())
                .collect(Collectors.toList());
    }

    static int getHighestValueOfAllTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer.MIN_VALUE, (a,b) -> Integer.max(a,b));
    }

}
