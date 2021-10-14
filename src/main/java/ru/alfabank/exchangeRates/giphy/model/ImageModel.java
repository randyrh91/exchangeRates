package ru.alfabank.exchangeRates.giphy.model;

import lombok.Data;

@Data
public class ImageModel {
	
	private PropertyModel original;

	public PropertyModel getOriginal() {
		return original;
	}

	public void setOriginal(PropertyModel original) {
		this.original = original;
	}
	
	                 
}
