<%--
  Created by IntelliJ IDEA.
  User: BF100
  Date: 2017/9/20
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<jsp:useBean id="db" class="Bean.DBBean" scope="page" />
<%
    request.setCharacterEncoding("UTF-8");
    String username=(String)request.getParameter("username");
    String password=(String)request.getParameter("password");//取出login.jsp的值

    //下面是数据库操作
    String sql="select * from login where username="+"'"+username+"'";//定义一个查询语句
    ResultSet rs=db.executeQuery(sql);//运行上面的语句
    if(rs.next())
    {
        /* if(password.equals(rs.getString(2)))
        {

        } */
        if(password.equals(rs.getObject("password"))){
            response.sendRedirect("loginsuccess.jsp");
        }
        else{
            out.print("<script language='javaScript'> alert('密码错误');</script>");
            response.setHeader("refresh", "0;url=login.jsp");
        }
    }
    else
    {
        out.print("<script language='javaScript'> alert('账号错误——else');</script>");
        response.setHeader("refresh", "0;url=login.jsp");
    }

%>
</body>
</html>
