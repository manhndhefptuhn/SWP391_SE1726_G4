<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : changePass
    Created on : 28-05-2023, 12:29:23
    Author     : Zarius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Change password</title>
        <link rel="icon" type="image/png" href="<%= request.getContextPath()%>/img/shop/logo1.png"/>
        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style1.css">
    </head>
    <body>
        <%String notification = (String)request.getAttribute("notification");%>
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="<%= request.getContextPath()%>/img/signin-image.jpg" alt="change pass image"></figure>
                            <c:if test="${sessionScope.user != null}">
                            <div class="create-acc">
                                <a href="userProfile.jsp" class="signup-image-link">Back to your profile</a>
                            </div>
                        </c:if>
                    </div>
                    <div class="signin-form">
                        <h2 class="form-title">Change password</h2>
                        <form action="changePass" method="POST" class="register-form" id="login-form">
                            <div>
                                <c:choose>
                                    <c:when test="${sessionScope.user != null}">
                                        <!-- Change pass in user profile -->
                                        <div class="form-group">
                                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                            <input type="password" name="oldPassLogin" id="old-Pass" placeholder="Old password" required/>
                                        </div>
                                        <div class="form-group">
                                            <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                            <input type="password" name="newPass" id="your-pass" placeholder="New password" required/>
                                        </div>
                                        <div class="form-group">
                                            <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                            <input type="password" name="reNewPass" id="your-pass2" placeholder="Re-enter password" required/>
                                        </div>
                                        <div>
                                            <input type="checkbox" id="reveal-checkbox" class="agree-term" onclick="revealPassword()"/>
                                            <label for="reveal-checkbox" class="label-agree-term" ><span><span></span></span>Reveal Password</label>                       
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <!-- Change pass when login with new password -->
                                        <input type="hidden" name="userChangeID" value="${userChangeID}">
                                        <div class="form-group">
                                            <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                            <input type="password" name="newPass" id="your-pass" placeholder="New password" required/>
                                        </div>
                                        <div class="form-group">
                                            <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                            <input type="password" name="reNewPass" id="your-pass2" placeholder="Re-enter password" required/>
                                        </div>
                                        <div>
                                            <input type="checkbox" id="reveal-checkbox" class="agree-term" onclick="revealPassword1()"/>
                                            <label for="reveal-checkbox" class="label-agree-term" ><span><span></span></span>Reveal Password</label>                       
                                        </div>
                                    </c:otherwise>
                                </c:choose>

                                <c:if test="${notification != null}">
                                    <strong style="color:red;">${notification}</strong>
                                </c:if>
                                <div class="form-group form-button">
                                    <input style="width:100%;" type="submit" name="changePass" id="changePass" class="form-submit" value="Change your password"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <!-- JS -->
        <script src="<%= request.getContextPath()%>/jquery/jquery.min.js"></script>
        <script src="<%= request.getContextPath()%>/js/main1.js"></script>

    </body>
</html>
