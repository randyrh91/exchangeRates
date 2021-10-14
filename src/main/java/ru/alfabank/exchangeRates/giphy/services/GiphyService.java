package ru.alfabank.exchangeRates.giphy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.alfabank.exchangeRates.giphy.model.DataModel;
import ru.alfabank.exchangeRates.giphy.model.GifModel;
import ru.alfabank.exchangeRates.giphy.repository.GifRepository;

@Service
public class GiphyService implements GifRepository {

	@Autowired
	GiphyClient client;

	@Value("${giphy.api.key}")
	private String apiKey;

	@Override
	public GifModel getGif(Double rate) {
		
		DataModel model;
		if (rate > 0) {
			model = client.getDataGif(apiKey, "rich", "g");
		} else {
			model = client.getDataGif(apiKey, "broke", "g");
		}
		return model.getData();
	}
}
