$(function(){
    $("#btn").click(function () {
        //获取订单地址
        var address = $("#username").val();
        //获取收货人信息
        var username = $("#inputPassword3").val();
        //获取收货人电话
        var phone = $("#confirmpwd").val();

        $.get("order/addOrder.do", {"address":address,"username":username,"phone":phone},
            function(data){
                alert(data);
            });

    })
})

