const API_KEY  = "8d4eebc9735f52f03dbf6c13a652b5c7";
let researchValue = "";


$("#searchButton").click(function (e) { 
    e.preventDefault();
    researchValue = $("#searchBar").val();

    if(researchValue == ""){
        alert("Please fill all the blanks !");
        return;
    }

    $.ajax({
        type: "GET",
        url: "https://api.themoviedb.org/3/search/movie?api_key="+API_KEY+"&query="+ researchValue +"&page=1",
        dataType: "json",
        success: function (response) {
            console.log(response);
        }
    });

});