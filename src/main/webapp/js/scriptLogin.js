$("#login").click(function (event){
    event.preventDefault();
    step1();
});

function step1(){
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
            window.location.replace("Menu");
        },
        error: function(){
            alert("Wrong email or password");
            $("#password").val("");
        }
    });
}