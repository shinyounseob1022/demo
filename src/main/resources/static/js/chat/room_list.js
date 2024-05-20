$(document).ready(function() {
    validateLogin();
    setLoginUserInfo();
    getRoomList();
});

function getRoomList() {
    $.ajax({
        type : "get",
        url : "/chats/rooms",
        success : function(result) {
            let roomList = result.data;
            console.log(roomList.length);
            let html = ``;
            if (roomList.length < 1) {
                html = `존재하는 채팅방이 없습니다. 채팅방을 만들어 주세요!`;
            }
            roomList.forEach((room) => {
                console.log(room);
                html += `<li>${room.roomName}</li>`;
            });
            $(".room-list").empty();
            $(".room-list").append(html);
        },
        error : function(request, status, error) {
            console.log(error)
        }
    });
}