<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new user</title>
</head>
<body>
    <style>
        body{
            background-color: rgb(26, 112, 211) 
        }
        form{
            color:beige
        }
    </style>
    
    <form method="POST" action="/contacts?function=saveorupdate" name="frmAddUser">
        User ID : <input type="text" name="userid" 
            value="<c:out value="${contact.userid}" />" /> <br /> 
        Email   : <input type="text" name="email" 
            value="<c:out value="${contact.email}" />" /> <br /> 
        Phone No: <input type="text" name="phone" 
            value="<c:out value="${contact.phone}" />" /> <br />     
        
             <br /> <input
            type="submit" value="Submit" style="background-color:rgb(27, 207, 27)"/>
    </form>
</body>
</html>








