package ru.alfabank.exchangeRates.api.repository;

import org.springframework.stereotype.Repository;

import ru.alfabank.exchangeRates.api.model.ApiModel;
import ru.alfabank.exchangeRates.giphy.model.GifModel;
import ru.alfabank.exchangeRates.openexchangerates.model.CurrenciesModel;

@Repository
public interface ApiRepository {
	
	public void createApiModel(CurrenciesModel today, CurrenciesModel yesterday, GifModel gif, String symbol);
	public ApiModel getApiModel();

}
