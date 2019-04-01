var map = {};//创建map集合
ajaxMenus();
ajaxCards(0, 0);

function getRequest() {
    var url = window.location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {

            theRequest[strs[i].split("=")[0]] = decodeURI(strs[i].split("=")[1]);

        }
    }
    return theRequest;
}

var mid = getRequest().id;

if (mid != '' && mid != null) {
    ajaxCards(mid, 0);
}

var list_m = new Array();//创建list集合
list_m.push(0);

var list_t = new Array();//创建list集合
list_t.push(0);

function ajaxMenus() {
    $.ajax({
        url: "/menu/queryMenus.do", success: function (result) {
            var datas = result.data;
            for (var i = 0; i < datas.length; i++) {
                map['key'] = datas[i].id;
                map['value'] = datas[i].menus;
                if (datas[i].menus == "" || datas[i].menus == null) {
                    return;
                }
                if (datas[i].menuUrl == "" || datas[i].menuUrl == null) {
                    datas[i].menuUrl = "#";
                }
                $(".menu-ul").append('<li><a onclick="ajaxCards(' + datas[i].id + ',' + list_t + ')">' + datas[i].menus + '</a></li>');
            }
        }
    });
}

function ajaxCards(menuId, two) {
    list_m = [];
    list_m.push(menuId);
    $.ajax({
        url: "/card/queryCard.do?menuId=" + menuId + "&cardTwo=" + two, success: function (result) {
            var res = JSON.parse(result);
            var datas = res.data;
            $(".cards").remove();
            $(".notInfo").remove();
            if (datas.length <= 0) {
                $("#lefts").append('<div class="notInfo">暂未发现新的数据..</div>');
            }
            for (var i = 0; i < datas.length; i++) {
                $("#lefts").append('<div class="cards"><div class="imgs"><img src="' + datas[i].imgUrl + '" width="175" height="98" /></div><div class="texts"><h4>' + datas[i].title + '</h4><span><a href="#">' + datas[i].userId + '</a> ・ <a href="#">' + datas[i].menuId + '</a></span>  <p>' + datas[i].synopsis + '</p></div></div>');
            }
        }
    });
}


$(".menu-two-ul li").click(function () {
    var two = $(this).text();
    if (two == '今天') {
        two = '0';
        ajaxCards(list_m, two);
    } else if (two == '昨天') {
        two = '1';
        ajaxCards(list_m, two);
    } else { // 更多
        two = '-1';
        ajaxCards(0, two);
    }
    list_t = [];
    list_t.push(two);
});

$("#lefts").on("click", ".cards .imgs", function () {
    toDetail($(this).parent().find("h4").text());
});

$("#lefts").on("click", ".texts h4", function () {
    toDetail($(this).text());
});

function toDetail(title) {
    // $.ajax({url: "card/toDetail.do?title=" + title});
    window.location.href = "card/toDetail.do?title=" + title;
}
