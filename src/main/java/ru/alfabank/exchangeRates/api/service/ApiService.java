package ru.alfabank.exchangeRates.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.alfabank.exchangeRates.api.model.ApiModel;
import ru.alfabank.exchangeRates.api.model.RateModel;
import ru.alfabank.exchangeRates.api.repository.ApiRepository;
import ru.alfabank.exchangeRates.giphy.model.GifModel;
import ru.alfabank.exchangeRates.openexchangerates.model.CurrenciesModel;

@Service
public class ApiService implements ApiRepository{

	@Autowired
	private ApiModel api;
	
	@Override
	public ApiModel getApiModel() {
		return api;
	}

	@Override
	public void createApiModel(CurrenciesModel today, CurrenciesModel yesterday, GifModel gif, String symbol) {
		
		api = new ApiModel();
		
		api.setDisclaimer(today.getDisclaimer());
		api.setLicense(today.getLicense());
		api.setBase(today.getBase());
		
		RateModel rate = new RateModel();
		rate.setToday(today.getRates().get(symbol));
		rate.setYesterday(yesterday.getRates().get(symbol));
		rate.setSymbol(symbol);
		api.setRate(rate);
		
		api.setGif(gif);		
	}


}
