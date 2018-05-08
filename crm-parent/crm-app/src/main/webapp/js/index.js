function userLogin() {
    //取得用户输入值
    var userName = $('#userName').val();
    var userPwd = $('#userPwd').val();

    if (isEmpty(userName)) {
        alert("用户名不能为空");
        return;
    }

    if (isEmpty(userPwd)) {
        alert("密码不能为空");
        return;
    }

    //组装数据
    var params = {};
    params.userName = userName;
    params.userPwd = userPwd;

    $.ajax({
        type: "post",
        url: ctx + "/user/userLogin",
        data: params,
        dataType: "json",
        success: function (data) {
            if (data.code == 200) {
                window.location.href = "main.shtml";
            } else {
                alert(data.msg)
            }

        }
    });


}