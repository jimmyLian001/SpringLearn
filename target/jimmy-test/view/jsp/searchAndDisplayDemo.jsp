<%--
  Created by IntelliJ IDEA.
  User: BF100
  Date: 2017/10/17
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../utils/jquery.js" type="text/javascript"></script>
<html>
<head>
    <title>数据展示</title>
</head>
<body>
<center>
    <div>
        <h2>搜索条件</h2>
    </div>

    <form id="searchForm" name="searchForm" enctype="multipart/form-data" onsubmit="search()">
        <div id="emailDiv">
            <tr>
                <td>开始时间：</td>
                <td> <input type="datetime" name="beginTime" id="beginTime"> </td>
            </tr>
            <tr>
                <td>结束时间：</td>
                <td><input type="datetime" name="endTime" id="endTime"></td>
            </tr>
            <tr>
                <td>证件号码：</td>
                <td><input type="text" id="idNo" name="idNo"></td>
            </tr>
            <tr>
                <%--<td></td>--%>
                <input type="button" onclick="javascript:search()" value="查询" style="color:#138F8F">
                <input type="button" onclick="javascript:clearForm()" value="清空" style="color:#131F8F">
            </tr>
        </div>
    </form>



</center>

</body>
</html>
<script type="text/javascript">

    function clearForm(){
        console.info("已经进入清空方法");
        $('#searchForm')[0].reset();
    }

    function search() {
        console.log($("#searchForm").serialize());
        $.ajax({
            type: "POST", //表单提交类型
            url: "${ctx}/data/formSearch.do", //表单提交目标
            data: $('#searchForm').serialize(), //表单数据
            success: function (msg) {
                if (msg.success == true) {//msg 是后台调用action时，你传过来的参数
                    //do things here
                    alert("数据查询成功:"+msg);
//                    window.close();
                } else {
                    alert("数据查询失败");
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