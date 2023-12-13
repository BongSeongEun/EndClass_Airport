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

        input[type="submit"] {
            background-color: #28a745;
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

<h2>Airline Reservation - Seat Selection</h2>

<form method="post" action="ReservationComplete.jsp">
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