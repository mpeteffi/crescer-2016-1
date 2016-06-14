'use strict';

$(function () {
    
    $("#form").submit(function (e) {
        var formData = new FormData($("#form")[0]);
        var n = formData.get('txtNome');
        var i = formData.get('txtIdade');
        var s = formData.get('txtSexo');

        $.ajax({ url: "/aula5web/pessoa", type: 'GET', data: { nome: n, idade: i, sexo: s } })
        .done(function (res) {
            $(".list-group").append($('<li>').addClass('list-group-item').text(res));
        });
        
        $("#txtNome").val("").focus();
        $("#txtIdade").val("");
        
        e.preventDefault();
    });
 });
