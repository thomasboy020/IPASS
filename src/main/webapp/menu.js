//$.get("restservices/gerechten/getAll", function(data) {
//	console.log(data);
//	$(".menu").append(data);
//});

$(function() {
     $.getJSON("./restservices/gerechten/getAll", function(data) {
       $.each(data, function(v, n) {
         var gerechten=n.naam;
         $(".menu").append(gerechten);
       })
     })
})

$(function() {
     $.getJSON("./restservices/gerechten/getAll", function(data) {
       $.each(data, function(v, n) {
         var gerechten1=n.allergie_info;
         $(".menu").append(gerechten1);
       })
     })
})

$(function() {
     $.getJSON("./restservices/gerechten/getAll", function(data) {
       $.each(data, function(v, n) {
         var gerechten2=n.beschrijving;
         $(".menu").append(gerechten2);
       })
     })
})