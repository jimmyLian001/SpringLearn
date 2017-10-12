<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<script src="../utils/jquery.js" type="text/javascript"></script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>文件操作</title>
</head>
<body>
<center>
    <h1 style="color:red">文件上传操作</h1>
    <form id="fileUploadForm" name="emailForm" enctype="multipart/form-data" action="${ctx}/fileOs/upload.do" method="post">
        <div id="emailDiv">
            <tr>
                <td>文件上传至服务器：</td>
                <td><input type="file" id="uploadFile" name="uploadFile"></td>
            </tr>
            <tr>
                <input type="submit" value="上传" style="color:#730F8F">
            </tr>
        </div>
    </form>


    <form name="serForm" action="${ctx}/fileOs/uploadStream.do" method="post"  enctype="multipart/form-data">
        <h1 style="color: #138F8F" >采用流的方式上传文件 </h1>
        <td>文件上传至服务器：</td>
        <input type="file" name="file">
        <input type="submit" value="上传"/>
    </form>

    <form name="Form2" action="${ctx}/fileOs/uploadMultipart.do" method="post"  enctype="multipart/form-data">
        <h1 style="color: #138F8F">采用multipart提供的file.transfer方法上传文件</h1>
        <td>文件上传至服务器：</td>
        <input type="file" name="file">
        <input type="submit" value="上传"/>
    </form>

    <form name="Form2" action="${ctx}/fileOs/uploadSpring.do" method="post"  enctype="multipart/form-data">
        <h1 style="color: #138F8F">使用spring mvc提供的类的方法上传文件</h1>
        <td>文件上传至服务器：</td>
        <input type="file" name="file">
        <input type="submit" value="上传"/>
    </form>
</center>

</body>

<script type="text/javascript">
    function upload() {
        console.log($("#fileUploadForm").serialize());
        $.ajax({
            type: "POST", //表单提交类型
            url: "${ctx}/email/sendEmail.do", //表单提交目标
            data: $('#fileUploadForm').serialize(), //表单数据
            success: function (msg) {
                if (msg.success == true) {//msg 是后台调用action时，你传过来的参数
                    //do things here
                    alert("文件上传成功");
                    window.close();
                } else {
                    alert("文件上传失败");
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
</html>


