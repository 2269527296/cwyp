
    function baseUrl()
    {
//获取当前网址，如： http://localhost:8080/myproj/view/my.jsp
        var curWwwPath=window.document.location.href;
//获取主机地址之后的目录，如： myproj/view/my.jsp
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8080
        var localhostPaht=curWwwPath.substring(0,pos);
//获取带"/"的项目名，如：/myproj
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
//得到了 http://localhost:8080/myproj
        var realPath=localhostPaht+projectName;
        return realPath;
//alert(realPath);
    }

    var rres = 0
    let myData = [];

    $(function (){
        $("#modal").hide()
    $.ajax({
        type:"post",
        url:baseUrl()+"/img/query",
        dataType:"json",
        success:function (res){
            // var _tr = "";
            // $("#tb1").empty();
            // _tr = _tr + " <img src="+res[0].imgsrc+" alt=\"\">"
            // $("#tb1").append(_tr)
            // // $("#tb1").attr("src",res[0].imgsrc);
            // $("#tb2").attr("src",res[1].imgsrc);
            // $("#tb3").attr("src",res[2].imgsrc);
            // $("#tb4").attr("src",res[3].imgsrc);
            for(let i=0; i<res.length; i++) {
                myData.push(res[i]['imgsrc']);
            }
        }
    })
})

    var number = 1;
    function fun(){
        number ++ ;
        //判断number是否大于3
        if(number > 4){
            number = 1;
        }
        //获取img对象
        var img = document.getElementById("img");
        img.src = "http://wzxcwyp.mynatapp.cc/imgs/upload/cwlunbo"+number+".png";
    }

    //2.定义定时器
    setInterval(fun,3000);

    function getres(res){
        if(res==1){
            refugelogin()
        }
    }

    function refugelogin(){
        $("#modal").hide()
    }

    function jump(){
    $("#modal").show()
    }

    function scode(){
            window.location.href="/pages/cwypmanage.html"
    }

    function denglu(){
        var a = myform.name.value;
        var b = myform.password.value;
        $.ajax({
            type:"post",
            url:baseUrl()+"/user/login",
            data:{"username":a,"password":b},
            dataType:"json",
            success:function (res){
                if (res==1){
                    alert("登录成功")
                    getres(res)
                }
                else{
                    alert("账号或密码错误请重新输入")
                }
            }
        })
    }