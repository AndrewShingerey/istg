<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/>
    <link rel="shortcut icon" type="image/png" href="/static/img/logo2.png"/>
    <link rel="stylesheet" href="/static/css/style.css"/>
    <title>Admin panel list of feedback</title>
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
                <a class="nav-link" href="/admin/listoffeedback"><i class="fas fa-list-alt"></i> List of feedback</a>
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
        <h3 id="title_admin" class="text-center">List of all feedback</h3>
    </div>

    <div class="table-responsive">
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">id feedback</th>
                    <th scope="col">id game</th>
                    <th scope="col">Name client</th>
                    <th scope="col">Soname client</th>
                    <th scope="col">Email client</th>
                    <th scope="col">Mark</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <#list listFd as fd>
                <tr id="item" style="color:#fff;">
                    <td>${fd.getId_feedback()}</td>
                    <td>${fd.getId_tb_game()}</td>
                    <td>${fd.getName_client()}</td>
                    <td>${fd.getSoname_client()}</td>
                    <td>${fd.getEmail_client()}</td>
                    <td>${fd.getMark()}</td>
                    <td><a onclick="confirmDelete()" class="btn btn-secondary" href="/admin/listoffeedback/delete/${fd.getId_feedback()}">Delete</a></td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</section>

<div id="modal_edit" class="modal bounceIn">
    <div id="close_edit_modal">+</div>
    <div class="modal_txt">
        <div>
            <h2>Edit feedback with name - <span id="name_user_edit_logo"></span></h2>
        </div>
        <div class="add_train_content">
            <form action ="" method="post" onsubmit="return confirmEdit()" name="form_edit_game">
                <div class="form-group">
                    <label for="exampleInputText">Username</label>
                    <input name="username_user_edit" type="text" class="form-control" id="exampleInputText" placeholder="Enter name game" required="required"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputText">Name</label>
                    <input name="name_user_edit" type="text" class="form-control" id="exampleInputText" placeholder="Enter name game" required="required"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputText">Soname</label>
                    <input name="soname_user_edit" type="text" class="form-control" id="exampleInputText" placeholder="Enter name game" required="required"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputText">Email game</label>
                    <input name="email_user_edit" type="text" class="form-control" id="exampleInputText" placeholder="Enter name game" required="required"/>
                </div>
                <div class="form-group">
                    <label for="exampleSelectType">Role now: <span id="role_user"></span></label>
                    <select name="role" id="exampleSelectType" class="custom-select custom-select-lg mb-3" style="font-size: 1rem !important;">
                        <option value="ADMIN">Admin</option>
                        <option value="USER">User</option>
                    </select>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/7ddafef627.js" crossorigin="anonymous"></script>
<script src="/static/js/main.js"></script>
<script>
    init_edit_modal_user();
</script>
</body>
</html>