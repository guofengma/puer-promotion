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

</head>
<body>

<audio id="bg_audio">
    <source src="${imgPath}/assets/audio/background.mp3"/>
    您的浏览器不支持 HTML5 audio 标签。
</audio>
<button onclick="playPause()">播放/暂停</button>
<script>
    var bgAudio = document.getElementById("bg_audio");

    function playPause() {
        if (bgAudio.paused)
            bgAudio.play();
        else
            bgAudio.pause();
    }
</script>

<div class="section">
    <img src="${imgPath}/assets/images/img0.jpg" class="bg" />
</div>
<div class="section f-pr">
    <img src="${imgPath}/assets/images/img1.jpg" class="bg" />

    <div class="tip-box"  id="versioninfo" style="display: none;">
        <h2> 应用版本较低，请升到最新版本参与活动！</h2>
        <p> <img src="${imgPath}/assets/images/lowTips.png" width="66.7%"/></p>
        <p><a class="mt-35 update-button" href="${applicationScope['systemPuerAppDownloadPage']}"></a></p>
    </div>

    <div id="shareurlbutton" class="share-url" style="display: none;">
        <p><img src="${imgPath}/assets/images/shareurl.png" width="66.7%"/></p>
        <p><a class="mt-35 nowshare-button"></a></p>
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
<a id="trigger" style="height: 0;width: 0;opacity: 0;"></a>
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

    var account="",user_agent = "", version = "", share_id =""; //分享的ID
    var customerName = '大圆君';
        $( document ).ready(function(){

            if(window.jmeapp ) { // android
                account = window.jmeapp.getPuerAccount();
                user_agent = window.jmeapp.userAgent();
                version = window.jmeapp.version();

            } else if(window.getPuerAccount){ // iOS
                getPuerAccount();getVersion();getUserAgent();
            }
            if(true || user_agent!="") { // app环境下
                var m = version.match(/(?:(\d+)\.)?(?:(\d+)\.)?(\*|\d+)/) || new Array();
                var main_version = parseInt(m[1] || 0),
                        release = parseInt(m[2] || 0),
                        modify = parseInt(m[3] || 0);
                if(main_version < 3 || release < 2 || modify < 1) { // 版本不小于3.2.1


                    $("#versioninfo").show();
                    $("#pe_account").hide();
                    $("#account_info").hide();
                    $("#trigger").hide();

                }
                if(account!=null && account!="" ){ $("#account").val(account);}
            }

        });

    function closeTips(){
        $("#maskDiv").hide();
        $(".error").hide();
    }

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
//                    $("#maskDiv").show();
//                    $(".tip-share").hide();
                    $("#shareurlbutton").show();
                    $("#pe_account").hide();
                    $("#account_info").hide();
                    share_id = r.result.msg;
                    if(r.result.data){
                        if(r.result.data){
                            customerName = checkFuXing(r.result.data.toString())+"先生/女士 ";
                        }
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
    $("#shareurlbutton").on("click",function(){
        if(window.jmeapp) {
            window.jmeapp.umengShare("${applicationScope['weixinDefaultShareTitle']}", customerName+"携手大圆普洱，赠您新股藏品，邀您增值财富", "${imgPath}${applicationScope['weixinDefaultShareIcon']}", basePath+"openAccount?memberNo="+"${memberNo}"+"&shareId="+share_id);
        } else {
            umengShare("${applicationScope['weixinDefaultShareTitle']}", customerName+"携手大圆普洱，赠您新股藏品，邀您增值财富", "${imgPath}${applicationScope['weixinDefaultShareIcon']}", basePath+"openAccount?memberNo="+"${memberNo}"+"&shareId="+share_id);
        }
    });
    function setPuerID(puerid){
        account = puerid;
    }
    function setVersion(ver){
        version = ver;
    }
    function setUserAgent(agent){
        user_agent = agent;
    }

</script>
</body>
</html>
