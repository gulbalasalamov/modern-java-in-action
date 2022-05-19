package _5_6_practices;

import model.Trader;
import model.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
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

        var tradersFromCambridgeSortedByName = getTradersFromCity(transactions,"Cambridge");
        tradersFromCambridgeSortedByName.forEach(System.out::println);

        var allTradersNameSortedAlphabetically = getAllTradersNameSortedAlphabetically(transactions);
        allTradersNameSortedAlphabetically.forEach(System.out::println);

    }

    /**
     * Find all transactions in the year 2011 and sort them by value (small to high)
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
     * Returns a list of string of all traders' names sorted alphabetically
     * @param transactions
     * @return
     */
    static List<String> getAllTradersNameSortedAlphabetically(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
                //.reduce ("", (x1,x2) -> x1+x2) combines the names one by one to form a String that conatenates all the names
                // This is inefficient as all String are repeatedly concatenated, creating new String object at each iteration.
                //collect(joining()); better as it internally makes use of StringBuilder
    }

}
