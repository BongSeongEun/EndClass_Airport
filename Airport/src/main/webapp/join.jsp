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

    h2 {
        color: #333;
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
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        margin: 0 auto;
    }

    form label {
        display: block;
        margin: 10px 0 5px;
        text-align: left;
    }

    form input,
    form select {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    form input[type="radio"] {
        margin-right: 5px;
    }

    form input[type="submit"] {
        background-color: #4CAF50; /* Green */
        color: white;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        font-size: 16px;
        cursor: pointer;
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
    
    <form action="join_ok.jsp" method="post">
        <label for="id">아이디:</label>
        <input type="text" name="id" required><br/>

        <label for="pw">비밀번호:</label>
        <input type="password" name="pw" required><br/>

        <label for="name">이름:</label>
        <input type="text" name="name" required><br/>

        <label for="phone">전화번호:</label>
        <select name="phon1">
            <option>010</option>
            <option>02</option>
            <option>031</option>
            <option>051</option>
        </select>
        - <input type="text" name="phone2" size="5">
        - <input type="text" name="phone3" size="5"><br/>

        <label>성별:</label>
        <input type="radio" name="gender" value="m" checked>남자
        <input type="radio" name="gender" value="f">여자<br/>

        <input type="submit" class="login-btn" value="가입">
    </form>
</body>
</html>
