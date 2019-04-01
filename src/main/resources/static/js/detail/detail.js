ajaxMenus();
ajaxDetail();

var name_input = localStorage.getItem("comName_input");
var email_input = localStorage.getItem("comEmail_input");
var comId_input = localStorage.getItem("comId_input");

if (name_input != "" && name_input != null && comId_input != "" && comId_input != null) {
    $(".comment p").text(name_input + ", 想说点什么?");
    $(".comName").remove();
    $(".comEmail").remove();

}

function ajaxMenus() {
    $.ajax({
        url: "/menu/queryMenus.do", success: function (result) {
            var datas = result.data;
            for (var i = 0; i < datas.length; i++) {
                if (datas[i].menus == "" || datas[i].menus == null) {
                    return;
                }
                if (datas[i].menuUrl == "" || datas[i].menuUrl == null) {
                    datas[i].menuUrl = "#";
                }
                $(".menu-ul").append('<li><a onclick="toCard(' + datas[i].id + ')">' + datas[i].menus + '</a></li>');
            }
        }
    });
}

function toCard(ids) {
    window.location.href = "/index.do?id=" + ids;
}

var cardId = "";

function ajaxDetail() {
    $.ajax({
        url: "/card/queryCardToTitle.do", success: function (result) {
            var res = JSON.parse(result);
            var datas = res.data;
            cardId = datas.id;
            // console.log(datas);
            $(".menu-two-ul li a").text(datas.menuId);
            $(".names").text(datas.userId);
            $(".upTimes").text(" @ " + datas.upTime);
            $("h3").text(datas.title);
            $(".contexts p").text(datas.context);
            ajaxDiscuss(datas.id);
        }
    });
}

function ajaxDiscuss(cardId) {
    $.ajax({
        url: "/discuss/queryDiscuss.do?cardId=" + cardId, success: function (result) {
            var res = JSON.parse(result);
            var datas = res.data;
            // console.log(datas);
            $(".discuss").remove();
            for (var i = 0; i < datas.length; i++) {
                $(".discusing").prepend('<div class="discuss"><p class="disName">' + datas[i].userId + '</p><p class="disText">' + datas[i].context + '</p></div>');
            }
        }
    });
}

$(".comBtn").on("click", function () {
    var comContext = $(".comContext").val();
    if (localStorage.getItem("comName_input") != "" && localStorage.getItem("comName_input") != null && localStorage.getItem("comId_input") != "" && localStorage.getItem("comId_input") != null) {
        $(".comment p").text(localStorage.getItem("comName_input") + ", 想说点什么?");
        $(".comName").remove();
        $(".comEmail").remove();
        comments(comContext, localStorage.getItem("comId_input"), cardId);
        ajaxDiscuss(cardId);
    } else {
        var comName_input = $("#comName-input").val();
        var comEmail_input = $("#comEmail-input").val();
        if (comName_input == "") {
            return alert("错误,请正确输入昵称与邮箱信息!");
        } else {
            $.ajax({
                url: "/user/login.do?name=" + comName_input + "&password=" + comEmail_input,
                success: function (result) {
                    var res = JSON.parse(result);
                    var datas = res.data;
                    // console.log(datas);
                    if (datas == "" || datas == null || datas.name == "") {
                        // 没有账号
                        $.ajax({
                            url: "/user/addUser.do?name=" + comName_input + "&password=" + comEmail_input,
                            success: function (result) {
                                var res = JSON.parse(result);
                                var datas = res.data;
                                // console.log(datas);
                                if (datas == "1") {
                                    $.ajax({
                                        url: "/user/queryUser.do?name=" + comName_input,
                                        success: function (result) {
                                            var res = JSON.parse(result);
                                            var datas = res.data;
                                            console.log(datas[0].id);
                                            localStorage.setItem("comId_input", datas[0].id);
                                            localStorage.setItem("comName_input", comName_input);
                                            localStorage.setItem("comEmail_input", comEmail_input);
                                            $(".comment p").text(comName_input + ", 想说点什么?");
                                            $(".comName").remove();
                                            $(".comEmail").remove();
                                            // alert(cardId);
                                            comments(comContext, datas[0].id, cardId);
                                        }
                                    })
                                } else {
                                    alert("操作失败咯,看来您的人品不是很好呀!")
                                }
                            }
                        })
                    } else {
                        localStorage.setItem("comId_input", datas.id);
                        localStorage.setItem("comName_input", comName_input);
                        localStorage.setItem("comEmail_input", comEmail_input);
                        $(".comment p").text(datas.name + ", 想说点什么?");
                        $(".comName").remove();
                        $(".comEmail").remove();
                        // alert(cardId);
                        comments(comContext, datas.id, cardId);
                    }
                }
            });
        }
    }
})

// 发评论
function comments(comContext, userId, cardId) {
    $.ajax({
        url: "/discuss/addDiscuss.do?context=" + comContext + "&userId=" + userId + "&cardId=" + cardId,
        success: function (result) {
            var res = JSON.parse(result);
            var datas = res.data;
            // console.log(datas);
            if (datas == "1") {
                ajaxDiscuss(cardId);
                // 发送成功,清空textear
                $(".comContext").val("");
            } else {
                alert("评论失败咯,看来您的人品不是很好呀!");
            }
        }
    })
}

$(".discuss").on("contextmenu", function () {
    alert("点击了右键");
    return false;
});