<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css"/>
    <script type="application/javascript" src="/js/jquery-3.2.1.js"></script>
    <script language="javascript" type="text/javascript">
        //保存成功的提示消息
        function showResult(result) {
            showResultDiv(true);

            if (result == 0) {
                document.getElementById("save_result_info").innerHTML = "保存失败！角色名称重复！";
                window.setTimeout("showResultDiv(false,0);", 3000);
            } else {
                document.getElementById("save_result_info").innerHTML = "保存成功！";
                window.setTimeout("showResultDiv(false,1);", 3000);
            }
        }
        function showResultDiv(flag, result) {
            var divResult = document.getElementById("save_result_info");
            if (flag)
                divResult.style.display = "block";
            else {
                divResult.style.display = "none";
                if (result == 1) {
                    location.href = "/role/role_list";
                }
            }
        }

        function roleSave() {
            /*取权限列表的选中值*/
            var chk_value = [];
            $('#moduleIds:checked').each(function () {
                chk_value.push($(this).val());
            });
            /*发起保存更新的请求*/
            $.ajax({
                type: "post",
                url: "/role/roleSave",
                data: {
                    "moduleIds": chk_value,
                    "roleName": $("#roleName").val()
                },
                success: function (result) {
                    showResult(result);
                }
            })
        }

        function cancel() {
            location.href = "/role/role_list";
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="../images/logo.png" alt="logo" class="left"/>
    <a href="#">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <ul id="menu">
        <li><a href="/index" class="index_off"></a></li>
        <li><a href="role_list" class="role_on"></a></li>
        <li><a href="/admin/admin_list" class="admin_off"></a></li>
        <li><a href="/fee/fee_list" class="fee_off"></a></li>
        <li><a href="/account/account_list" class="account_off"></a></li>
        <li><a href="/service/service_list" class="service_off"></a></li>
        <li><a href="/bill/bill_list" class="bill_off"></a></li>
        <li><a href="/report/report_list" class="report_off"></a></li>
        <li><a href="/user/user_info" class="information_off"></a></li>
        <li><a href="/user/user_modi_pwd" class="password_off"></a></li>
    </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <!--保存操作后的提示信息：成功或者失败-->
    <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，角色名称重复！-->
    <form action="" method="" class="main_form">
        <div class="text_info clearfix"><span>角色名称：</span></div>
        <div class="input_info">
            <input type="text" class="width200" id="roleName"/>
            <span class="required">*</span>
            <div class="validate_msg_medium">不能为空，且为20长度的字母、数字和汉字的组合</div>
        </div>
        <div class="text_info clearfix"><span>设置权限：</span></div>
        <div class="input_info_high">
            <div class="input_info_scroll">
                <ul>
                    <c:if test="${moduleInfos != null and moduleInfos.size() >0}">
                        <c:forEach items="${moduleInfos}" var="item">
                            <li><input type="checkbox" id="moduleIds" value="${item.moduleId}"/>${item.name}</li>
                        </c:forEach>
                    </c:if>
                </ul>
            </div>
            <span class="required">*</span>
            <div class="validate_msg_tiny">至少选择一个权限</div>
        </div>
        <div class="button_info clearfix">
            <input type="button" value="保存" id="btnSave" class="btn_save" onclick="roleSave();"/>
            <input type="button" value="取消" id="btnCancel" class="btn_save" onclick="cancel();"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
    <br/>
    <span>版权所有(C)云科技有限公司 </span>
</div>
</body>
</html>
