<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/>
    <link rel="shortcut icon" type="image/png" href="/static/img/logo2.png"/>
    <link rel="stylesheet" href="/static/css/style.css"/>
    <title>Admin panel home</title>
</head>
<body class="bg_admin">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#"><img width="50" height="50" src="/static/img/logo2.png" alt="logo"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/admin/home"><i class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/listofgame"><i class="fas fa-list-alt"></i> List of games</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/listofuser"><i class="fas fa-list-alt"></i> List of users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/listcarduser"><i class="fas fa-list-alt"></i> List of card users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/listcheckoutorder"><i class="fas fa-list-alt"></i> List of checkout order</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/listcontactus"><i class="fas fa-list-alt"></i> List of contact us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/home/"><i class="fas fa-sign-out-alt"></i> Back to site</a>
                </li>
        </ul>
    </div>
</nav>
<section class="slider">
    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="/static/img/admin_slide_1.jpg" class="d-block w-100 h-25" style="height:450px !important;" alt="admin_slide_1"/>
                <div class="carousel-caption">
                    <h1 style="font-size:8vw;" class="display-2">Добро пожаловать</h1>
                    <h3 style="font-size:2vw;">на панель администратора</h3>
                </div>
            </div>
            <div class="carousel-item">
                <img src="/static/img/admin_slide_2.jpg" class="d-block w-100" style="height: 450px !important;" alt="admin_slide_2"/>
                <div class="carousel-caption">
                    <h1 style="font-size:8vw;" class="display-2">Тут</h1>
                    <h3 style="font-size:2vw;">вы можете всё</h3>
                </div>
            </div>
            <div class="carousel-item">
                <img src="/static/img/admin_slide_3.jpg" style="height: 450px !important;" class="d-block w-100" alt="admin_slide_3"/>
                <div class="carousel-caption">
                    <h1 style="font-size:6vw;" class="display-2">Создавайте! Творите! Работайте!</h1>
                    <h3 style="font-size:2vw;">Удачи.</h3>
                </div>
            </div>
        </div>
    </div>
 </section>
<section class="admin_function">
    <div class="container">
        <div class="logo_admin_function">
            <h3 id="title_admin" class="text-center">Списки объектов сайта для администратора</h3>
        </div>
        <div class="row" >
            <div class="col-xs-12 col-sm-6 col-md-12 col-lg-4" id="item_link">
                <div class="card" style="width: 16rem;">
                    <img src="/static/img/admin_slide_1.jpg" class="card-img-top" alt="admin_slide_1"/>
                    <div class="card-body">
                        <h5 class="card-title">List of game</h5>
                        <p class="card-text"></p>
                        <a href="/admin/listofgame" class="btn btn-secondary">Go on page</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-12 col-lg-4" id="item_link">
                <div class="card" style="width: 16rem;">
                    <img src="/static/img/admin_slide_1.jpg" class="card-img-top" alt="admin_slide_1"/>
                    <div class="card-body">
                        <h5 class="card-title">List of user</h5>
                        <p class="card-text"></p>
                        <a href="/admin/listofuser" class="btn btn-secondary">Go on page</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-12 col-lg-4" id="item_link">
                <div class="card" style="width: 16rem;">
                    <img src="/static/img/admin_slide_1.jpg" class="card-img-top" alt="admin_slide_1"/>
                    <div class="card-body">
                        <h5 class="card-title">List of feedback</h5>
                        <p class="card-text"></p>
                        <a href="/admin/listoffeedback" class="btn btn-secondary">Go on page</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-12 col-lg-4" id="item_link">
                <div class="card" style="width: 16rem;">
                    <img src="/static/img/admin_slide_2.jpg" class="card-img-top" alt="admin_slide_2"/>
                    <div class="card-body">
                        <h5 class="card-title">List of checkout order</h5>
                        <p class="card-text"></p>
                        <a href="/admin/listcheckoutorder" class="btn btn-secondary">Go on page</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-12 col-lg-4" id="item_link">
                <div class="card" style="width: 16rem;">
                    <img src="/static/img/admin_slide_2.jpg" class="card-img-top" alt="admin_slide_2"/>
                    <div class="card-body">
                        <h5 class="card-title">List of contact us</h5>
                        <p class="card-text"></p>
                        <a href="/admin/listcontactus" class="btn btn-secondary">Go on page</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<footer class="page-footer font-small bg-dark" style="height: 100px;color: white !important;">
    <div class="container">
        <div class="row" style="padding-top: 40px">
            <div class="col">
                <a href="#" class="fb-ic">
                    <i class="fab fa-facebook-f fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
                </a>
            </div>
            <div class="col">
                <a href="#" class="fb-ic">
                    <i class="fab fa-twitter fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
                </a>
            </div>
            <div class="col">
                <a href="#" class="fb-ic">
                    <i class="fab fa-google-plus-g fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
                </a>
            </div>
            <div class="col">
                <a  href="#" class="fb-ic">
                    <i class="fab fa-linkedin-in fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
                </a>
            </div>
            <div class="col">
                <a href="#" class="fb-ic">
                    <i class="fab fa-instagram fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
                </a>
            </div>
            <div class="col">
                <a href="#" class="fb-ic">
                    <i class="fab fa-pinterest fa-lg white-text fa-2x"> </i>
                </a>
            </div>
        </div>
    </div>
</footer>


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