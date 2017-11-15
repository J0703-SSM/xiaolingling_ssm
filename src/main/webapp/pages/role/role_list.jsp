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
        function deleteRole(roleId) {
            var r = window.confirm("确定要删除此角色吗？");

            if (r == true) {
                /*发起保存更新的请求*/
                $.ajax({
                    type: "post",
                    url: "/role/roleDelete",
                    data: {
                        "roleId": roleId
                    },
                    success: function (result) {
                        document.getElementById("operate_result_info").style.display = "block";
                        location.href = "/role/role_list";
                    }
                })
            }
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
    <form action="" method="">
        <!--查询-->
        <div class="search_add">
            <input type="button" value="增加" class="btn_add" onclick="location.href='role_add';"/>
        </div>
        <!--删除的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';"/>
            删除成功！
        </div> <!--删除错误！该角色被使用，不能删除。-->
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>角色 ID</th>
                    <th>角色名称</th>
                    <th class="width600">拥有的权限</th>
                    <th class="td_modi"></th>
                </tr>
                <c:if test="${roleInfos !=null and roleInfos.size() > 0}">
                    <c:forEach items="${roleInfos}" var="role">
                        <tr>
                            <td>${role.roleId}</td>
                            <td>${role.name}</td>
                            <td>
                                <c:if test="${role.moduleInfos != null and role.moduleInfos.size() >0}">
                                    <c:forEach items="${role.moduleInfos}" var="module" varStatus="status">
                                        ${module.name}
                                        <c:if test="${!status.last}">
                                            、
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </td>
                            <td>
                                <input type="button" value="修改" class="btn_modify"
                                       onclick="location.href='role_modi?roleId=${role.roleId}';"/>
                                <input type="button" value="删除" class="btn_delete"
                                       onclick="deleteRole(${role.roleId});"/>
                            </td>
                        </tr>
                    </c:forEach>

                </c:if>
            </table>
        </div>
        <!--分页-->
        <div id="pages">
            <a href="#">上一页</a>
            <a href="#" class="current_page">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">下一页</a>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <p>版权所有(C)云科技有限公司 </p>
</div>
</body>
</html>
