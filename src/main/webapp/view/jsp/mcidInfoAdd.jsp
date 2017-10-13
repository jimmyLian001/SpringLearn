<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script src="../utils/jquery.js" type="text/javascript"></script>
<br><br>
<br><br>
<center>
    <div class="searchDiv">
        <h1 style="color:red">应用入口</h1>
        <div id="btnDiv" style="height: 45px">
            <button type="button" id="fileButton"  onclick="javascript:window.location.href='fileUploadAndDown.jsp'"
                    class="l-button" style="margin-left: 02%;margin-top: 10px">跳转至文件上产页面 </button>
            <button type="button" id="jfreeButton"  onclick="javascript:window.location.href='jfreeChart.jsp'"
                    class="l-button" style="width: 150px">跳转JfreeChart页面</button>
            <button type="button" id="colseWindow1" class="l-button" style="width: 90px">保存并记账</button>
            <button type="button" id="colseWindow" class="l-button">关闭</button>
            <br>
        </div>
    </div>
    <form id="emailForm" name="emailForm" enctype="multipart/form-data" onsubmit="send()">
        <div id="emailDiv">
            <tr>
                <td>邮件主题：</td>
                <td><input type="text" id="subject" name="subject"></td>
            </tr>
            <tr>
                <td>邮件正文：</td>
                <td><input type="text" id="content" style="width:300px;height: 60px" name="content"></td>
            </tr>
            <tr>
                <td>收件人：</td>
                <td><input type="text" id="emailTo" name="emailTo"></td>
            </tr>
            <tr>
                <td>抄送人：</td>
                <td><input type="text" id="emailCc" name="emailCc"></td>
            </tr>
            <tr>
                <%--<td></td>--%>
                <input type="button" onclick="javascript:send()" value="发送" style="color:#138F8F">
            </tr>
        </div>
    </form>

</center>

<script type="text/javascript">
    window.onload = function () {
//        alert("hello world");
    }
    //        alert("正在发送");
    function send() {
        console.log($("#emailForm").serialize());
            $.ajax({
                type: "POST", //表单提交类型
                url: "${ctx}/email/sendEmail.do", //表单提交目标
                data: $('#emailForm').serialize(), //表单数据
                success: function (msg) {
                    if (msg.success == true) {//msg 是后台调用action时，你传过来的参数
                        //do things here
                        alert("邮件发送成功");
                        window.close();
                    } else {
                        alert("邮件发送失败");
                        //do things here
                    }
                },
                error: function () {
                    alert("操作失败，请重试或联系管理员");
                }
            });
            //return false; //阻止表单的默认提交事件
    }

</script>