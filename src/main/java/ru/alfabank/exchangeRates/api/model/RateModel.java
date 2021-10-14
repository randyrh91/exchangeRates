package ru.alfabank.exchangeRates.api.model;

import lombok.Data;

@Data
public class RateModel {
	private String symbol;
	private String yesterday;
	private String today;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getYesterday() {
		return yesterday;
	}
	public void setYesterday(String yesterday) {
		this.yesterday = yesterday;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	
	
}
