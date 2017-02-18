package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import model.Currency;
import service.CurrencyRatesDownloader;

public class CurrencyRatesDownloaderTest {

	private CurrencyRatesDownloader classUnderTest;

	@Before
	public void setUp() {
		System.out.println("Metoda zostanie wykonana przed kazdym testem");
		classUnderTest = new CurrencyRatesDownloader();
	}

	@Test
	public void test() throws Exception {

		BigDecimal rate = classUnderTest.downloadRate(Currency.USD, Currency.PLN);
		
		assertNotNull (rate);
	}
}
