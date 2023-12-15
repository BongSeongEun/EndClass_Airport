<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Join</title>
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
            opacity: 0.9;
            background-image: url("KakaoTalk_20231215_035235980.png");
        }
        .login-form {
                margin-top: 20px;
                padding: 50px 150px 150px 150px;
    
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 250px;
                height: 250px;
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
    
        .signup-link {
            margin-top: 10px;
        }
    
        .signup-link a {
            color: #007bff;
        }
    
        .login-btn {
            background-color: #4CAF50; /* Green */
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }
    
        form {
            margin-top: 20px;
        }
    
        form input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .button{
                background-color: #333;
                padding: 0px 20px;
                margin-top: 8px;
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
                <button style="margin-left: 1350px;" class="button" type="submit" id="reserve" name="항공 예약">항공 예약</button>
            </form>
            <form method="post" action="air.nhn?action=CheckReserve">
                <button class="button" type="submit" id="reserveCheck" name="항공 예약 확인">항공 예약 확인</button>
            </form>
            <form method="post" action="air.nhn?action=login">
                <button class="button" type="submit" id="login" name="로그인"> 로그인</button>
            </form>
        </div>
        <div class="login-form">
        <h2>회원가입</h2>
        <form action="air.nhn?action=addUser" method="post">
            아이디:<input type="text" name="id"><br/>
            비밀번호:<input type="password" name="pw"><br/>
            <input type="submit" class="login-btn" value="가입">
        </form>
        </div>
    </body>
    </html>