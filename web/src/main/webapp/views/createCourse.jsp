<%@ page import="com.tw.entity.Employee" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: hgwang
  Date: 7/20/15
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加课程</title>

  <link href="../styles/createCourse.css" rel="stylesheet">

  <script src="../lib/js/jquery-1.11.1.min.js"></script>
  <script src="../js/createCourse.js"></script>
</head>
<body>
  <div class="container">
    <form id="new_course" name="new_schedule">
          <h3>添加课程</h3>
          <hr class="divider"/>
          <div class="form-group">
            课程名称:
              <label for="courseName">
                <input type="text" id="courseName" name="courseName">
              </label>
          </div>

          <div class="form-group">
            <label>教&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;练：</label>
            <select name="coachName" id="selector">
              <%
                List<Employee> employeeList = (List<Employee>) request.getAttribute("coaches");
                for(int i=0; i<employeeList.size(); i++){
              %>
              <option id="<%= employeeList.get(i).getName()%>" value="<%= employeeList.get(i).getName()%>">
                <%= employeeList.get(i).getName()%>
              </option>
              <%
                }
              %>
            </select>

          </div>

      <div class="footer_button">
        <button type="submit">提交</button>
        <button type="button" class="return">返回</button>
        <button type="reset">清空</button>
      </div>
    </form>
  </div>

</body>
</html>
