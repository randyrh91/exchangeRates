package ru.alfabank.exchangeRates.openexchangerates.repository;

import org.springframework.stereotype.Repository;

import ru.alfabank.exchangeRates.openexchangerates.model.CurrenciesModel;

@Repository
public interface CurrenciesRepository {
	
	public CurrenciesModel getCurrencies(String data, String base, String symbol);
}
