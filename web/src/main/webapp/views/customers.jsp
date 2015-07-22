<%@ page import="com.tw.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tw.entity.Course" %>
<%@ page import="org.dom4j.io.ElementModifier" %>
<%@ page import="com.tw.entity.Employee" %>
<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/17/15
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>课程管理</title>

  <link href="./lib/css/bootstrap.css" rel="stylesheet"/>
  <link href="./styles/customers.css" rel="stylesheet">

  <script src="./lib/js/jquery-1.11.1.min.js"></script>
  <script src="./lib/js/bootstrap.min.js"></script>

  <script src="./js/customers.js"></script>
</head>
<body>
  <%@ include file="navBar.jsp" %>

  <div class="container">
    <table class="table table-bordered">
      <caption><h2>顾客信息表</h2></caption>
      <tr>
        <th>姓名</th>
        <th>私教</th>
        <th>修改</th>
        <th>删除</th>
      </tr>
      <%
        List<Customer> customers = (List<Customer>)request.getAttribute("customers");

        for(int i=0; i<customers.size(); i++){
      %>
      <tr>
        <td><%= customers.get(i).getName()%></td>
        <%
          String coach = "";
          List<Course> courses = customers.get(i).getCourses();
          for(int j=0; j<courses.size(); j++){
            if(courses.get(j).getName().equals("private")){

              coach = courses.get(j).getEmployee().getName();
            }
          }
        %>
        <td><%= coach %></td>
        <td>
          <a href="./customers/update/<%= customers.get(i).getId()%>">修改</a>
        </td>
        <td>
          <a type="button" class="deleteCustomer" data-id="<%= customers.get(i).getId()%>">删除</a>
          <%--<a type="button" class="deleteSchedule" data-id="<%= schedules.get(i).getId()%>">删除</a>--%>
        </td>
      </tr>
      <%
        }
      %>
    </table>
    <div>
      <a type="button" href="./customers/creation">添加顾客</a>
    </div>

  </div>
</body>
</html>
