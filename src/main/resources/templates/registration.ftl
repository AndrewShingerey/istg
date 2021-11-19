<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <link rel="shortcut icon" type="image/png" href="/static/img/logo2.png"/>
    <link rel="stylesheet" href="/static/css/login.css"/>
    <title>Registration</title></head>
<body>
<form method="post" action="/registration/addnewuser" id="login-form" class="login-form" autocomplete="off" role="main">
    <h3 style="text-align: center" id="regForm">Registration Form</h3>
    <div>
        <label class="label-email">
            <input placeholder="Username" type="text" name="username"/>
             <span class="required">Username</span>
        </label>
    </div>
    <div>
        <label class="label-email">
            <input placeholder="Name" type="text" name="name_user"/>
            <span class="required">Name</span>
        </label>
    </div>
    <div>
        <label class="label-email">
            <input placeholder="Soname" type="text" name="soname_user"/>
            <span class="required">Soname</span>
        </label>
    </div>
    <div>
        <label class="label-email">
            <input placeholder="Email" type="email" name="email"/>
            <span class="required">Email</span>
        </label>
    </div>
    <input type="checkbox" name="show-password" class="show-password a11y-hidden" id="show-password" tabindex="3" />
    <label class="label-show-password" for="show-password">
        <span>Show Password</span>
    </label>
    <div>
        <label class="label-password">
            <input maxlength="22" minlength="8" type="text" class="text" name="password" placeholder="Password" tabindex="2" required="required" />
            <span class="required">Password</span>
        </label>
    </div>
    <input type="submit" value="Registration" />
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
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