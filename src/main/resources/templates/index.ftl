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
                <a id="home" class="nav-link" href="/home/"><i class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
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
<section class="slider">
    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="/static/img/home_slide_1.jpg" class="d-block w-100" alt="admin_slide_1"/>
                <div class="carousel-caption">
                    <h1 style="font-size:7.3vw;" class="display-2">lorem inpsum lorem</h1>
                    <h3 style="font-size:2vw;">lorem</h3>
                </div>
            </div>
            <div class="carousel-item">
                <img src="/static/img/home_slide_2.jpg" class="d-block w-100" alt="admin_slide_2"/>
                <div class="carousel-caption">
                    <h1 style="font-size:8vw;" class="display-2">lorem inpsum lorem</h1>
                    <h3 style="font-size:2vw;">lorem</h3>
                </div>
            </div>
            <div class="carousel-item">
                <img src="/static/img/home_slide_3.jpg" class="d-block w-100" alt="admin_slide_3"/>
                <div class="carousel-caption">
                    <h1 style="font-size:6vw;" class="display-2">lorem inpsum lorem</h1>
                    <h3 style="font-size:2vw;">lorem</h3>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="about_us" style="max-height: 400px;">
    <div class="container">
        <div class="logo_text">
            <p>About us</p>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-12 col-lg-6">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="/static/img/aboutus_slide_1.jpg" height="450px" class="d-block w-100" alt="..."/>
                        </div>
                        <div class="carousel-item">
                            <img src="/static/img/aboutus_slide_2.jpg" height="450px" class="d-block w-100" alt="..."/>
                        </div>
                        <div class="carousel-item">
                            <img src="/static/img/aboutus_slide_3.jpg" height="450px" class="d-block w-100" alt="..."/>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-12 col-lg-6">
                <h3>Our team works for you</h3>
                <h5 style="color: #757575">
                    We are a unique online store of board games. </h5>
                <p> Only here you can buy any board games to your taste.
                    Looking for a gift or finding a way to have a good evening?
                    Then you've come to the right site!simply dummy text of the printing and typesetting industry.
                    Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
                    when an unknown printer took a galley of type and scrambled it to make a type specimen book. </p>
            </div>
        </div>
    </div>
</section>
<section class="example_game pt-5 pb-5">
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h3 class="logo_text mb-3">Several our games</h3>
                </div>
                <div class="col-6 text-right">
                    <a class="btn btn-secondary mb-3 mr-1" href="#carouselExampleIndicators2" role="button" data-slide="prev">
                        <i class="fa fa-arrow-left"></i>
                    </a>
                    <a class="btn btn-secondary mb-3 " href="#carouselExampleIndicators2" role="button" data-slide="next">
                        <i class="fa fa-arrow-right"></i>
                    </a>
                </div>
                <div class="col-12">
                    <div id="carouselExampleIndicators2" class="carousel slide" data-ride="carousel">

                        <div class="carousel-inner" style="max-height: 100% !important;">
                            <div class="carousel-item active">
                                <div id="game_active" class="row">
                                    <#list ListGameActive as game>
                                        <div  class="col-md-4 mb-3">
                                            <div class="card">
                                                <#if game.filename_photo_game??>
                                                 <img class="img-fluid" alt="100%x280" src="/img/${game.filename_photo_game}">
                                                 <#else>
                                                 <img class="img-fluid" alt="100%x280" src="/static/img/default_image_game.png">
                                                </#if>
                                                <div class="card-body">
                                                    <a href="/card/onegame/${game.id_game}"><h4 class="card-title">${game.name_game}</h4></a>
                                                    <p class="card-text">
                                                        ${game.describe_game}
                                                        ${game.describe_game}
                                                    <h5><p><i class="fas fa-dice-six"></i> Type: ${Type.apply(game.type_id)}</p></h5>
                                                    <h5><p><i class="fas fa-money-bill-alt"></i> ${game.price}$</p></h5>
                                                    <a href="/" class="btn btn-secondary">Go <so></so>mewhere</a>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div id="game_row1" class="row">
                                    <#list ListGamerow1 as game>
                                        <div  class="col-md-4 mb-3">
                                            <div class="card">
                                                <#if game.filename_photo_game??>
                                                    <img class="img-fluid" alt="100%x280" src="/img/${game.filename_photo_game}">
                                                <#else>
                                                    <img class="img-fluid" alt="100%x280" src="/static/img/default_image_game.png">
                                                </#if>
                                                <div class="card-body">
                                                    <a href="/card/onegame/${game.id_game}"><h4 class="card-title">${game.name_game}</h4></a>
                                                    <p class="card-text">
                                                        ${game.describe_game}
                                                        ${game.describe_game}
                                                        <h5><p><i class="fas fa-dice-six"></i> Type: ${Type.apply(game.type_id)}</p></h5>
                                                    <h5><p><i class="fas fa-money-bill-alt"></i> ${game.price}$</p></h5>
                                                    <a href="/" class="btn btn-secondary">Go somewhere</a>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div id="game_row2" class="row">
                                    <#list ListGamerow2 as game>
                                        <div  class="col-md-4 mb-3">
                                            <div class="card">
                                                <#if game.filename_photo_game??>
                                                    <img class="img-fluid" alt="100%x280" src="/img/${game.filename_photo_game}">
                                                <#else>
                                                    <img class="img-fluid" alt="100%x280" src="/static/img/default_image_game.png">
                                                </#if>
                                                <div class="card-body">
                                                    <a href="/card/onegame/${game.id_game}"><h4 class="card-title">${game.name_game}</h4></a>
                                                    <p class="card-text">
                                                        ${game.describe_game}
                                                        ${game.describe_game}
                                                        <h5><p><i class="fas fa-dice-six"></i> Type: ${Type.apply(game.type_id)}</p></h5>
                                                    <h5><p><i class="fas fa-money-bill-alt"></i> ${game.price}$</p></h5>
                                                    <a href="/" class="btn btn-secondary">Go somewhere</a>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</section>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/7ddafef627.js" crossorigin="anonymous"></script>
<script>
    $('.carousel').carousel({
        interval: 2000
    })
</script>
</body>
</html>