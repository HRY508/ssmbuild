
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
<%--点击提交前端会提交这个请求后端会映射这个地址做出响应的操作这里面的name必须和后端实体类中的属性对应一致--%>
        <form action="${pageContext.request.contextPath}/book/addBook" method="post">
            <div class="form-group">
                <label>书籍名称</label>
<%--required表单中必须填写内容--%>
                <input type="text" name="bookName" class="form-control" required>
            </div>
            <div class="form-group">
                <label>书籍数量</label>
                <input type="text" name="bookCounts" class="form-control" required>
            </div>
            <div class="form-group">
                <label>书籍描述</label>
                <input type="text" name="detail"  class="form-control" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="添加">
            </div>
        </form>
    </div>
</div>
</body>
</html>
