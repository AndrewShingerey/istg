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
            </#if>
        </ul>
        <form action="/games/find" method="post" class="form-inline">
            <input class="form-control mr-sm-2" name="name_game" type="search" placeholder="Search game by name" aria-label="Search"/>
            <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
    </div>
</nav>
<section class="basket_table" style="margin-top: 40px">
    <div class="container float-left">
        <div class="row">
            <div class="col">
                <h4 class="logo_text">Total payable: <i class="fas fa-money-bill-alt"></i> ${summa_products} $</h4>
            </div>
            <div class="col">
                <a id="open_modal" class="btn btn-secondary"> Order now</a>
            </div>
        </div>
    </div>
    <div class="table-responsive">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Photo</th>
                <th scope="col">Name</th>
                <th scope="col">Describe</th>
                <th scope="col">Price</th>
                <th scope="col">Type</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <#list product_user as pr_us>
                <tr id="item">
                    <th>${tableService.getById(pr_us.id_game).id_game}</th>
                    <td>
                        <#if tableService.getById(pr_us.id_game).filename_photo_game??>
                            <img width="50" height="40" style="border-radius: 8px" src="/img/${tableService.getById(pr_us.id_game).filename_photo_game}" alt="game_photo"/>
                    <#else>
                       <img width="50" height="40" style="border-radius: 8px" src="/static/img/default_image_game.png" alt="game_photo"/>

                        </#if>
                    </td>
                    <td>${tableService.getById(pr_us.id_game).name_game}</td>
                    <td>${tableService.getById(pr_us.id_game).describe_game}</td>
                    <td>${tableService.getById(pr_us.id_game).price}</td>
                    <td>${Type.apply(tableService.getById(pr_us.id_game).type_id)}</td>
                    <th><a class="btn btn-secondary" href="/card/deletecard/${tableService.getById(pr_us.id_game).id_game}">Delete</a></th>

                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</section>

<div id="modal" class="modal bounceIn">
    <div id="close_modal">+</div>
    <div class="modal_txt">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="modal_txt">
                        <div>
                            <h2>Order now</h2>
                        </div>
                        <form action="/card/orderCard" method="post" onsubmit="return confirmOrder()" class="form_add_train_new">
                            <div class="form-group">
                                <label for="exampleInputText">Name client</label>
                                <input name="name_client" type="text" class="form-control" id="exampleInputText" placeholder="Enter name" required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputText">Soname client</label>
                                <input name="soname_client" type="text" class="form-control" id="exampleInputText" placeholder="Enter soname" required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputText">Email client</label>
                                <input name="email_client" type="email" class="form-control" id="exampleInputText" placeholder="Enter email" required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputText">Phone client</label>
                                <input name="phone_client" type="text" class="form-control" id="exampleInputText" placeholder="Enter phone +357(code)1311231" required="required"/>
                            </div>
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/7ddafef627.js" crossorigin="anonymous"></script>
<script src="/static/js/main.js"></script>
<script>
    init_modal_open_close_btn_order();
</script>
</body>
</html>