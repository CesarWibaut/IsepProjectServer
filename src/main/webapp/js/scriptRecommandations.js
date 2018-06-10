const API_KEY  = "8d4eebc9735f52f03dbf6c13a652b5c7";
const BASE_POSTER = "http://image.tmdb.org/t/p/w300"

$(document).ready(function () {
	
    $.ajax({
        type: "GET",
        url: "Recommandations",
        dataType: "json",
        success: function (response) {
            for(let i = 0; i < response.length; i++){
                toMovie(response[i]);
            }
        }
    });
    

});

function toMovie(id){
    $.ajax({
        type: "GET",
        url: "https://api.themoviedb.org/3/movie/"+id+"?api_key="+API_KEY,
        dataType: "json",
        success: function (response) {
            console.log("VOICI LE FILM ALALA");
            console.log(response);
            drawMovie(response);
        }
    });
}


function drawMovie(movie){
    if(movie.media_type == null || movie.media_type =="movie"){
        console.log( movie);
        var box = "<div  id=\"movie\">";
        if(movie.backdrop_path == null){
            
        }else{
            box +=" <img class=\"card-img-top\" alt=\"Thumbnail [100%x225]\" style=\"display: block;\" src="+BASE_POSTER + movie.poster_path+" data-holder-rendered=\"true\">";
        }
        box+="<div class=\"card-body\">";
        box+="<h3><a id=\"movielink\" href=\"movie.jsp?id="+movie.id+"&rec=true\">"+movie.title + " ("+movie.release_date+")</a></h3>";
        box+="<p class=\"card-text\">"+String(movie.overview).substring(0,200)+"...</p>";
        box+= "<div class=\"d-flex justify-content-between align-items-center\"> </div></div>";

        $("#movies").append(box);
    }

}


