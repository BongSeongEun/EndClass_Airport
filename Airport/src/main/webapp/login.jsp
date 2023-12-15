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
        <form method="post" action="air.nhn?action=CheckReserve">
            <button type="submit" id="reserveCheck" name="항공 예약 확인">항공 예약 확인</button>
        </form>
        <form method="post" action="air.nhn?action=login">
            <button type="submit" id="login" name="로그인">로그인</button>
        </form>
    </div>


    <div class="login-form">
        <h2>로그인</h2>
        <br>
        <form method="post" action="air.nhn?action=getUserById">
            <div class="form-group">
                <label for="username">아이디:</label>
                <input type="text" class="form-control" id="id" name="id" required = "">
            </div>

            <div class="form-group">
                <label for="password">비밀번호:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
         <br>
            <button type="submit" id ="btn" class="btn login-btn">로그인</button>
        </form>
      
      <br>
        <div class="signup-link">
            <p>계정이 없으신가요? <a href="join.jsp">회원가입</a></p>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>