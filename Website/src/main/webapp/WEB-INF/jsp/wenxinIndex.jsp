<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script>
        var basePath = '<%=basePath%>';
    </script>

    <c:if test="${userAgent == 'MicroMessenger'}">
        <jsp:include page="include/weixinShareConfig.jsp"/>

        <script>
            wx.ready(function(){
                //分享到朋友圈
                wx.onMenuShareTimeline({
                    title:  '${applicationScope['weixinDefaultShareTitle']}', // 分享标题
                    link: '<%=basePath%>index',
                    imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}', // 分享图标
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
                    desc: '${applicationScope['weixinDefaultShareDesc']}', // 分享描述
                    link:  '<%=basePath%>index',
                    imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}', // 分享图标
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
                    desc: '${applicationScope['weixinDefaultShareDesc']}', // 分享描述
                    link: '<%=basePath%>index', // 分享链接
                    imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}', // 分享图标
                    success: function () {
                        // 用户确认分享后执行的回调函数
                    },
                    cancel: function () {
                        // 用户取消分享后执行的回调函数
                    }
                });

                wx.onMenuShareWeibo({
                    title: '${applicationScope['weixinDefaultShareTitle']}', // 分享标题
                    desc: '${applicationScope['weixinDefaultShareDesc']}', // 分享描述
                    link: '<%=basePath%>index', // 分享链接
                    imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}', // 分享图标
                    success: function () {
                        // 用户确认分享后执行的回调函数
                    },
                    cancel: function () {
                        // 用户取消分享后执行的回调函数
                    }
                });

                wx.onMenuShareQZone({
                    title: '${applicationScope['weixinDefaultShareTitle']}', // 分享标题
                    desc: '${applicationScope['weixinDefaultShareDesc']}', // 分享描述
                    link: '<%=basePath%>index', // 分享链接
                    imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}', // 分享图标
                    success: function () {
                        // 用户确认分享后执行的回调函数
                    },
                    cancel: function () {
                        // 用户取消分享后执行的回调函数
                    }
                });
            });

            var userAgent = "MicroMessenger";

        </script>
    </c:if>
</head>
<body>
<div class="audio-wrap audio-ani" onclick="playPause()" id="bg_audio_btn">
    <div class="audio-box"></div>
</div>

<audio id="bg_audio" autoplay="autoplay">
    <source src="${imgPath}/assets/audio/background.mp3"/>
    您的浏览器不支持 HTML5 audio 标签。
</audio>
<script>
    var bgAudio = document.getElementById("bg_audio");

    function playPause() {
        if (bgAudio.paused){
            bgAudio.play();
            if(bgAudio.played) {
                $("#bg_audio_btn").addClass("audio-ani");
                alert($("#bg_audio_btn").attr("class"));
            }
        }
        else{
            bgAudio.pause();
            if(bgAudio.paused) {
                $("#bg_audio_btn").removeClass("audio-ani");
                alert($("#bg_audio_btn").attr("class"));
            }
        }
    }
</script>



<div class="section">
    <img src="${imgPath}/assets/images/img0.jpg" class="bg" />
</div>
<div class="section f-pr">
    <img src="${imgPath}/assets/images/img1.jpg" class="bg" />

    <div id="downloadRsource" class="qrCode" style="display: none;">
        <h2>请下载APP，或关注微信公众号，参与活动！</h2>
        <div class="qr-module">
        <p><img src="${imgPath}/assets/images/code1.png"/></p>
        <p>大圆银泰掌上交易端</p>
        <p><a href="${applicationScope['systemPuerAppDownloadPage']}">点击立即下载 ></a></p>
        </div>
        <div class="qr-module">
        <img src="${imgPath}/assets/images/code2.png"/>
        <p>扫描二维码或微信搜索</p>
        <p>dytjme 并关注 ></p>
        </div>
    </div>

    <div id="shareurlbutton" class="share-url" style="display: none;">
        <p><img src="${imgPath}/assets/images/shareurl.png" width="66.7%"/></p>
        <p><a class="mt-35 nowshare-button" onclick="(function(){$('#maskDiv').show();})()"></a></p>
    </div>

    <div id="pe_account" class="pe-account">
        <img src="${imgPath}/assets/images/account.png" />
    </div>
    <div id="account_info" class="btn">
        <input id="account" name="account" maxlength="16" type="text" value="">
        <a class="mt-35 btn-share" onclick="submitShareForm();"></a>
        <a class="mt-35 btn-newuser" onclick="toOpenAccount();"></a>
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

<!-- 遮罩状态 start-->
<div id="maskDiv" class="tip" style="display:none;">
    <div class="tip-share" style="display:none;">
        <img src="${imgPath}/assets/images/share.png" />
    </div>
    <div class="f-share"></div>
</div>
<!-- 遮罩状态 end-->
<div class="error" style="display:none;">
    <div>
        <p class="pic"><img src="${imgPath}/assets/images/error_ico.png"></p>
        <p id="errorText"></p>
    </div>
    <div class="btn"><a onclick="closeTips();">确定</a></div>
</div>

