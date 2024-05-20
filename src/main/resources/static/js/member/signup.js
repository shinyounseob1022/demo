
// 회원가입
$(".signup").on("click", function() {
    let email = $(".email").val();
    let name = $(".name").val();
    let birthday = $(".birthday").val();
    let address = $(".address").val();
    let password = $(".password").val();
    let verifiedPassword = $(".verified-password").val();

    let data = {
        "email" : email,
        "name" : name,
        "birthday" : birthday,
        "address" : address,
        "password" : password,
        "verifiedPassword" : verifiedPassword
    };

    $.ajax({
        type : "post",
        url : "/members/signup",
        headers : {"Content-Type" : "application/json"},
        data : JSON.stringify(data),
        success : function(result) {
            console.log(result);
            alert(result.message);
            if (result.status === "success") {
                location.href = "/page/login";
            }
        },
        error : function(request, status, error) {
            console.log(error);
        }
    });
});
