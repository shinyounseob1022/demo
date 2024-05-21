$(document).ready(function() {
    validateLogin();
    setLoginUserInfo();
    getRoomList();
});

$(".create-room").on("click", function() {

    const token = localStorage.getItem("token");
    const roomName = $(".room-name").val();
    const email = getUserEmail();

    let data = {
        "roomName" : roomName,
        "email" : email
    };

    $.ajax({
        type : "post",
        url : "/chats/room",
        headers : {
            "Content-Type" : "application/json",
            "Authorization" : `Bearer ${token}`
        },
        data : JSON.stringify(data),
        success : function(result) {
            console.log(result);
            getRoomList();
        },
        error : function(request, status, error) {
            console.log(error);
        }
    });
});

function getRoomList() {
    const token = localStorage.getItem("token");
    $.ajax({
        type : "get",
        url : "/chats/rooms",
        headers : {
            "Authorization" : `Bearer ${token}`
        },
        success : function(result) {
            let roomList = result.data;
            let html = ``;
            if (roomList.length < 1) {
                html = `존재하는 채팅방이 없습니다. 채팅방을 만들어 주세요!`;
            }
            roomList.forEach((room) => {
                console.log(room);
                html += `<li><a href="/page/room/${room.id}">${room.roomName}</a></li>`;
            });
            $(".room-list").empty();
            $(".room-list").append(html);
        },
        error : function(request, status, error) {
            console.log(error)
        }
    });
}