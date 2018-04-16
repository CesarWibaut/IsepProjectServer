$("#login").click(function (event){
    event.preventDefault();
    step1();
});

function step1(){
    let inputs = $("input");
    console.log(inputs);
    for(let i = 0; i < inputs.length; i++){
        alert(inputs[i].value);
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
        url: "VerifLogin",
        data: "data",
        dataType: "dataType",
        success: function (response) {
            
        }
    });
}