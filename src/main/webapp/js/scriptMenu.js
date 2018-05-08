const API_KEY  = "8d4eebc9735f52f03dbf6c13a652b5c7";
let researchValue = "";
const BASE_POSTER = "http://image.tmdb.org/t/p/w300"
let count = 0;
$("#searchButton").click(function (e) { 
    
    e.preventDefault();
    researchValue = $("#searchBar").val();

    if(researchValue == ""){
        alert("Please fill all the blanks !");
        return;
    }

    $("#movies").html("");
    $("#darker").show();
    
    if($("#type").attr("type") == "movie"){
        searchMovie();
    }else{
        searchActor();
    }
});

function searchActor(){
    $.ajax({
        type: "GET",
        url: "https://api.themoviedb.org/3/search/person?api_key="+API_KEY+"&query="+ researchValue +"&page=1",
        dataType: "json",
        success: function (response) {
        	console.log(response);
            for(let i = 0 ; i < response.results.length; i++){
                for(let j = 0; i < response.results[i].known_for.length; j++){
                    drawActor(response.results[i].known_for[j]);
                }
            }
        }
    });
}


function searchMovie(){
    $.ajax({
        type: "GET",
        url: "https://api.themoviedb.org/3/search/movie?api_key="+API_KEY+"&query="+ researchValue +"&page=1",
        dataType: "json",
        success: function (response) {
        	console.log(response);
            for(let i = 0 ; i < response.results.length; i++){
                
                drawMovie(response.results[i]);
            }
            if(count %3 !=0){
                $("#movies").append("</div>");
            }
        }
    });
}

function drawMovie(movie){
    count ++ ;
    var box = "<div  id=\"movie\">";
    if(movie.backdrop_path == null){
        
    }else{
        box +=" <img class=\"card-img-top\" alt=\"Thumbnail [100%x225]\" style=\"display: block;\" src="+BASE_POSTER + movie.poster_path+" data-holder-rendered=\"true\">";
    }
    box+="<div class=\"card-body\">";
    box+="<h3><a href=\"movie.jsp?id="+movie.id+"\">"+movie.title + " ("+movie.release_date+")</a></h3>";
    box+="<p class=\"card-text\">"+String(movie.overview).substring(0,200)+"...</p>";
    box+= "<div class=\"d-flex justify-content-between align-items-center\"> </div></div>";

    $("#movies").append(box);
    if(count % 3 == 0){
        $("#movies").append("</div>");
    }

}