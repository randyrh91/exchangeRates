package ru.alfabank.exchangeRates.giphy.model;

import lombok.Data;

@Data
public class DataModel {
	
	private GifModel data;

	public GifModel getData() {
		return data;
	}

	public void setData(GifModel data) {
		this.data = data;
	}

	public Boolean isEmpty() {
		return data == null;
	}
	
	

}
