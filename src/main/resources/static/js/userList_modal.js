/*
var modalOn;
var modalOff;
$(document).ready(function() {
  const modal = document.getElementById("userList_modal");

  modalOn = function() { //켜기
    modal.style.display = "block";
  };
  modalOff = function() { //끄기
    modal.style.display = "none";
  }
  
  //모달창이외의창 끄기
  modal.addEventListener("click", e => {
    if(e.target.classList.contains("userList_modal")) {
      document.body.style.overflow = "visible";
      modalOff();
    }
  })

});
*/

// Modal을 가져온다
			var modals = document.getElementsByClassName("userList_modal");
			// Modal을 띄우는 클래스 이름을 가져온다.
			var btns = document.getElementsByClassName("pwreset_modal_btn");
			// Modal을 닫는 close 클래스를 가져온다.
			//var spanes = document.getElementsByClassName("close");
			var funcs = [];
			
			// Modal을 띄우고 닫는 클릭 이벤트를 정의한 함수
			function Modal(num) {
				return function(){
					// 해당 클래스의 내용을 클릭하면 Modal을 띄운다.
					btns[num].onclick = function(){
						modals[num].style.display = "block";
						console.log(num);
					};
					
					// 닫기 버튼 클릭하면 Modal이 닫힌다.
					/*
					spanes[num].onclick = function() {
						modals[num].style.display = "none";
					};
					*/
				};
			}
			
			// 원하는 Modal 수만큼 Modal 함수를 호출해서 funcs 함수에 정의한다.
			for(var i = 0; i< btns.length; i++){
				funcs[i] = Modal(i);
			};
			// 원하는 Modal 수만큼 funcs 함수를 호출한다.
			for(var j = 0; j< btns.length; j++){
				funcs[j]();
			};
			// Modal 영역 밖을 클릭하면 Modal을 닫는다.
			window.onclick = function(event) {
				if(event.target.className == "userList_modal"){
					event.target.style.display = "none";	
				}
			};