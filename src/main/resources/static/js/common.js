// common.js

function setLoginUserInfo() {
    const email = getUserEmail();
    appendLoginUserHtml(email);

    $(".logout").on("click", function() {
        if (confirm("로그아웃 하시겠습니까?")) {
            localStorage.removeItem("token");
            location.reload();
        }
    });
};

// 로컬스토리지의 토큰을 디코딩하여 이메일을 추출
function getUserEmail() {
    const token = localStorage.getItem('token');
    if (token === "" || token === undefined || token === null) {
        return;
    }

    const base64Payload = token.split('.')[1];
    const base64 = base64Payload.replace(/-/g, '+').replace(/_/g, '/');
    const decodedJWT = JSON.parse(
          decodeURIComponent(
            window
              .atob(base64)
              .split('')
              .map(function (c) {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
              })
              .join('')
        )
    );

    return decodedJWT.sub;
}

// 로그인된 사용자 및 로그아웃 버튼 표시
function appendLoginUserHtml(email) {
    $(".username").empty();
    if (email != "" && email != undefined && email != null ) {
        let html = `<spa>${email}님 안녕하세요.&nbsp;</span><button class="logout">로그아웃</button>`;
        $(".username").append(html);
    }
}

function pageRequest(url) {
    const token = localStorage.getItem("token");
    console.log(token);
    if (token === "" || token === undefined || token === null) {
        alert("로그인이 필요합니다.");
        return;
    }
    $.ajax({
        type : "get",
        url : url,
        headers : {"Authorization" : `Bearer ${token}`},
        success : function(result) {
            console.log(result);
        },
        error : function(request, status, error) {
            console.log(error);
        }
    });
}