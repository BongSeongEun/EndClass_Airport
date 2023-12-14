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
    
    <h2>회원가입</h2>
    <form action="join_ok.jsp" method="post">
        아이디:<input type="text" name="id"><br/>
        비밀번호:<input type="password" name="pw"><br/>
        <input type="submit" class="login-btn" value="가입">
    </form>
</body>
</html>
