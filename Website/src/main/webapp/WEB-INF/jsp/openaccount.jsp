
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<c:set var="basePath" value="<%=basePath %>"></c:set>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width,user-scalable=no" name="viewport" />
    <title>大圆中秋趴</title>
    <link rel="stylesheet" type="text/css" href="${imgPath}/assets/css/reset.css?v=${imgVersion}"/>
    <script src="${imgPath}/assets/thirdparty/jquery/jquery-1.11.3.min.js"></script>
    <script src="${imgPath}/assets/js/checkinfo.js?v=${imgVersion}"></script>
    <script>
        var basePath = '<%=basePath%>';
    </script>


    <%--加入微信签名及分享功能--%>
    <c:if test="${userAgent == 'MicroMessenger'}">
        <jsp:include page="include/weixinShareConfig.jsp"/>
        <script>
            var userAgent = "MicroMessenger";
            var customerName = '';
            var name = '${customerName}';
            if(name){
                customerName = checkFuXing(name)+'先生/女士 ';
            }else{
                customerName='大圆君';
            }
            //分享到朋友圈
            wx.ready(function () {
                wx.onMenuShareTimeline({
                    title: customerName + '携手大圆普洱，赠您新股藏品，邀您增值财富', // 分享标题
                    link: window.location.href,//分享当前url
                    imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}?v=${applicationScope['imgVersion']}', // 分享图标
                    success: function () {
                        // 用户确认分享后执行的回调函数
                    },
                    cancel: function () {
                        // 用户取消分享后执行的回调函数
                    }
                });

                //分享给朋友
                wx.onMenuShareAppMessage({
                    title: '${applicationScope['weixinDefaultShareTitle']}', // 分享标题
                    desc: customerName+'携手大圆普洱，赠您新股藏品，邀您增值财富', // 分享描述
                    link: window.location.href,//分享当前url
                    imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}?v=${applicationScope['imgVersion']}', // 分享图标
                    type: 'link', // 分享类型,music、video或link，不填默认为link
                    dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
                    success: function () {
                        // 用户确认分享后执行的回调函数
                    },
                    cancel: function () {
                        // 用户取消分享后执行的回调函数
                    }
                });

                wx.onMenuShareQQ({
                    title: '${applicationScope['weixinDefaultShareTitle']}', // 分享标题
                    desc: customerName+'携手大圆普洱，赠您新股藏品，邀您增值财富', // 分享描述
                    link: window.location.href,//分享当前url
                    imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}?v=${applicationScope['imgVersion']}', // 分享图标
                    success: function () {
                        // 用户确认分享后执行的回调函数
                    },
                    cancel: function () {
                        // 用户取消分享后执行的回调函数
                    }
                });

                wx.onMenuShareWeibo({
                    title:  '${applicationScope['weixinDefaultShareTitle']}', // 分享标题
                    desc: customerName+'携手大圆普洱，赠您新股藏品，邀您增值财富', // 分享描述
                    link: window.location.href,//分享当前url
                    imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}?v=${applicationScope['imgVersion']}', // 分享图标
                    success: function () {
                        // 用户确认分享后执行的回调函数
                    },
                    cancel: function () {
                        // 用户取消分享后执行的回调函数
                    }
                });

                wx.onMenuShareQZone({
                    title:  '${applicationScope['weixinDefaultShareTitle']}', // 分享标题
                    desc: customerName+'携手大圆普洱，赠您新股藏品，邀您增值财富', // 分享描述
                    link: window.location.href,//分享当前url
                    imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}?v=${applicationScope['imgVersion']}', // 分享图标
                    success: function () {
                        // 用户确认分享后执行的回调函数
                    },
                    cancel: function () {
                        // 用户取消分享后执行的回调函数
                    }
                });
            });
        </script>
    </c:if>
</head>

<body>
<div class="section">
    <img src="${imgPath}/assets/images/img0.jpg" class="bg" />
</div>
<div class="section f-pr">
    <img src="${imgPath}/assets/images/img1.jpg" class="bg" />
    <span id="customerHead" class="span-name"></span>
    <script>
        var name = '${customerName}';
        if(name){
            name=checkFuXing(name)+"先生/女士，邀请您：";
            $("#customerHead").html(name);
        }else{
            $("#customerHead").html("大圆君，邀请您：");
        }
    </script>
    <div class="btn btn-new">
        <a class="mt-35 btn-nowaccount" onclick="toOpenAccount();"></a>
        <c:if test="${1!=param.flag}">
            <a class="mt-35 old-share" href="${basePath}"></a>
        </c:if>

    </div>
</div>
<div class="section f-pr">
    <img src="${imgPath}/assets/images/img2.jpg" class="bg" />
    <a href="${applicationScope['systemPuerAppDownloadPage']}" class="download"><img src="${imgPath}/assets/images/download.png" /></a>
</div>
<div class="section f-dn" id="more">
    <img src="${imgPath}/assets/images/img3.jpg" class="bg" />
    <img src="${imgPath}/assets/images/img4.jpg" class="bg" />
    <img src="${imgPath}/assets/images/img5.jpg" class="bg" />
    <img src="${imgPath}/assets/images/img6.jpg" class="bg" />
    <img src="${imgPath}/assets/images/img7.jpg" class="bg" />
    <img src="${imgPath}/assets/images/img8.jpg" class="bg" />
    <img src="${imgPath}/assets/images/img9.jpg" class="bg" />
    <img src="${imgPath}/assets/images/img10.jpg" class="bg" />
    <img src="${imgPath}/assets/images/img11.jpg" class="bg" />
</div>
<a onclick="showMore()" class="arrow"></a>

<%--<script>--%>
    <%--function toOpenAccount() {--%>
        <%--window.location.href=basePath+"openAccount";--%>
    <%--}--%>
<%--</script>--%>

<form name="openaccount" id="openaccount">
    <input type="hidden" id="tradeNo" name="tradeNo" value = "${tradeNo}"/>
    <input type="hidden" id="memberNo" name="memberNo" value = "${memberNo}"/>
</form>

<script>
        var ani = null;
        var scrollTop = 0;
        function showMore() {
            $('#more').removeClass('f-dn');
            $(".arrow").hide();
            var height = $(window).height() / 3;
            scrollTop = $(window).scrollTop() + height;
            ani = setInterval(function () {
                var top = $(window).scrollTop();
                if (top < scrollTop) {
                    top += 5;
                    $(window).scrollTop(top);
                } else {
                    clearInterval(ani);
                }
            }, 1);
        }

    function toOpenAccount(){
        var memberNo = $("#memberNo").val();
        var tradeNo = $("#tradeNo").val();

        $.ajax({
            url: basePath+"toOpenAccount",
            type: "POST",
            data: {"shareId":$("#shareId").val(),"memberNo":$("#memberNo").val()},
            dataType: "json",
            success: function (r) {
                if (r.flag) {
                    var baseUrl = r.puer_open_h5;
                    if(memberNo){
                        baseUrl+="?memberno="+memberNo;
                        if(tradeNo){
                            baseUrl+="&source=m16n"+tradeNo;
                        }else{
                            baseUrl+="&source=m16n";
                        }
                    }else{
                        if(tradeNo){
                            baseUrl+="?source=m16n"+tradeNo;
                        }else{
                            baseUrl+="?source=m16n";
                        }
                    }

                    window.location.href=baseUrl;
                }else{
                    alert(r.msg);
                }

            }
        });
    }
</script>
</body>
</html>