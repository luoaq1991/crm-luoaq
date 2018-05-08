function searchCustomer() {
    $("#dg").datagrid("load", {
        khno: $("#s_khno").val(),
        name: $("#s_name").val()
    });
}

/*加载页面，对话框关闭并初始化*/
$(function () {
    $("#dlg").dialog({
        onClose: function () {
            initFormData();
        }
    });
});

function initFormData() {
    //清空$("#fm")的数据.
    $("#id").val("");
    $("#name").val("");
    $("#area").combobox("clear");
    $("#cusManager").combobox("clear");
    $("#level").combobox("clear");
    $("#myd").combobox("clear");
    $("#xyd").combobox("clear");
    $("#postCode").val("");
    $("#phone").val("");
    $("#fax").val("");
    $("#webSite").val("");
    $("#address").val("");
    $("#yyzzzch").val("");
    $("#fr").val("");
    $("#zczj").val("");
    $("#nyye").val("");
    $("#khyh").val("");
    $("#khzh").val("");
    $("#dsdjh").val("");
    $("#gsdjh").val("");
}

function openCustomerAddDialog() {
    openDlg("dlg", "添加客户信息");
}

function closeCustomerDialog() {
    closeDlg("dlg");
}

function saveOrUpdateCustomer() {
    var id = $("#id").val();
    var url = ctx + "/customer/insert";
    if (!isEmpty(id)) {
        url = ctx + "/customer/update"
    }
    saveOrUpdate("fm", url, searchCustomer, "dlg");
}

function openCustomerModifyDialog() {
    openModifyDlg("dg", "fm", "dlg", "修改客户信息");
}


function deleteCustomer() {
    delRecode("dg", ctx + "/customer/delete", searchCustomer);
}


function openCustomerOtherInfo(title, type) {
    var rows = $("#dg").datagrid("getSelections");
    if (rows.length == 0) {
        $.messager.alert("来自crm", "请选择一条客户记录", "info");
        return;
    }
    if (rows.length > 1) {
        $.messager.alert("来自crm", "只能选择一条客户记录", "info");
        return;
    }

    window.parent.openTab(title, ctx + "/customer/toOtherPage/" + type + "/" + rows[0].id);
}


