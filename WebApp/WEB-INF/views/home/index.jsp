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
<script type="text/javascript" src="js/LAB.min.js"></script>
</head>
<body>
    <div id="main">
        <div id="container"></div>
        <!-- Begin: CSS Dock Code -->
        <div class="dock"></div>
        <!-- End: CSS Dock Code -->
    </div>
    <script type="text/javascript">
    $LAB.script("js/jquery/jquery-1.10.1.js").wait()
    .script("js/jquery/jquery-ui-1.10.3.min.js").wait()
    .script("js/webApp.js");
</script>
</body>
</html>