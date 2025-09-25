package ru.timofey.second;

import java.util.Scanner;

public class CurrencyApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new FixedRateCurrencyConverter();

        System.out.println("Конвертер валют");
        ((FixedRateCurrencyConverter) converter).printAvailableCurrencies();

        while (true) {
            System.out.print("Введите валюту источник (или exit для выхода): ");
            String from = scanner.nextLine().toUpperCase();
            if (from.equals("EXIT")) break;

            System.out.print("Введите валюту назначения: ");
            String to = scanner.nextLine().toUpperCase();

            System.out.print("Введите сумму: ");
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число");
                continue;
            }

            try {
                double result = converter.convert(amount, from, to);
                System.out.printf("%.2f %s = %.2f %s%n", amount, from, result, to);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        System.out.println("До свидания!");
    }
}