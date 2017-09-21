<%--
  Created by IntelliJ IDEA.
  User: BF100
  Date: 2017/9/20
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录界面</title>
</head>
<body>
<center>
    <h1 style="color:red">登录</h1>
    <form id="indexform" name="indexForm" action="${ctx}/login/loginCheck.do" method="post">
        <table border="0">
            <tr>
                <td>账号：</td>
                <td><input type="text" id="username" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" id="password" name="password">
                </td>
            </tr>
        </table>
        <br>
        <input type="submit" value="登录" style="color:#BC8F8F">
    </form>
    <form action="zhuce.jsp">
        <input type="submit" value="注册" style="color:#BC8F8F">
    </form>
    <script type="text/javascript">
        function loginCheck(){
            alert('Hello,JavaScript!');
                $("#indexform").submit(function (){
                    var ajax_url = "${ctx}/login/loginCheck.do"; //表单目标
                    var ajax_type = $(this).attr('POST'); //提交方法
                    var ajax_data = $(this).serialize(); //表单数据

                    $.ajax({
                        type:ajax_type, //表单提交类型
                        url:ajax_url, //表单提交目标
                        data:ajax_data, //表单数据
                        success:function(msg){
                            if(msg == 'success'){//msg 是后台调用action时，你传过来的参数
                                //do things here
//                                window.close();
                            }else{
                                //do things here
                            }
                        }
                    });
                    //return false; //阻止表单的默认提交事件
                });
        }

    </script>
</center>
</body>

</html>
