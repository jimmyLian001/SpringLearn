<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script src="../utils/jquery.js" type="text/javascript"></script>
<br><br>
<br><br>

<div class="searchDiv">
    <div id="btnDiv" style="height: 45px">
        <button type="button" id="saveButton" class="l-button" style="margin-left: 38%;margin-top: 10px">保存</button>
        <button type="button" id="colseWindow1" class="l-button" style="width: 90px">保存并记账</button>
        <button type="button" id="colseWindow" class="l-button">关闭</button>
        <br>
    </div>
</div>
<form id="emailForm" name="emailForm" enctype="multipart/form-data" onsubmit="send()">
    <div id="emailDiv">
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
                    if (msg == 'success') {//msg 是后台调用action时，你传过来的参数
                        //do things here
//                                window.close();
                    } else {
                        //do things here
                    }
                },
                error: function () {
//                    alert("操作失败，请重试或联系管理员");
                }
            });
            //return false; //阻止表单的默认提交事件
    }

</script>