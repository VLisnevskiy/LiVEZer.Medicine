<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
<link type="image/ico" rel="icon" href="favicon.ico" />
<!-- Link CSS files -->
<link type="text/css" rel="stylesheet" href="css/style.css" />
<!-- Link JavaScript files-->
<!-- <script type="text/javascript" src="js/LAB.min.js"></script> -->
<!--<script type="text/javascript" src="js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery-ui-1.10.3.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.md5.js"></script>
<script type="text/javascript" src="js/webApp.js"></script>-->
<script type="text/javascript" src="js/LAB.min.js"></script>
</head>
<body>
    <div id="main">
        <!--<div id="login-in-box">
            <div id="login-in-box-title">LogIn Form</div>
            <form id="login-in-form" autocomplete="on">
                <input type="text" name="login" id="login" placeholder="Username" class="" />
                <input type="password" name="passw" id="passw" placeholder="Password" class="" />
                <select>
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="mercedes">Mercedes</option>
                <option value="audi">Audi</option>
                </select> 
                <input type="submit" value="LOG IN" class="" />
            </form>
        </div>-->
        <div id="container"></div>
        <!-- Begin: CSS Dock Code -->
        <div class="dock"></div>
        <!-- End: CSS Dock Code -->
    </div>
    <script type="text/javascript">
    $LAB.script("js/jquery/jquery-1.10.2.min.js").wait()
    .script("js/jquery/jquery-ui-1.10.3.min.js").wait()
    .script("js/jquery/jquery.md5.js").wait()
    .script("js/webApp.js").wait();
    </script>
</body>
</html>