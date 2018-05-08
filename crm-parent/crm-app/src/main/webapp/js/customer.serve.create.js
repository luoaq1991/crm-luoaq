function saveCustomerService() {
    $("#fm").form("submit", {
        url: ctx + "/server/insert",
        //表单提交
        onSubmit: function (params) {
            params.createPeople = $.cookie("trueName");
            return $("#fm").form("validate");
        },
        success: function (data) {
            //提交成功后回调
            data = JSON.parse(data);
            if (data.code == 200) {
                $.messager.alert("来自crm", data.msg, "info");
                $("#serveType").combobox("clear");
                $("#customer").val("");
                $("#overview").val("");
                $("#serviceRequest").val("");
            } else {
                $.messager.alert("来自crm", data.msg, "info");
            }
        }

    });

}


function resetValue() {

    $("#serveType").combobox("clear");
    $("#customer").val("");
    $("#overview").val("");
    $("#serviceRequest").val("");

}