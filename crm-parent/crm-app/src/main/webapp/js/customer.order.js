function formatterState(val) {
    if (val == 0) {
        return "未支付";
    }
    if (val == 1) {
        return "已支付"
    }
}

function formatterOp() {
    var href = "javascript:openOrderDetailByOid()";
    return "<a href=" + href + ">查看详情</a>";
}

//查询详情
function openOrderDetailByOid() {
    var rows = $("#dg").datagrid("getSelections");

    //查询数据
    $.ajax({
        type: "post",
        url: ctx + "/customer_order/queryCustomerOrderByOrderId",
        data: "orderId=" + rows[0].id,
        dataType: "json",
        success: function (data) {
            if (data.data.state == 0) {
                data.data.state = "未支付";
            }
            if (data.data.state == 1) {
                data.data.state = "已支付";
            }

            data.data.orderDate = new Date(data.data.orderDate).format("yyyy-MM-dd hh:mm:ss");

            $("#fm").form("load", data.data);

        }
    });

    $("#dg2").datagrid("load", {
        orderId: rows[0].id
    });

    $("#dlg").dialog("open");
}

function closeOrderDetailDialog() {
    closeDlg("dlg");

}