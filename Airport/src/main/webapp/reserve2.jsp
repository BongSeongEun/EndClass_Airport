<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Airline Reservation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;

            text-align: center;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .navbar {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            width: 100%;
            box-sizing: border-box;
        }
        .navbar a {
            text-decoration: none;
            color: #fff;
            font-size: 18px;
            margin-right: 20px;
        }


        h1 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: inline-block;
        }

        h2 {
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            text-align: left;
        }

        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #28a745; /* 초록색으로 변경 */
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
    
</head>
<body>

	<div class="navbar">
        <h2>Airline Reservation</h2>
        <div>
            <a href="reserve.jsp">항공 예약하기</a>
            <a href="#">항공 예약 확인</a>
            <a href="login.jsp">로그인</a>
        </div>
    </div>

<form method="post" action="air.nhn?action=book">
    <p>출발지: ${flight.DepartureAirport}</p>
    <p>목적지: ${flight.ArrivalAirport}</p>

    <hr>
    <table border="1">
        <tr>
            <th>Airline</th>
            <th>Time</th>
            <th>Price</th>
            <th>예약하기</th>
        </tr>
        <c:forEach items="${l_flight}" var="l">
            <tr>
                <td>${l.Airline}</td>
                <td>${l.Time}</td>
                <td>${l.Price}</td>
                <td>
                    <button type="submit" name="reserveButton"> 예약하기 </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>