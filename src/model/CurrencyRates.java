package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class CurrencyRates {

	private Currency base;
	private LocalDate date;
	private Map<Currency, BigDecimal> rates;
	
	public CurrencyRates(){
	}

	public CurrencyRates(Currency base, LocalDate date, Map<Currency, BigDecimal> rates) {
		super();
		this.base = base;
		this.date = date;
		this.rates = rates;
	}

	public Currency getBase() {
		return base;
	}

	public void setBase(Currency base) {
		this.base = base;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Map<Currency, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(Map<Currency, BigDecimal> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "CurrencyRates [base=" + base + ", date=" + date + ", rates=" + rates + "]";
	}
	
	
	
	
}
