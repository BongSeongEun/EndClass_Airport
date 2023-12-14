<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Airline Reservation - Seat Selection</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 50px;
            text-align: center;
        }
        .navbar {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            display: flex;
            width: 110%;
            margin-left: -50px;
            box-sizing: border-box;
            border:none;
            position: relative;
            margin-top: -50px;
        }
        
        .button{
            padding: 10px;
            background-color: #333;
            padding: 10px 20px;
            margin-top: 12px;
            margin-right: 20px;
            color: #f4f4f4;
            font-size: 18px;
            border: none;
        }

        .formd {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: inline-block;
        }

        h2 {
            margin-bottom: 30px;
        }

        p {
            margin-bottom: 20px;
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

        input{
            background-color: #28a745;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

	<div class="navbar">
        <h2>Airline Reservation</h2>

        <form method="post" action="air.nhn?action=reserve">
            <button style="margin-left: 1250px;" class="button" type="submit" id="reserve" name="항공 예약">항공 예약</button>
        </form>
        <form method="post" action="air.nhn?action=reserveCheck">
            <button class="button" type="submit" id="reserveCheck" name="항공 예약 확인">항공 예약 확인</button>
        </form>
        <form method="post" action="air.nhn?action=login">
            <button class="button" type="submit" id="login" name="로그인"> 로그인</button>
        </form>
    </div>


<h2>Airline Reservation - Seat Selection</h2>

<form class="formd" method="post" action="ReservationComplete.jsp">
    <p>출발지: ${param.departure}</p>
    <p>목적지: ${param.destination}</p>

    <label for="seatSelection">Select Your Seat:</label>
    <!-- 좌석 선택 일단 귀찮아서 그런건 아니고 옵션으로 선택 --> 
    <select id="seatSelection" name="seatSelection" required>
        <option value="A1">A1</option>
        <option value="A2">A2</option>
        <option value="B1">B1</option>
        <option value="B2">B2</option>
        <!-- 더 필요하면 추가... 나중에 더 제대로 꾸밀게 -->
    </select>

    <input type="submit" value="Complete Reservation">
</form>

</body>
</html>