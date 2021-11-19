function init_edit_modal_game() {
    let open_modal_edit = document.querySelectorAll('#open_modal_edit');
    let close_modal = document.querySelectorAll('#close_edit_modal');
    let modal = document.getElementById('modal_edit');
    let body = document.getElementsByTagName('body')[0];
    for (let index = 0; index < open_modal_edit.length; index++) {
        open_modal_edit[index].onclick = function(event) {
            modal.classList.add('modal_vis');
            modal.classList.remove('bounceOutDown');
            body.classList.add('body_block');
            $('span[id=name_game_edit_logo]').text(this.dataset.name_game);
            $('input[name=name_game_edit]').val(this.dataset.name_game);
            $('textarea[name=describe_game_edit]').val(this.dataset.describe_game);
            $("input[name=type_id_edit]").val(this.dataset.getType_id);
            $('input[name=price_edit]').val(this.dataset.price_game);
            if(this.dataset.getFilename_photo_game!=="None") {
                $("img[id=image_edit]").css("display","block")
                $("img[id=image_edit]").attr("src", "/img/"+this.dataset.filename_photo);
            }else{
                $('span[id=img_res]').text("None");
                $("img[id=image_edit]").css("display","none")
            }
            $('form[name=form_edit_game]').attr("action","/admin/Edit/"+this.dataset.id_game);
        };
    }
    for (let index = 0; index < close_modal.length; index++) {
        close_modal[index].onclick = function() {
            modal.classList.add('bounceOutDown');
            window.setTimeout(function() {
                modal.classList.remove('modal_vis');
                body.classList.remove('body_block');
            }, 500);
        };
    }
}

function init_edit_modal_user() {
    let open_modal_edit = document.querySelectorAll('#open_edit_user');
    let close_modal = document.querySelectorAll('#close_edit_modal');
    let modal = document.getElementById('modal_edit');
    let body = document.getElementsByTagName('body')[0];
    for (let index = 0; index < open_modal_edit.length; index++) {
        open_modal_edit[index].onclick = function(event) {
            modal.classList.add('modal_vis');
            modal.classList.remove('bounceOutDown');
            body.classList.add('body_block');
            $('span[id=name_user_edit_logo]').text(this.dataset.user_name);
            $('input[name=username_user_edit]').val(this.dataset.user_username);
            $('input[name=name_user_edit]').val(this.dataset.user_name);
            $("input[name=soname_user_edit]").val(this.dataset.user_soname);
            $('input[name=email_user_edit]').val(this.dataset.user_email);
            $('span[id=role_user]').text(this.dataset.user_role);
            $('form[name=form_edit_game]').attr("action","/admin/listofuser/edit/"+this.dataset.user_id);
        };
    }

    for (let index = 0; index < close_modal.length; index++) {
        close_modal[index].onclick = function() {
            modal.classList.add('bounceOutDown');
            window.setTimeout(function() {
                modal.classList.remove('modal_vis');
                body.classList.remove('body_block');
            }, 500);
        };
    }
}


function init_modal_open_close_btn_add_game() {
    let open_modal = document.getElementById('open_modal');
    let close_modal = document.getElementById('close_modal');
    let modal = document.getElementById('modal');
    let body = document.getElementsByTagName('body')[0];

    open_modal.onclick = function() {
        modal.classList.add('modal_vis');
        modal.classList.remove('bounceOutDown');
        body.classList.add('body_block');
    };

    close_modal.onclick = function() {
        modal.classList.add('bounceOutDown');
        window.setTimeout(function() {
            modal.classList.remove('modal_vis');
            body.classList.remove('body_block');
        }, 500);
    };

}
function init_modal_open_close_btn_order() {
    let open_modal = document.getElementById('open_modal');
    let close_modal = document.getElementById('close_modal');
    let modal = document.getElementById('modal');
    let body = document.getElementsByTagName('body')[0];

    open_modal.onclick = function() {
        modal.classList.add('modal_vis');
        modal.classList.remove('bounceOutDown');
        body.classList.add('body_block');
    };

    close_modal.onclick = function() {
        modal.classList.add('bounceOutDown');
        window.setTimeout(function() {
            modal.classList.remove('modal_vis');
            body.classList.remove('body_block');
        }, 500);
    };

}
function add_new_game(){
    var name_game = $('input[name=name_game]').val();
    var describe_game = $('input[name=describe_game]').val();
    var price_game = $('input[name=price]').val();
    var type_id = $('input[name=type_id]').val();

    if(name_game !== "" && describe_game !=="" && price_game !=="" &&type_id!==""){
        alert("All okey!Added new game")
        return true;
    }else{
        alert("Illegal argument for add game try yet");
        return false;
    }
}

function confirmEdit(){
    if (confirm("Do you confirm the edit?")) {
        return true;
    } else {
        return false;
    }
}

function confirmDelete(event) {
    if (confirm("Do you confirm the deletion?")) {
        return true;
    } else {
       return false;
    }
}

function confirmOrder(event) {
    if (confirm("Do you confirm the ordered?")) {
        return true;
    } else {
        return false;
    }
}

$("div.holder").jPages({
    containerID: "itemContainer",
    perPage: 9,
    startPage: 1,
    startRange: 1,
    midRange: 3,
    endRange: 1
});