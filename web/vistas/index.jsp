<%-- 
    Document   : index
    Created on : 13/02/2016, 11:19:01 AM
    Author     : JAVA-08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
        <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath() %>/css/font-awesome.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath() %>/css/prettyPhoto.css" rel="stylesheet">
        <link href="<%= request.getContextPath() %>/css/price-range.css" rel="stylesheet">
        <link href="<%= request.getContextPath() %>/css/animate.css" rel="stylesheet">
        <link href="<%= request.getContextPath() %>/css/main.css" rel="stylesheet">
        <link href="<%= request.getContextPath() %>/css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="<%= request.getContextPath() %>/images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%= request.getContextPath() %>/images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%= request.getContextPath() %>/images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%= request.getContextPath() %>/images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="<%= request.getContextPath() %>/images/ico/apple-touch-icon-57-precomposed.png">
    </head><!--/head-->

    <body>
        <jsp:include page="/template/header.jsp" />
        <jsp:include page="/template/body.jsp" />
        <jsp:include page="/template/footer.jsp" />
        <script src="<%= request.getContextPath() %>/js/jquery.js"></script>
        <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
        <script src="<%= request.getContextPath() %>/js/jquery.scrollUp.min.js"></script>
        <script src="<%= request.getContextPath() %>/js/price-range.js"></script>
        <script src="<%= request.getContextPath() %>/js/jquery.prettyPhoto.js"></script>
        <script src="<%= request.getContextPath() %>/js/main.js"></script>
    </body>
</html>
