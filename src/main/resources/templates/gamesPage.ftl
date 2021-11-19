<#include "parts/security.ftl">
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/>
    <link rel="shortcut icon" type="image/png" href="/static/img/logo2.png"/>
    <link rel="stylesheet" href="/static/css/style.css"/>
    <title>Home</title>
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
<section>
<div class="container my-3">
    <div class="logo_text">
        <p id="text_logo">Games</p>
    </div>
    <div id="itemContainer" class="row">
        <#list ListGame as game>
            <div id="card_item" class="col-xs-12 col-sm-6 col-md-12 col-lg-4">
                <div class="card" style="width: 16rem;margin-bottom: 40px;">
                    <#if game.filename_photo_game??>
                    <img class="card-img-top" height="200px" src="/img/${game.filename_photo_game}" alt="Card image cap"/>
                    <#else>
                    <img class="card-img-top" height="200px" src="/static/img/default_image_game.png" alt="Card image cap"/>
                    </#if>
                    <div class="card-body">
                        <a href="/card/onegame/${game.id_game}"><h5 class="card-title">${game.name_game}</h5></a>
                        <p class="card-text">
                        ${game.describe_game}
                        </p>
                        <h5><p><i class="fas fa-dice-six"></i> Type: ${Type.apply(game.type_id)}</p></h5>
                        <h5><p><i class="fas fa-money-bill-alt"></i> ${game.price}$</p></h5>
                        <a href="/card/addtocard/${game.id_game}" class="btn btn-secondary">Add to card</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>
    <div class="holder">
    </div>
</div>
</section>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/7ddafef627.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com /ui/1.12.1/jquery-ui.js"></script>
<script src="/static/js/JPanel.min.js"></script>
<script src="/static/js/main.js"></script>
</body>
</html>