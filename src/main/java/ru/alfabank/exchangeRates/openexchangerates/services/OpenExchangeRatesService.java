package ru.alfabank.exchangeRates.openexchangerates.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.alfabank.exchangeRates.openexchangerates.model.CurrenciesModel;
import ru.alfabank.exchangeRates.openexchangerates.repository.CurrenciesRepository;

@Service
public class OpenExchangeRatesService implements CurrenciesRepository {

	@Autowired
	OpenExchangeRatesClient client;

	@Value("${openexchangerates.api.key}")
	private String appId;
	
	@Override
	public CurrenciesModel getCurrencies(String data, String base, String symbol) {
		
		CurrenciesModel model = client.getDataCurrencies(data + ".json",appId, base, symbol , true, true);
		return model;
	}
}
