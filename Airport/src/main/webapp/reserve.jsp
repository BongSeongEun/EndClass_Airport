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
            background-color: #218838; /* hover 시 색상 변경 */
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

<form method="post" action="SeatSelection.jsp">
    <label for="departure">Departure:</label>
    <select id="departure" name="departure" required>
        <option value="Incheon">Incheon</option>
        <option value="Gimpo">Gimpo</option>
        <option value="Jeju">Jeju</option>
    </select>

    <label for="destination">Destination:</label>
    <select id="destination" name="destination" required>
        <option value="Jeju">Jeju</option>
        <option value="Busan">Busan</option>
        <option value="Japan">Japan</option>
    </select>

    <input type="submit" value="Next">
</form>

</body>
</html>