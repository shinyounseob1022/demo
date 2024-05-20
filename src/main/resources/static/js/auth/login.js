
// 로그인
$(".login").on("click", function() {
    let email = $(".email").val();
    let password = $(".password").val();

    let data = {
        "email" : email,
        "password" : password
    };

    // jwt 발급
    $.ajax({
        type : "post",
        url : "/login",
        headers : {"Content-Type" : "application/json"},
        data : JSON.stringify(data),
        success : function(result) {
            localStorage.setItem("token", result.token);
            alert("로그인 성공.");
            location.href = "/";
        },
        error : function(request, status, error) {
            console.log(error);
        }
    });
});
