package ru.alfabank.exchangeRates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alfabank.exchangeRates.api.model.ApiModel;
import ru.alfabank.exchangeRates.api.service.ApiService;
import ru.alfabank.exchangeRates.giphy.model.GifModel;
import ru.alfabank.exchangeRates.giphy.services.GiphyService;
import ru.alfabank.exchangeRates.openexchangerates.model.CurrenciesModel;
import ru.alfabank.exchangeRates.openexchangerates.services.OpenExchangeRatesService;

@RestController
public class ExchangeRatesController {

	@Autowired
	private GiphyService giphyService;

	@Autowired
	private OpenExchangeRatesService oerService;

	@Autowired
	private ApiService apiService;

	@GetMapping("/apiexchangerates/")
	public Object index(@RequestParam(value = "base", required = false, defaultValue = "RUB") String base, @RequestParam String symbol) {
		// Las fechas
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = dateFormat.format(cal.getTime());

		cal.add(Calendar.DATE, -1);
		String yesterday = dateFormat.format(cal.getTime());

		// Las monedas
		CurrenciesModel currencyToday = oerService.getCurrencies(today, base, symbol);
		Double rateToday = Double.parseDouble(currencyToday.getRates().get(symbol));

		CurrenciesModel currencyYesterday = oerService.getCurrencies(yesterday, base, symbol);
		Double rateYesterday = Double.parseDouble(currencyYesterday.getRates().get(symbol));

		// El gif
		GifModel gif = giphyService.getGif(rateToday - rateYesterday);

		apiService.createApiModel(currencyToday, currencyYesterday, gif, symbol);
		ApiModel model = apiService.getApiModel();

		return model;
	}
}
