package ru.alfabank.exchangeRates.giphy.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.alfabank.exchangeRates.giphy.model.DataModel;

/** ${giphy.api.test.uri} */
@FeignClient(name = "data", url = "${giphy.api.uri}")
public interface GiphyClient {

	@RequestMapping(method = RequestMethod.GET)
	DataModel getDataGif(
			@RequestParam(value = "api_key") String key, 
			@RequestParam(value = "tag") String tag,
			@RequestParam(value = "rating") String rating);
}
