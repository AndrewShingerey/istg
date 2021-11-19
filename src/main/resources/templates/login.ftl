<html>
<head>
    <title>Login page</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="shortcut icon" type="image/png" href="/static/img/logo2.png"/>
    <link rel="stylesheet" href="/static/css/login.css">

    <title>Home</title>
</head>
<body>
<#if message??>
    <p>sss${message}</p>
</#if>
<form default-target-url method="post" action="/login" id="login-form" class="login-form" autocomplete="off" role="main">
    <h1 class="a11y-hidden">Login Form</h1>
    <div>
        <label class="label-email">
            <input type="text" class="text" name="username" placeholder="Username" tabindex="1" required minlength="4" maxlength="20"/>
            <span class="required">Username</span>
        </label>
    </div>
    <input type="checkbox" name="show-password" class="show-password a11y-hidden" id="show-password" tabindex="3"/>
    <label class="label-show-password" for="show-password">
        <span>Show Password</span>
    </label>
    <div>
        <label class="label-password">
            <input type="text" class="text" name="password" placeholder="Password" tabindex="2" required minlength="8" maxlength="21"/>
            <span class="required">Password</span>
        </label>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit" value="Log In" />
    <div class="email">
        <a href="/registration/">Registration</a>
    </div>
    <figure aria-hidden="true">
        <div class="person-body"></div>
        <div class="neck skin"></div>
        <div class="head skin">
            <div class="eyes"></div>
            <div class="mouth"></div>
        </div>
        <div class="hair"></div>
        <div class="ears"></div>
        <div class="shirt-1"></div>
        <div class="shirt-2"></div>
    </figure>
</form>
  </body>
</html>

