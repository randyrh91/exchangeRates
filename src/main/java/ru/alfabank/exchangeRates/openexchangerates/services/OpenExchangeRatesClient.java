package ru.alfabank.exchangeRates.openexchangerates.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.alfabank.exchangeRates.openexchangerates.model.CurrenciesModel;

/** ${openexchangerates.api.test.uri} */
@FeignClient(name = "data-exchange-rates", url = "${openexchangerates.api.currencies.uri}")
public interface OpenExchangeRatesClient {

	@RequestMapping(method = RequestMethod.GET, value = "{date}")
	CurrenciesModel getDataCurrencies(
			@PathVariable("date") String date,
			@RequestParam(value = "app_id") String id, 
			@RequestParam(value = "base") String base, 
			@RequestParam(value = "symbols") String symbols,
			@RequestParam(value = "show_alternative") Boolean show_alternative,
			@RequestParam(value = "prettyprint") Boolean prettyprint);
}