<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/>
    <link rel="shortcut icon" type="image/png" href="/static/img/logo2.png"/>
    <link rel="stylesheet" href="/static/css/style.css"/>
    <title>Admin panel list of contact us</title>
</head>
<body class="bg_admin" style="height: 100%;">
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
<section class="table_games" style="">
    <div class="logo_list_of_game">
        <h3 id="title_admin" class="text-center">List of all checkout order</h3>
    </div>

    <div class="table-responsive">
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">id order</th>
                        <th scope="col">id card</th>
                        <th scope="col">Name client</th>
                        <th scope="col">Soname client</th>
                        <th scope="col">Email client</th>
                        <th scope="col">Phone client</th>
                        <th scope="col">Date order</th>
                        <th scope="col">Delete</th>
                    </tr>
                </thead>
                <tbody>
                <#list listOrder as or>
                    <tr id="item" style="color:#fff;">
                        <td>${or.getId_c_or()}</td>
                        <td>${or.getId_card_pr()}</td>
                        <td>${or.getName_client()}</td>
                        <td>${or.getSoname_client()}</td>
                        <td>${or.getEmail_client()}</td>
                        <td>${or.getPhone_client()}</td>
                        <td>${or.getDate_order()}</td>
                        <td><a onclick="confirmDelete()" class="btn btn-secondary" href="/listcheckoutorder/delete/${or.getId_c_or()}">Delete</a></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</section>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/7ddafef627.js" crossorigin="anonymous"></script>
<script src="/static/js/main.js"></script>
</body>
</html>