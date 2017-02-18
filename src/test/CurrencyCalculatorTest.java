package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import model.Currency;
import service.CurrencyCalculator;
import service.CurrencyRatesDownloader;

public class CurrencyCalculatorTest {

	private CurrencyCalculator classUnderTest;

	@Before
	public void setUp() {
		CurrencyRatesDownloader ratesDownlaoder = mock(CurrencyRatesDownloader.class);
		when(ratesDownlaoder.downloadRate(Currency.PLN, Currency.USD)).thenReturn(new BigDecimal("4"));
		
		classUnderTest = new CurrencyCalculator(ratesDownlaoder);
	}

	@Test
	public void test() throws Exception {

		BigDecimal amount = new BigDecimal("100");
		Currency from = Currency.PLN;
		Currency to = Currency.USD;

		BigDecimal result = classUnderTest.calculate(amount, from, to);
		
		assertEquals(new BigDecimal ("400"), result);
		
	}
	@Test
	public void test2() throws Exception {

		BigDecimal amount = new BigDecimal("120");
		Currency from = Currency.PLN;
		Currency to = Currency.USD;

		BigDecimal result = classUnderTest.calculate(amount, from, to);
		
		assertEquals(new BigDecimal ("480"), result);
		
	}
}
