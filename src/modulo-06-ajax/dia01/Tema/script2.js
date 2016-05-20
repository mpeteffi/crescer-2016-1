'use strict';

$(function(){
  $('#buscar').submit(function(event){
    var nomeDaBanda = $('input[name=inputBusca]').val();
    var artistAPI = "https://api.spotify.com/v1/search?q=" + nomeDaBanda + "&type=artist";
    $.ajax({ url:artistAPI, type: 'GET' })
      .done(function (res){
        var idDaBanda = res.artists.items[0].id;
        var albumAPI = "https://api.spotify.com/v1/artists/" + idDaBanda + "/albums?limit=50";
        $.ajax({ url: albumAPI, type: 'GET' })
          .done(function (band){
            var albuns = band.items;
            adicionarCapasNaTela(albuns);
          });
      });
    event.preventDefault();
  });
});

function adicionarCapasNaTela(albuns){
  $('#albuns').empty();
  albuns.forEach(function(album){
    var urlImg = album.images[1].url;
    $('#albuns').append($('<img>').attr('src',urlImg));
  });
}
