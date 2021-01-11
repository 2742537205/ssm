$(function () {
    var num = 0;

    $("li").click(function () {
        num = $(this).text();
        page(num);
    })
    page(num);
})

function page(num){

    var lj = $("#PageContext").val();
    $.get("pro/pageInfo.do", {"num":num},
        function(data){
            $("#di>div:gt(0)").remove();
            for(var i=0;i<data.length;i++){
                $("#di").append("<div class=\"col-md-2\">\n" +
                    "\t\t\t\t<a href="+lj+"/pro/pInfo.do?method=get&pid="+data[i].pid+">\n" +
                    "\t\t\t\t\t<img src='"+lj+"/"+data[i].pimage+"' width=\"170\" height=\"170\" style=\"display: inline-block;\">\n" +
                    "\t\t\t\t</a>\n" +
                    "\t\t\t\t<p><a href="+lj+"/pro/pInfo.do?method=get&pid="+data[i].pid+">"+data[i].pname+"</a></p>\n" +
                    "\t\t\t\t<p><font color=\"#FF0000\">商城价：&yen;"+data[i].shop_price+"</font></p>\n" +
                    "\t\t\t</div>")
            }
        });
}

