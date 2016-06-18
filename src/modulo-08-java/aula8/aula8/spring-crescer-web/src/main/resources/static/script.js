'use strict';

$(function(){
    
    $('button[data-action=remove]').click(function(e){
        var pessoaId = parseInt(e.target.dataset.pessoaId);
        removerEntidade(pessoaId);
    });
    
});

function removerEntidade(pessoaId){
    $.ajax({url:'rest/pessoa/delete', type: 'POST', data: { id : pessoaId}})
        .done(function(){
            var tagBusca = 'button[data-pessoa-id=' + pessoaId + ']';
            $(tagBusca).parents('tr').hide();
        });
}
