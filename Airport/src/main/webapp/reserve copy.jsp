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
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin-top: -5px;
        }
        .navbar {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            width: 101%;
            box-sizing: border-box;
        }
        .navbar a {
            text-decoration: none;
            color: #fff;
            font-size: 18px;
        }


        h1 {
            color: #333;
        }

        .formd {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 10px;
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

        input{
            background-color: #28a745; /* 초록색으로 변경 */
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input:hover {
            background-color: #218838;
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
    </style>
    
</head>
<body>

	<div class="navbar">
        <h2>Airline Reservation</h2>

        <form method="post" action="air.nhn?action=reserve">
            <button style="margin-left: 1330px;" class="button" type="submit" id="reserve" name="항공 예약">항공 예약</button>
        </form>
        <form method="post" action="air.nhn?action=reserveCheck">
            <button class="button" type="submit" id="reserveCheck" name="항공 예약 확인">항공 예약 확인</button>
        </form>
        <form method="post" action="air.nhn?action=login">
            <button class="button" type="submit" id="login" name="로그인"> 로그인</button>
        </form>
    </div>

<form  class="formd" method="post" action="SeatSelection.jsp">
    <label for="departure">Source:</label>
    <select id="departure" name="departure" required>
        <option value="Incheon">Incheon</option>
        <option value="Gimpo">Gimpo</option>
        <option value="Jeju">Jeju</option>
    </select>

    <label for="destination">Destination:</label>
    <select id="destination" name="destination" required>
        <option value="Amsterdam">Amsterdam</option>
        <option value="Sapporo">Sapporo</option>
        <option value="Macao">Macao</option>
    </select>

    <input type="submit" value="Next">
</form>

</body>
</html>
