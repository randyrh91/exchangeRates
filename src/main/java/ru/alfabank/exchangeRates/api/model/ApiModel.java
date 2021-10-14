package ru.alfabank.exchangeRates.api.model;

import org.springframework.stereotype.Component;

import lombok.Data;
import ru.alfabank.exchangeRates.giphy.model.GifModel;

@Data
@Component
public class ApiModel {
	
	private String disclaimer;
	private String license;
	private String base;
	private RateModel rate;
	private GifModel gif;
	
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public RateModel getRate() {
		return rate;
	}
	public void setRate(RateModel rate) {
		this.rate = rate;
	}
	public GifModel getGif() {
		return gif;
	}
	public void setGif(GifModel gif) {
		this.gif = gif;
	}

}
