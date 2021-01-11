$(function(){
    $("#btn").click(function () {
       //获取要加入购物车商品的编号
        var value = $("#pid").text();
        //由于编号前面有其他字符，需要分隔符获取 为编号的字符
        var value2 = value.split(":");
        //编号
        var pid = value2[1];
        //获取商品数量
        var num = $("#quantity").val();

        window.location.href="pro/PInfoList.do?method=get&pid="+pid+"&num="+num+"";
    })
})