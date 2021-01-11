$(function(){
    $("#btn").click(function () {
        var username = $("#usernam").val();
        var password = $("#confirmpwd").val();
        var email = $("#inputEmail3").val();
        var name = $("#usercaption").val();
        var sex =$('input[name="sex"]:checked').val();
        var birthday = $("#birthday1").val();
        var telephone = $("#s").val();
        $.get("user/register.do", { username: username, password: password,email:email,name:name,sex:sex,birthday:birthday,telephone:telephone },
            function(data){
                alert(data);
            });
    })
})





