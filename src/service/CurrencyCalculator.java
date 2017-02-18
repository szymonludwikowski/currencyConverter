package service;

import java.math.BigDecimal;

import model.Currency;

public class CurrencyCalculator {

	private CurrencyRatesDownloader ratesDownloader;
	
	
	
	public CurrencyCalculator(CurrencyRatesDownloader ratesDownloader) {
		this.ratesDownloader = ratesDownloader;
	}



	public BigDecimal calculate(BigDecimal amount, Currency from, Currency to) {
		
		BigDecimal rate = ratesDownloader.downloadRate(from, to);
		
		if (rate == null){
			return BigDecimal.ZERO;
		}
		return amount.multiply(rate);
	}

	
	
}
