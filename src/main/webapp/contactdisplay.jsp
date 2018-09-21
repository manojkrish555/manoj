<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
            body {
                background-color:black
            }

            table h {
                color: aqua
            }

            a {
                color:rgb(247, 77, 168)
            }
            th{
                background-color:aqua
            }
          
            td{
                background-color:paleturquoise
            }
        </style>
</head>
<body>
    ${contactlist}
    <table border=1>
        <thead>
            <tr>
                <th>User Id</th>
                <th>Email</th>
                <th>phone</th>
              
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${contactlist}" var="contact">
                <tr>
                    <td>
                        <c:out value="${contact.userid}" />
                    </td>
                    <td>
                        <c:out value="${contact.email}" />
                    </td>
                    <td>
                        <c:out value="${contact.phone}" />
                    </td>

                    <td>
                        <a href="/contacts?function=edit&userid=<c:out value="${contact.userid}"/>">Update</a>
                    </td>

                    <td>
                        <a href="/contacts?function=delete&userid=<c:out value="${contact.userid}"/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/contacts?function=insert">Add new contact</a>
</body>
</html>