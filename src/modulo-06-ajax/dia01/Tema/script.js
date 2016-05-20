'use strict';

$.ajax({
  url: 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50',
  type: 'GET'
}).done(function (e){
  var albuns = e.items;
  albuns.forEach(function(alb){
    var urlImg = alb.images[1].url;
    $('body').append($('<img>').attr('src',urlImg));
  });
});
