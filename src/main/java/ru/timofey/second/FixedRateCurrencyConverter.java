package ru.timofey.second;

import java.util.HashMap;
import java.util.Map;

class FixedRateCurrencyConverter implements CurrencyConverter {
    private final Map<String, Double> rates = new HashMap<>();

    public FixedRateCurrencyConverter() {
        rates.put("USD", 1.0);
        rates.put("EUR", 0.85);
        rates.put("RUB", 83.74);
        rates.put("GBP", 0.74);
        rates.put("JPY", 148.8);
    }

    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (!rates.containsKey(fromCurrency) || !rates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Неизвестная валюта");
        }
        double amountInUSD = amount / rates.get(fromCurrency);
        return amountInUSD * rates.get(toCurrency);
    }

    public void printAvailableCurrencies() {
        System.out.println("Доступные валюты: " + rates.keySet());
    }
}