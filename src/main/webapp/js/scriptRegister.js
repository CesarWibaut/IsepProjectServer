$("#button").click(function (e) {
    e.preventDefault();
    step2();


});


function step2() {
    if ($("#pwd").val() == $("#pwdverify").val()) {
        step3();
    } else {
        alert("Wrong password !")
    }
}

function step3() {
    let inputs = $("input");
    console.log(inputs);
    for (let i = 0; i < inputs.length; i++) {
        console.log(inputs[i].value);
        if (inputs[i].value == "") {
            alert("Please fill all the fields");
            return;
        }
    }
    $.ajax({
        type: "GET",
        url: "RegisterVerif?email=" + $("#email").val(),
        dataType: "text",
        async: false,
        success: function (response, text, xhr) {
            if (xhr.status != 404) {
                alert("Email already in use");
            }
        },
        error: function (xhr, status, errorThrown) {
           register();
        }

    });
}

function register() {
    $.ajax({
        type: "POST",
        url: "Register",
        data: {
            "first": $("#firstName").val(),
            "last": $("#lastName").val(),
            "email": $("#email").val(),
            "pwd": $("#pwd").val()
        },
        success: function (response) {
            $.ajax({
                type: "POST",
                url: "InitSession",
                data: {
                    "firstname": $("#firstName").val()
                },
                success: function (response) {
                    window.location.replace("Menu");
                }
            });
        }
    });
}