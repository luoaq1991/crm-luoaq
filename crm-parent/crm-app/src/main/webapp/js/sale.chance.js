/*
20180502 疑问
1. easyui 前后台查询交互。
2. 此处需校验参数，例如电话号码不能出现特殊字符等。
 */
function searchSaleChances() {
    $('#dg').datagrid("load", {
        createMan: $('#createMan').val(),
        customerName: $('#customerName').val(),
        createDate: $('#createDate').datebox("getValue"),
        state: $('#state').combobox("getValue")

    });

    /*var createMan = $('#createMan').val()
    var customerName = $('#customerName').val()
    var createDate = $('#createDate').datebox("getValue")
    var state = $('#state').combobox("getValue")

    var params = {}
    if (!isEmpty(createMan)) {
        params.createMan = createMan
    } else {
        params.createDate = ""
    }

    if (!isEmpty(customerName)) {
        params.customerName = customerName;
    } else {
        params.customerName = ""
    }

    if (!isEmpty(createDate)) {
        params.createDate = createDate;
    } else {
        params.createDate = "";
    }

    if (!isEmpty(state)) {
        params.state = state;
    } else {
        params.state = ""
    }

    $.ajax({
        type: "post",
        url: ctx + "/marketing/querySaleChancesByParams",
        data: params,
        dataType: "json",
        success: function (data) {
            if (data.code == 200) {
                $('#dg').datagrid("load", {
                    createMan: $('#createMan').val(),
                    customerName: $('#customerName').val(),
                    createDate: $('#createDate').datebox("getValue"),
                    state: $('#state').combobox("getValue")

                });
            } else {
                alert(data.msg)
            }
        }

    });*/


}

/*将数据库中，state 改为文字描述*/
function formatterState(val) {
    if (val == 0) {
        return "未分配"
    } else if (val == 1) {
        return "已分配"
    } else {
        return "未定义"
    }

}

$(function () {
    $('#dlg').dialog({
        onClose: function () {
            initFormData();
        }
    });

    $('#createMan').val($.cookie("trueName"));

});

function initFormData() {
    $('#fm').form("clear");

}

//添加营销机会按钮
function openAddSaleChanceDialog() {
    openDlg("dlg", "添加营销记录数据")
}


function closeDialog() {
    closeDlg("dlg");
}

/*执行更新*/
function saveSaleChance() {
    var save_update_url = ctx + "/marketing/insert";
    var id = $("#id").val();
    if (!isEmpty(id)) {
        //更新机会
        save_update_url = ctx + "/marketing/update";
    }
    saveOrUpdate("fm", save_update_url, searchSaleChances, "dlg");


}

//打开修改对话框
function openModifySaleChanceDialog() {
    openModifyDlg("dg", "fm", "dlg", "更新营销机会记录")
}


//删除营销机会
function deleteSaleChance() {
    delRecode("dg", ctx + "/marketing/delete", searchSaleChances())
}

