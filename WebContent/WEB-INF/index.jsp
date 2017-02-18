<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
    crossorigin="anonymous">
    <style>
        .margin-top {
            margin-top: 30px;
            font-size: larger;
        }
    </style>
<title>Kalkulator walut</title>
</head>
<body>
    <div class="container">
    <h1>Kalkulator walut</h1>
        <form method="post" action="${pageContext.request.contextPath}/currencies" class="form-inline">
            <div class="form-group">
                <input value="${amount}" required type="text" class="form-control" name="amount" placeholder="Wpisz kwote">
            </div>
            <div class="form-group">
            <select required name="fromCurrency" class="form-control">
                <option value="">- Wybierz walute -</option>
                
                <c:forEach var="currency" items="${currencies}">
                    <option <c:if test="${fromCurrency == currency}">selected</c:if> value="${currency}">
                    ${currency}
                    </option>
                </c:forEach>
            </select>
            </div>
            <div class="form-group">
            <label class="form-label">Przelicz na: </label>
            <select required name="toCurrency" class="form-control">
                <option value="">- Wybierz walute -</option>
                <c:forEach var="currency" items="${currencies}">
                    <option <c:if test="${toCurrency == currency}">selected</c:if> value="${currency}">
                    ${currency}
                    </option>
                </c:forEach>
            </select>
            </div>
            <button type="submit" class="btn btn-success">Przelicz</button>
        </form>
        
        <div class="margin-top">
            Wartosc po przeliczeniu: ${result} ${toCurrency}
        </div>
    </div>
</body>
</html>