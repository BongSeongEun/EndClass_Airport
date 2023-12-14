<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            border:none;
            padding: 10px 20px;
        }
        .navbar a {
            text-decoration: none;
            color: #fff;
            font-size: 18px;
            margin-right: 20px;
        }
        
        .button{
            padding: 10px;
            margin-right: 20px;
        }
        h1 {
            color: #333;
        }
    </style>
</head>
<body>
       <div class="navbar">
        <h2>Airline Reservation</h2>

        <form method="post" action="air.nhn?action=reserve">
            <button class="button" type="submit" id="reserve" name="항공 예약">항공 예약</button>
        </form>
        <form method="post" action="/Airport/air.nhn?action=getReservationById">
            <button class="button" type="submit" id="reserveCheck" name="항공 예약 확인">항공 예약 확인</button>
        </form>
        <form method="post" action="air.nhn?action=login">
            <button class="button" type="submit" id="login" name="로그인"> 로그인</button>
        </form>
    </div>
        
        <h2>회원가입을 축하합니다</h2>
        <a href="login.jsp">로그인하기</a>
        
    
    </body>
    </html>
    