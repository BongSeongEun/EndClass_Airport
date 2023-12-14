<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>항공 예약 사이트</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            width: 100vw;
            background-repeat : no-repeat;
            background-size : cover;
            background-image: url("https://img.freepik.com/free-vector/watercolor-oil-painting-background_52683-107025.jpg?size=626&ext=jpg&ga=GA1.1.1546980028.1702512000&semt=sph");
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

        .navbar img {
            width: 100px; /* 이미지 너비 조절 */
        }

        .login-form {
            margin-top: 100px;
            padding: 100px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 700px;
            height: 700px;
        }

        h1 {
            color: #333;
        }

        .signup-link {
            margin-top: 10px;
        }

        .signup-link a {
            color: #007bff;
        }

        .login-btn {
            background-color: #4CAF50; /* 초록색 */
            color: white;
            border: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <h2>Airline Reservation</h2>

        <form method="post" action="air.nhn?action=reserve">
            <button type="submit" id="reserve" name="항공 예약">항공 예약</button>
        </form>
        <form method="post" action="air.nhn?action=reserveCheck">
            <button type="submit" id="reserveCheck" name="항공 예약 확인">항공 예약 확인</button>
        </form>
        <form method="post" action="air.nhn?action=login">
            <button type="submit" id="login" name="로그인">로그인</button>
        </form>
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