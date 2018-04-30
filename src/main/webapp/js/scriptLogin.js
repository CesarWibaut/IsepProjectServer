$("#login").click(function (event){
    event.preventDefault();
    verif();
});

function verif(){
    let inputs = $("input");
    console.log(inputs);
    for(let i = 0; i < inputs.length; i++){
        if(inputs[i].value==""){
            alert("Please fill all the fields");
            return;
        }
    }
    login();
}

function login(){
    $.ajax({
        type: "GET",
        url: "VerifLogin?email="+$("#email").val()+"&password="+$("#password").val(),
        success: function (response) {
            window.location.replace("menu.jsp");
        },
        error: function(){
            alert("Wrong email or password");
            $("#password").val("");
        }
    });
}