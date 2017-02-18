package service;

import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Currency;
import model.CurrencyRates;

public class CurrencyRatesDownloader {

	public BigDecimal downloadRate(Currency from, Currency to) {

		try {
			URL url = new URL("http://api.fixer.io/latest?base=" + from + "&symbols=" + to);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			
			connection.getInputStream();
			
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.findAndRegisterModules();
			CurrencyRates rates = objectMapper.readValue(connection.getInputStream(), CurrencyRates.class);
			
			return rates.getRates().get(to);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
