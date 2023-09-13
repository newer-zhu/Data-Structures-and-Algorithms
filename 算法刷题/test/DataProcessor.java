package test;

import test.Customer;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataProcessor {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) throws IOException {
        // Read input file
        List<Customer> customers = readCustomers("F:\\Javacases\\Data-Structures-and-Algorithms\\算法刷题\\test\\CodingSampleData.csv");

        // Transform data
        List<Customer> transformedCustomers = transformCustomers(customers);

        // Write clean data to output file
        String cleanDataFilename = "cleandata." + getTimestamp() + ".csv";
        writeCustomers(cleanDataFilename, transformedCustomers);

        // Generate summary report
        String summaryReportFilename = "summaryreport." + getTimestamp() + ".txt";
        int favoritesCount = args.length > 0 ? Integer.parseInt(args[0]) : 5;
        generateSummaryReport(summaryReportFilename, transformedCustomers, favoritesCount);
    }

    private static List<Customer> readCustomers(String filename) throws IOException {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Customer customer = new Customer(
                        fields[0], fields[1], fields[2], fields[3], fields[4], fields[5],
                        fields[6], fields[7], parseDate(fields[8]), fields[9], Double.parseDouble(fields[10]),
                        parseDate(fields[11]), Double.parseDouble(fields[12])
                );
                customers.add(customer);
            }
        }
        return customers;
    }

    private static List<Customer> transformCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            String[] nameParts = customer.getName().split(" ");
            String lastName = nameParts[nameParts.length - 1];
            String firstName = nameParts[0];
            String middleInitial = nameParts.length > 2 ? nameParts[1].substring(0, 1) : "";
            String reformattedName = lastName + ", " + firstName + " " + middleInitial + ".";
            customer.setName(reformattedName);
            try {
                customer.setBirthDate(new SimpleDateFormat("yyyy-MM-dd")
                        .parse(DATE_FORMAT.format(customer.getBirthDate())));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        // Sort by state and name
        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                int stateCompare = c1.getState().compareTo(c2.getState());
                if (stateCompare != 0) {
                    return stateCompare;
                } else {
                    return c1.getName().compareTo(c2.getName());
                }
            }
        });

        // Reject duplicate account numbers
        Set<String> accountNumbers = new HashSet<>();
        List<Customer> transformedCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (accountNumbers.contains(customer.getAccountNumber())) {
                System.out.println("Duplicate account number: " + customer.getAccountNumber());
            } else {
                accountNumbers.add(customer.getAccountNumber());
                transformedCustomers.add(customer);
            }
        }

        return transformedCustomers;
    }

    private static void writeCustomers(String filename, List<Customer> customers) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Account Number,Name,Company,Street,City,State,Zip,Email,Birth Date,Favorites,Standard Payment,Latest Payment,Balance\n");
            for (Customer customer : customers) {
                writer.write(customer.getAccountNumber() + ",");
                writer.write(customer.getName() + ",");
                writer.write(customer.getCompany() + ",");
                writer.write(customer.getStreet() + ",");
                writer.write(customer.getCity() + ",");
                writer.write(customer.getState() + ",");
                writer.write(customer.getZip() + ",");
                writer.write(customer.getEmail() + ",");
                writer.write(customer.getBirthDate() + ",");
                writer.write(customer.getFavorites() + ",");
                writer.write(customer.getStandardPayment() + ",");
                writer.write(DATE_FORMAT.format(customer.getLatestPayment()) + ",");
                writer.write(customer.getBalance() + "\n");
            }
        }
    }

    private static void generateSummaryReport(String filename, List<Customer> customers, int favoritesCount) throws IOException {
        // Aggregate balances by state
        Map<String, Double> balancesByState = new HashMap<>();
        for (Customer customer : customers) {
            String state = customer.getState();
            double balance = balancesByState.getOrDefault(state, 0.0);
            balance += customer.getBalance();
            balancesByState.put(state, balance);
        }

        // Sort states by total balance descending
        List<String> statesByBalanceDesc = new ArrayList<>(balancesByState.keySet());
        Collections.sort(statesByBalanceDesc, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                double balance1 = balancesByState.get(s1);
                double balance2 = balancesByState.get(s2);
                return Double.compare(balance2, balance1);
            }
        });

        // Count favorite items
        Map<String, Integer> favoriteCounts = new HashMap<>();
        for (Customer customer : customers) {
            String[] favorites = customer.getFavorites().split("\\|");
            for (String favorite : favorites) {
                favoriteCounts.put(favorite, favoriteCounts.getOrDefault(favorite, 0) + 1);
            }
        }

        // Sort favorites by count descending
        List<String> favoritesByCountDesc = new ArrayList<>(favoriteCounts.keySet());
        Collections.sort(favoritesByCountDesc, new Comparator<String>() {
            @Override
            public int compare(String f1, String f2) {
                int count1 = favoriteCounts.get(f1);
                int count2 = favoriteCounts.get(f2);
                return Integer.compare(count2, count1);
            }
        });

        // Write summary report file
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Balances by state table
            writer.println("Balances by State:");
            writer.printf("%-10s %10s\n", "State", "Balance");
            for (String state : statesByBalanceDesc) {
                double balance = balancesByState.get(state);
                writer.printf("%-10s %10.2f\n", state, balance);
            }

            // Favorite items table
            writer.println("\nFavorite Items:");
            writer.printf("%-20s %10s\n", "Item", "Count");
            for (int i = 0; i < favoritesCount && i < favoritesByCountDesc.size(); i++) {
                String favorite = favoritesByCountDesc.get(i);
                int count = favoriteCounts.get(favorite);
                writer.printf("%-20s %10d\n", favorite, count);
            }
        }
    }

    private static String getTimestamp() {
        return DATE_FORMAT.format(new Date()) + "_" + new SimpleDateFormat("HHmmss").format(new Date());
    }

    private static Date parseDate(String dateString) {
        try {
            return DATE_FORMAT.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }


}
