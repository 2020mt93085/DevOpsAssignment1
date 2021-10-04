<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="css/user.css"/ >
</head>
 <body>
 <div class="container">
<h3 style="color:DodgerBlue;">Hi ${userName}</h3>
<p>Today's Date is:  ${currentDate}</p>
<p> Your current age is : ${year} years ${month} months ${day} days </p>
</div>
</body>
</html>