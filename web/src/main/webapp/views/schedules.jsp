<%@ page import="com.tw.entity.Schedule" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/20/15
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>课表管理</title>

  <link href="./lib/css/bootstrap.css" rel="stylesheet"/>
  <link href="./styles/schedules.css" rel="stylesheet">

  <script src="./lib/js/jquery-1.11.1.min.js"></script>
  <script src="./lib/js/bootstrap.min.js"></script>
  <script src="./js/schedules.js"></script>

</head>
<body>
  <%@ include file="navBar.jsp" %>

  <div class="container">
    <table class="table table-bordered">
      <caption><h2>课表</h2></caption>
      <tr>
        <th>课程名称</th>
        <th>教师</th>
        <th>时间</th>
        <th>顾客</th>
        <th>修改</th>
        <th>删除</th>
      </tr>
      <%
        List<Schedule> schedules = (List<Schedule>)request.getAttribute("schedules");

        for(int i=0; i<schedules.size(); i++){
      %>
      <tr>
        <td><%= schedules.get(i).getCourse().getName()%></td>
        <td><%= schedules.get(i).getCourse().getEmployee().getName()%></td>
        <td><%= schedules.get(i).getTime().substring(0, 10)%></td>
        <% String customer;
          if(schedules.get(i).getCustomer() != null){
            customer = schedules.get(i).getCustomer().getName();
          }else {
            customer = "";
          }
        %>
        <td><%= customer%></td>

        <td>
          <a href="./schedules/update/<%= schedules.get(i).getId()%>">修改</a>
        </td>
        <td>
          <a type="button" class="deleteSchedule" data-id="<%= schedules.get(i).getId()%>">删除</a>
        </td>
      </tr>
      <%
        }
      %>
    </table>

    <div>
      <a type="button" href="./schedules/creation">添加课表</a>
    </div>
  </div>
</body>
</html>
