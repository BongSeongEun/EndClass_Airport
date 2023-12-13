<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>항공 예약 사이트</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        h1 {
            color: #333;
        }

        button {
            padding: 10px 20px;
            font-size: 16px;
            margin: 10px;
            cursor: pointer;
            background-color: #4CAF50; /* 초록색 */
            color: white;
            border: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <h1>Airline Reservation</h1>

    <button onclick="redirectToReservation()">항공 예약하기</button>
    <button onclick="checkReservation()">항공 예약 확인</button>

    <script>
        function redirectToReservation() {
            // 여기에 예약 페이지로 이동하는 코드를 추가하세요.
            alert("항공 예약 페이지로 이동합니다.");
        }

        function checkReservation() {
            // 여기에 예약 확인 페이지로 이동하는 코드를 추가하세요.
            alert("항공 예약 확인 페이지로 이동합니다.");
        }
    </script>
</body>
</html>