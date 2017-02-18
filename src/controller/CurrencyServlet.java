package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Currency;
import service.CurrencyCalculator;
import service.CurrencyRatesDownloader;

@WebServlet({ "/", "/currencies" })
public class CurrencyServlet extends HttpServlet {

	private CurrencyCalculator currencyCalculator;

	public CurrencyServlet() {
		CurrencyRatesDownloader ratesDownloader = new CurrencyRatesDownloader();
		currencyCalculator = new CurrencyCalculator(ratesDownloader);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("currencies", Currency.values());
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BigDecimal amount = new BigDecimal(req.getParameter("amount"));
		Currency fromCurrency = Currency.valueOf(req.getParameter("fromCurrency"));
		// valueOf - istnieje dla kazdego enuma, pozwala na zmiane Stringa na
		// enum
		Currency toCurrency = Currency.valueOf(req.getParameter("toCurrency"));

		BigDecimal result = currencyCalculator.calculate(amount, fromCurrency, toCurrency);

		req.setAttribute("result", result.setScale(2, RoundingMode.HALF_UP));
		req.setAttribute("toCurrency", toCurrency);
		req.setAttribute("amount", amount);
		req.setAttribute("fromCurrency", fromCurrency);
		req.setAttribute("currencies", Currency.values());

		// resp.sendRedirect(req.getContextPath() + "/");

		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(req, resp);
	}

}