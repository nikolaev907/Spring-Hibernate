<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
    <h1>${courses}</h1>
    <a href="/setCookie">Set cookie</a>
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                type: "POST",
                url: '/course/add',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({id: 57, name: 'Java middle', duration: 120, teacher: null, student: null}),
                dataType: 'json'
            });
        });
    </script>
</body>
</html>
