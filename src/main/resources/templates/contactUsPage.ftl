<#include "parts/security.ftl">
<html lang="en">
 <head>
     <meta charset="utf-8"/>
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
     <!-- Bootstrap CSS -->
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/>
     <link rel="shortcut icon" type="image/png" href="/static/img/logo2.png"/>
     <link rel="stylesheet" href="/static/css/style.css"/>
     <link rel="stylesheet" href="/static/css/contactus.css"/>

     <title>Contact us</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#"><img width="50" height="50" src="/static/img/logo2.png" alt="logo"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home/"><i class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/games/"><i class="fas fa-dice-six"></i> Games</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/contactus/"><i class="fas fa-comments"></i> Contact us</a>
            </li>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/card/carduser"><i class="fas fa-shopping-basket"></i> Basket</a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/home"><i class="fas fa-users-cog"></i> Admin panel</a>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/logout"><i class="fas fa-sign-out-alt"></i> Exit</a>
                </li>
            <#else>
                <li class=" float-right nav-item">
                    <a class="nav-link" href="/login"><i class="fas fa-sign-in-alt"></i> Login</a>
                </li>
            </#if>
        </ul>
        <form action="/games/find" method="post" class="form-inline">
            <input class="form-control mr-sm-2" name="name_game" type="search" placeholder="Search game by name" aria-label="Search"/>
            <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
    </div>
</nav>
<div class="container-contact100">
    <div class="wrap-contact100">
        <form action="/contactus/sendcontact" method="post" class="contact100-form validate-form">
				<span id="title_contact" class="contact100-form-title">
					Send Us A Message
				</span>

            <div class="wrap-input100 validate-input" data-validate="Please enter your name">
                <input class="input100" type="text" name="name_client" placeholder="Name"/>
                <span class="focus-input100"></span>
            </div>

            <div class="wrap-input100 validate-input" data-validate = "">
                <input class="input100" type="text" name="soname_client" placeholder="Soname client"/>
                <span class="focus-input100"></span>
            </div>

            <div class="wrap-input100 validate-input" data-validate = "Please enter your email: e@a.x">
                <input class="input100" type="email" name="email_client" placeholder="Email"/>
                <span class="focus-input100"></span>
            </div>

            <div class="wrap-input100 validate-input" data-validate = "Please enter your message">
                <textarea class="input100" name="phone_client" placeholder="Your Message"></textarea>
                <span class="focus-input100"></span>
            </div>

            <div class="container-contact100-form-btn">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />

                <button type="submit" class="contact100-form-btn">
						<span>
							<i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
							Send
						</span>
                </button>
            </div>
        </form>
    </div>
</div>



<div id="dropDownSelect1"></div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/7ddafef627.js" crossorigin="anonymous"></script>
 </body>
</html>