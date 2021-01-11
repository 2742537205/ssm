$(function(){
    $("#btn").click(function () {
        var username = $("#username").val();
        var pwd = $("#inputPassword3").val();
        $.get("user/login.do", { username: username, password:pwd},
            function(data){
                alert("登录成功");
            });
    })
})


