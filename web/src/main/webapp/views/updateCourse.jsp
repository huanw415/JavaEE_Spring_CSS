<%@ page import="com.tw.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tw.entity.Employee" %>
<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/17/15
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改课程信息</title>
  <link href="../../styles/updateCourses.css" rel="stylesheet">

  <script src="../../lib/js/jquery-1.11.1.min.js"></script>
  <script src="../../js/updateCourse.js"></script>
</head>
<body>
<div class="container">
  <form id="create_course">

      <h3>修改用户信息</h3>
      <hr class="divider"/>

      <div class="form-group">
          <label for="name">姓名：</label>
          <input type="text" class="form-control" name="courseName" id="name" placeholder="姓名" value="<%= ((Course)request.getAttribute("course")).getName()%>">
      </div>

      <div class="form-group">
        <label for="dropdown">教练：</label>

        <select id="dropdown" name="coachId" data-coach="<%= ((Course) request.getAttribute("course")).getEmployee().getId()%>">
          <%
            List<Employee> coaches = (List<Employee>)request.getAttribute("coaches");

            for(int i=0; i<coaches.size(); i++){
          %>

          <option id="<%= coaches.get(i).getName()%>" data-id="<%= coaches.get(i).getId()%>" data-name="<%= coaches.get(i).getName()%>" value="<%= coaches.get(i).getId()%>">
            <%= coaches.get(i).getName()%>
          </option>
          <%
            }
          %>
        </select>
      </div>

    <div class="footer_button">
      <button class="submit" type="submit" data-id="<%= ((Course) request.getAttribute("course")).getId() %>">提交</button>
      <button class="return" type="button" href="/web/courses">返回</button>
      <button class="reset" type="reset">清空</button>
    </div>
  </form>

</div>
</body>
</html>




