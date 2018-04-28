const id = $("body").attr("id");
const API_KEY  = "8d4eebc9735f52f03dbf6c13a652b5c7";
const BASE_POSTER = "http://image.tmdb.org/t/p/w300";
const BASE_BACKDROP = "http://image.tmdb.org/t/p/w1920";
console.log(id);


$.ajax({
    type: "GET",
    url: "https://api.themoviedb.org/3/movie/"+id+"?api_key="+API_KEY,
    dataType: "json",
    success: function (response) {
        $("head Title").text(response.title);
        $(".jumbotron h1").text(response.title);
        $(".jumbotron p").text(response.tagline);
        $(".jumbotron img").attr("src", BASE_POSTER + response.poster_path );
        $(".jumbotron").css("background-image", "url("+BASE_BACKDROP + response.backdrop_path+")");
    }
});