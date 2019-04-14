<html>
<head>
    <title>成功提示</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="col-md-12 column">
    <div class="alert alert-dismissable alert-success">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        <h4>
            成功!
        </h4> <strong>${message}</strong>  <a href="${url}" class="alert-link">三秒后自动跳转</a>
    </div>
</div>
</body>
<script>
    setTimeout('location.href="${url}"',3000)
</script>
</html>
