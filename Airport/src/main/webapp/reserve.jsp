<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
     <label for="DepartureAirport">출발지:</label>
    <select id="DepartureAirport" name="DepartureAirport" required>
        <option value="ICN">서울(인천)</option>
    	<option value="GMP">서울(김포)</option>
        <option value="ICN">인천</option>
        <option value="GMP">김포</option>
        <option value="PUS">부산</option>
        <option value="TAE">대구</option>
        <option value="CJU">제주</option>
        <option value="CJJ">청주</option>
        <option value="KIX">오카사</option>
        <option value="TYO">도쿄</option>
        <option value="FUK">후쿠오카</option>
        <option value="OKA">오키나와</option>
        <option value="CTS">삿포로</option>
        <option value="NGO">나고야</option>
    </select>

    <label for="ArrivalAirport">도착지:</label>
    <select id="ArrivalAirport" name="ArrivalAirport" required>
        <option value="ICN">서울(인천)</option>
    	<option value="GMP">서울(김포)</option>
        <option value="ICN">인천</option>
        <option value="GMP">김포</option>
        <option value="PUS">부산</option>
        <option value="TAE">대구</option>
        <option value="CJU">제주</option>
        <option value="CJJ">청주</option>
        <option value="KIX">오카사</option>
        <option value="TYO">도쿄</option>
        <option value="FUK">후쿠오카</option>
        <option value="OKA">오키나와</option>
        <option value="CTS">삿포로</option>
        <option value="NGO">나고야</option>
        <option value="AMS">암스테르담</option>
    </select>

    <input type="submit" value="Next">
</form>

</body>
</html>