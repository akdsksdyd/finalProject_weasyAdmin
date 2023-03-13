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
  
   //켜기이벤트
  const btnModal = document.querySelectorAll(".modalOn");
  btnModal.forEach(function(v) {
    v.addEventListener("click", function(e) {
      e.preventDefault();
      window.scrollTo({top: 0, behavior:"smooth"}); //브라우저위로이동
      document.body.style.overflow = "hidden"; //body에 들어가면 스크롤감춤
      modalOn();
    });
  });
  
  //모달창이외의창 끄기
  modal.addEventListener("click", e => {
    if(e.target.classList.contains("management_modal")) {
      document.body.style.overflow = "visible";
      modalOff();
    }
  })

});