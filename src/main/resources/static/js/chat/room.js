$(document).ready(function() {
    validateLogin();
    setLoginUserInfo();
    setRoomTitle();
});

function setRoomTitle() {
    let roomId = localStorage.getItem("roomId");
    let title = `채팅방: ${roomId}`;
    $(".room-title").append(title);
}