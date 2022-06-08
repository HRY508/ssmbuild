<%--
  Created by IntelliJ IDEA.
  User: 508816739
  Date: 2022/6/5
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
        <%--点击提交前端会提交这个请求后端会映射这个地址做出响应的操作这里面的name必须和后端实体类中的属性对应一致--%>
        <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
            <%--出现的问题，我们提交了修改的SQL请求，但是修改失败初次考虑是事务的问题配置完毕事务依旧失败--%>
                <%--看一下SQL语句能否执行成功：SQL执行失败修改未完成--%>
                <%--前端传递隐藏域--%>
                <input type="hidden" name="bookID" value="${book.bookID}">
            <div class="form-group">
                <label>书籍名称</label>
                <%--required表单中必须填写内容--%>
                <input type="text" name="bookName" class="form-control" value="${book.bookName}" required>
            </div>
            <div class="form-group">
                <label>书籍数量</label>
                <input type="text" name="bookCounts" class="form-control" value="${book.bookCounts}" required>
            </div>
            <div class="form-group">
                <label>书籍描述</label>
                <input type="text" name="detail"  class="form-control" value="${book.detail}" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
        </form>
    </div>
</div>
</body>
</html>