<script src="${imgPath}/assets/js/checkinfo.js?v=${imgVersion}"></script>
<script>

    $(function(){
        if(!isWeixin()) {
            $("#pe_account").hide();
            $("#account_info").hide();
            $("#account").hide();
            $("#downloadRsource").show();
        }
    })

    var ani = null;
    var scrollTop = 0;
    function showMore(){
        $('#more').removeClass('f-dn');
        $(".arrow").hide();
        var height = $(window).height()/3;
        scrollTop = $(window).scrollTop()+height;
        ani = setInterval(function(){
            var top = $(window).scrollTop();
            if(top<scrollTop)
            {
                top+=5;
                $(window).scrollTop(top);
            }else{
                clearInterval(ani);
            }
        },1);
    }

    var generatedShareUrl = "";


    function submitShareForm() {

        if ($("#account").val() == "") {
            $("#errorText").html("请输入交易账号!");
            $("#maskDiv").show();
            $(".error").show();
            return false;
        }

        var reg = new RegExp("^[0-9]*$");
        var obj = $("#account").val();
        if(!reg.test(obj)){
            $("#errorText").html("请输入数字!");
            $("#maskDiv").show();
            $(".error").show();
            return false;
        }

        $.ajax({
            url: basePath+"account/generateShareUrl",
            type: "POST",
            data: {"account":$("#account").val()},
            dataType: "json",
            success: function (r) {
                if (r.result.code == 2000) {
                    $("#maskDiv").show();
                    $(".tip-share").show();
                    $("#shareurlbutton").show();
                    $("#pe_account").hide();
                    $("#account_info").hide();

                    generatedShareUrl = basePath+"openAccount?shareId="+r.result.msg;
                    window.shareUrl = basePath+"openAccount?shareId="+r.result.msg;
                    console.debug("window.shareUrl:", window.shareUrl);
                    var customerName = '';
                    if(r.result.data){
                        customerName =checkFuXing(r.result.data.toString())+"先生/女士 ";
                    }else{
                        customerName='大圆君';
                    }
                    //分享给朋友
                    if(isWeixin()){
                        wx.onMenuShareAppMessage({
                            title:'${applicationScope['weixinDefaultShareTitle']}', // 分享标题
                            desc:customerName+"携手大圆普洱，赠您新股藏品，邀您增值财富", // 分享描述
                            link: window.shareUrl,
                            imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}?v=${applicationScope['imgVersion']}', // 分享图标
                            type: 'link', // 分享类型,music、video或link，不填默认为link
                            dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
                            success: function () {
                                // 用户确认分享后执行的回调函数
                                successShare();
                            },
                            cancel: function () {
                                // 用户取消分享后执行的回调函数
                                closeShare();
                            }
                        });
                        //分享到朋友圈
                        wx.onMenuShareTimeline({
                            title: customerName+"携手大圆普洱，赠您新股藏品，邀您增值财富", // 分享标题
                            link: window.shareUrl,
                            imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}?v=${applicationScope['imgVersion']}', // 分享图标
                            success: function () {
                                // 用户确认分享后执行的回调函数
                                successShare();
                            },
                            cancel: function () {
                                // 用户取消分享后执行的回调函数
                                closeShare();
                            }
                        });

                        wx.onMenuShareQQ({
                            title: '${applicationScope['weixinDefaultShareTitle']}', // 分享标题
                            desc: customerName+"携手大圆普洱，赠您新股藏品，邀您增值财富", // 分享描述
                            link: window.shareUrl,
                            imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}?v=${applicationScope['imgVersion']}', // 分享图标
                            success: function () {
                                // 用户确认分享后执行的回调函数
                                successShare();
                            },
                            cancel: function () {
                                // 用户取消分享后执行的回调函数
                                closeShare();
                            }
                        });

                        wx.onMenuShareWeibo({
                            title:  '${applicationScope['weixinDefaultShareTitle']}', // 分享标题
                            desc: customerName+"携手大圆普洱，赠您新股藏品，邀您增值财富", // 分享描述
                            link: window.shareUrl,
                            imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}?v=${applicationScope['imgVersion']}', // 分享图标
                            success: function () {
                                // 用户确认分享后执行的回调函数
                                successShare();
                            },
                            cancel: function () {
                                // 用户取消分享后执行的回调函数
                                closeShare();
                            }
                        });

                        wx.onMenuShareQZone({
                            title: '${applicationScope['weixinDefaultShareTitle']}', // 分享标题
                            desc: customerName+"携手大圆普洱，赠您新股藏品，邀您增值财富", // 分享描述
                            link:  window.shareUrl,
                            imgUrl: '${imgPath}${applicationScope['weixinDefaultShareIcon']}?v=${applicationScope['imgVersion']}', // 分享图标
                            success: function () {
                                // 用户确认分享后执行的回调函数
                                successShare();
                            },
                            cancel: function () {
                                // 用户取消分享后执行的回调函数
                                closeShare();
                            }
                        });
                    }
                }
                if (r.result.code == 1000) {
                    $("#errorText").html(r.result.msg);
                    $("#maskDiv").show();
                    $(".error").show();
                }

            }
        });
    }

    function toOpenAccount() {
        window.location.href=basePath+"openAccount?memberNo="+'${memberNo}'+"&flag=1";
    }

    function closeTips(){
        $("#maskDiv").hide();
        $(".error").hide();
    }

    //分享成功
    function successShare() {
        $("#maskDiv").css("display","none");
    }

    //取消分享
    function closeShare(){
        $("#maskDiv").css("display","none");
    }

    /*判断是不是微信浏览器*/
    function isWeixin(){
        var ua = navigator.userAgent.toLowerCase();
        if(ua.match(/MicroMessenger/i)=="micromessenger") {
            return true;
        } else {
            return false;
        }
    }


</script>
</body>
</html>
