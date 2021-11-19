<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/>
    <link rel="shortcut icon" type="image/png" href="/static/img/logo2.png"/>
    <link rel="stylesheet" href="/static/css/style.css"/>
    <title>Admin panel list of game</title>
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
        <h3 id="text_page" class="text-center">List of all games</h3>
    </div>

    <div class="table-responsive">
        <div class="container">
            <a id="open_modal" style="margin-bottom: 20px" href="#" class="btn btn-secondary">Add new game</a>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">id_game</th>
                    <th scope="col">Name</th>
                    <th scope="col">Describe</th>
                    <th scope="col">Filename</th>
                    <th scope="col">Price</th>
                    <th scope="col">Type</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <#list ListGame as game>
                    <tr id="item" style="color:#fff;">
                        <td><a href="${game.getId_game()}"></a>${game.getId_game()}</td>
                        <td>${game.getName_game()}</td>
                        <td>${game.getDescribe_game()}</td>
                        <td><#if game.getFilename_photo_game()??>${game.getFilename_photo_game()}<#else>None</#if></td>
                        <td>${game.getPrice()}</td>
                        <td>${Type.apply(game.type_id)}</td>
                        <td><a data-name_game="${game.getName_game()}"
                               data-id_game="${game.getId_game()}"
                               data-describe_game="${game.getDescribe_game()}"
                               data-filename_photo="<#if game.getFilename_photo_game()??>
                               ${game.getFilename_photo_game()}<#else>None</#if>"
                               data-price_game="${game.getPrice()}"
                               data-type_id="${game.getType_id()}"
                               id="open_modal_edit" class="btn btn-secondary" >Edit</a></td>
                        <td><a onclick="return confirmDelete()" class="btn btn-secondary" href="/admin/delete/${game.getId_game()}">Delete</a></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
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
                            <h2>Add new game</h2>
                        </div>
                        <form action="/admin/listofgame/addgame" method="post" enctype="multipart/form-data" onsubmit="return add_new_game()" class="form_add_train_new">
                            <div class="form-group">
                                <label for="exampleInputText">Name game</label>
                                <input name="name_game" type="text" class="form-control" id="exampleInputText" placeholder="Enter name game" required="required" minlength="8" maxlength="40"/>
                             </div>
                            <div class="form-group">
                                <label for="exampleInputText">Describe game</label>
                                <textarea name="describe_game" type="text" class="form-control" id="exampleInputText" placeholder="Enter describe game" minlength="20" maxlength="250" required="required"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="exampleSelectType">Type game</label>
                                <select name="type_id" id="exampleSelectType" class="custom-select custom-select-lg mb-3" style="font-size: 1rem !important;">
                                    <option value="1">Adventure</option>
                                    <option value="2">Action</option>
                                    <option value="3">Intelegent</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPrice1">Price game</label>
                                <input name="price" type="text" class="form-control" id="exampleInputPrice1"  placeholder="Enter name game" required="required"/>
                            </div>
                            <div class="form-group">
                                <div class="custom-file">
                                    <input type="file" name="file" class="custom-file-input" id="inputGroupFile01"
                                           aria-describedby="inputGroupFileAddon01"/>
                                    <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                                </div>
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


<div id="modal_edit" class="modal bounceIn">
    <div id="close_edit_modal">+</div>
    <div class="modal_txt">
        <div>
            <h2>Edit game name - <span id="name_game_edit_logo"></span></h2>
        </div>
        <div class="add_train_content">
            <form action ="" method="post" enctype="multipart/form-data" onsubmit="return confirmEdit()" name="form_edit_game">
                <div class="form-group">
                    <label for="exampleInputText">Name game</label>
                    <input name="name_game_edit" type="text" class="form-control" id="exampleInputText" placeholder="Enter name game" required="required"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputText">Describe game</label>
                    <textarea name="describe_game_edit" type="text" class="form-control" id="exampleInputText" placeholder="Enter describe game" required="required"></textarea>
                </div>
                <div class="form-group">
                    <label for="exampleSelectType">Type game</label>
                    <select name="type_id_edit" id="exampleSelectType" class="custom-select custom-select-lg mb-3" style="font-size: 1rem !important;">
                        <option value="1">Adventure</option>
                        <option value="2">Action</option>
                        <option value="3">Intelegent</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleInputPrice1">Price game</label>
                    <input name="price_edit" type="text" class="form-control" id="exampleInputPrice1" placeholder="Enter name game" required="required"/>
                </div>
                <div class="form-group">
                    <span id="img_res"></span>
                    <img id="image_edit" src="" width="50px" height="50px" style="border-radius: 10px" alt="Edit image"/>
                    <div class="custom-file">
                        <input type="file" name="file_edit" class="custom-file-input" id="inputGroupFile01"
                               aria-describedby="inputGroupFileAddon01"/>
                        <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                    </div>
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
    init_modal_open_close_btn_add_game();
    init_edit_modal_game();
</script>
</body>
</html>