package ru.alfabank.exchangeRates.openexchangerates.model;

import java.util.Map;
import lombok.Data;

@Data
public class CurrenciesModel {
	
	private String disclaimer;
	private String license;
	private String base;
	private Map<String, String> rates;
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
	public Map<String, String> getRates() {
		return rates;
	}
	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}
	public Boolean isEmpty() {
		return this == null;
	}
	
	
	
}
