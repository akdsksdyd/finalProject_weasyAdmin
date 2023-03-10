var modalOn;
var modalOff;
$(document).ready(function() {
  const modal = document.getElementById("basicModal");

  modalOn = function() { //켜기
    modal.style.display = "block";
  };
  modalOff = function() { //끄기
    modal.style.display = "none";
  }
  
  //모달창이외의창 끄기
  modal.addEventListener("click", e => {
    if(e.target.classList.contains("management_modal")) {
      document.body.style.overflow = "visible";
      modalOff();
    }
  })

});