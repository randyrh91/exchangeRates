package ru.alfabank.exchangeRates.giphy.repository;

import org.springframework.stereotype.Repository;

import ru.alfabank.exchangeRates.giphy.model.GifModel;

@Repository
public interface GifRepository {
	
	public GifModel getGif(Double rate);

}
