<%--
  Created by IntelliJ IDEA.
  User: BF100
  Date: 2017/10/17
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../js/plugins/picker/jquery-ui-timepicker-addon.js"></script>
<html>
<head>
    <title>数据展示</title>
</head>
<body>
<div>
    <h2>搜索条件</h2>
</div>

<div id="search" class="tool-bar">
    <div class="row-form">
        <div class="span" style="width:90px;">开始时间</div>
        <div class="span2">
            <input type="datetime-local" name="beginTime" id="beginTime" class="datetimepicker">
        </div>
        <div class="span" style="width:90px;">结束时间</div>
        <div class="span2">
            <input type="datetime-local" name="endTime" id="endTime">
        </div>
        <div class="span" style="width:90px;">身份证号码</div>
        <div class="span2">
            <input type="text" name="idNo" id="idNo">
        </div>
        <div class="span" style="width: 200px;">
            <input type="button" onclick="search()" value="搜索">
        </div>
        <div class="span" style="width: 200px;">
            <input type="button" onclick="clear()" value="清空">
        </div>
    </div>
</div>
</body>
</html>
