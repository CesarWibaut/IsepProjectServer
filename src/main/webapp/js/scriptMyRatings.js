const API_KEY  = "8d4eebc9735f52f03dbf6c13a652b5c7";
const BASE_POSTER = "http://image.tmdb.org/t/p/w200";
$.ajax({
    type: "GET",
    url: "Ratings",
    dataType: "json",
    success: function (response) {
    	console.log(response);
        for(let i=0; i < response.length; i++){
            console.log(response[i]);
            search(response[i]);
        }
    }
});

function search(rating){
    let id = rating.fid;
    let score = rating.score;
    $.ajax({
        type: "GET",
        url: "https://api.themoviedb.org/3/movie/"+id+"?api_key="+API_KEY,
        dataType: "json",
        success: function (response) {
            draw(response, score);
        }
    });
}



function draw(movie, score){
    let output = "";
    if(score >= 7){
        output += "<tr class=\"success\">";
    }else if (score <= 4){
        output += "<tr class=\"danger\">";
    }else{
        output += "<tr class=\"warning\">";
    }

    output += "<td> <img width=\"75px\" src=\"" + BASE_POSTER + movie.poster_path + "\"> </td>";
    output += "<td> <h1> <a href=\"movie.jsp?id=" + movie.id + "\">" + movie.title + "</a> </h1> </td>";
    output += "<td> <h1>" + score + " <h1> </td>";
    output += "<td> <h1>" + avg(movie.id) + " <h1> </td>";
    output += "</tr>";

    $("#listRatings").append(output);
}

function avg(id){
    let score = 0;
    $.ajax({
        async:false,
        type: "GET",
        url: "GlobalRating?id="+id,
        dataType: "text",
        success: function (response) {
            score=response;
        }
    });
    return score;
}