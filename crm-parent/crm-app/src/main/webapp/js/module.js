function searchModules() {
    $("#dg").datagrid("load", {
        moduleName: $("#moduleName").val(),
        optValue: $("#optValue").val(),
        parentModuleName: $("#parentModuleName").val()
    });
}

function formatterGrade(val) {
    if (val == 0) {
        return "根级";
    }
    if (val == 1) {
        return "第一级";
    }
    if (val == 2) {
        return "第二级";
    }
}


$(function () {

    $("#dlg").dialog({
        onClose: function () {
            initFormData();
        }
    });

    $("#temp").hide();

    $("#grade").combobox({
        onChange: function (grade) {
            if (grade == 1 || grade == 2) {
                $("#temp").show();
            }
            if (grade == 0) {
                $("#temp").hide();
            }

            loadParentModules(grade - 1);

        }

    });


});

function loadParentModules(grade) {
    $("#parentId").combobox("clear");
    $("#parentId").combobox({
        url: ctx + "/module/queryModulesByGrade?grade=" + grade,
        valueField: 'id',
        textField: 'moduleName'
    });
}

function initFormData() {
    $("#fm").form("clear");
}


function openAddModuleDialog() {
    openDlg("dlg", "添加模块");
}


function closeDialog() {
    closeDlg("dlg");
}


function saveOrUpdateModule() {
    saveOrUpdate("fm", ctx + "/module/insert", searchModules, "dlg");
}


function deleteModule() {
    delRecode("dg", ctx + "/module/delete", searchModules);
}