/*
const modal = document.querySelector('.userList_modal');
      

	const btnOpenPopup = document.querySelector('.pwreset_modal_btn');

    btnOpenPopup.addEventListener('click', () => {
    	modal.style.display = 'block';
    });
    
    btnOpenPopup.addEventListener('click', (e) => {
    	if(e.target.classList.contains("management_modal")) {
      	document.style.overflow = "visible";
      	modal.style.display = "none";
    	}
    });
  */   
     
      
/*
var modalOn;
var modalOff;

$(document).ready(function() {
  const modal = document.getElementsByClassName('userList_modal');

  modalOn = function() { //켜기
    modal.style.display = "block";
  };
  modalOff = function() { //끄기
    modal.style.display = "none";
  }
   //켜기이벤트
  const btnModal = document.querySelectorAll("pwreset_modal_btn");
  btnModal.forEach(function(v) {
    v.addEventListener("click", function(e) {
      e.preventDefault();
      window.scrollTo({top: 0, behavior:"smooth"}); //브라우저위로이동
      document.body.style.overflow = "hidden"; //body에 들어가면 스크롤감춤
      modalOn();
    });
  });

  //모달창이외의창 끄기
 /*
	 modal.addEventListener("click", e => {
    if(e.target.classList.contains("management_modal")) {
      document.body.style.overflow = "visible";
      modalOff();
    }
  })
});
  */



/*
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
					spanes[num].onclick = function() {
						modals[num].style.display = "none";
					};
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
			
	*/	

/*
 const modal = document.querySelector('.userList_modal');
      const btnOpenPopup = document.querySelector('.pwreset_modal_btn');

      btnOpenPopup.addEventListener('click', () => {
        modal.style.display = 'block';
      });
*/

/*
$(".pwreset_modal_btn").click(function() {
	
	var pwresetConfirm = confirm('비밀번호를 초기화 시키겠습니까?');
	
   		if (pwresetConfirm) {
	      	alert('초기화 완료되었습니다.');
	      	
	      	var resetOk = {pwresetConfirm}*1;
	      	console.log(resetOk);
	      	var aaa = String(resetOk);
	      	console.log(aaa);
	      	
	      	var formData = new FormData();
	      	formData.append('resetOk', resetOk);
	      	console.log(formData.append());
	      	
	      	$.ajax({
			url:"/getPw",
			type:"post",
			data: formData,
			contentType: false,
			processData: false, 
			success:function(data){
				console.log(data)
			},
			error: function(err){
				console.log(err)
			}
			
		});
	      	/*
	    	$('#formAction').submit();
	    	console.log($('#formAction').submit());
  		}
   		else {
      		alert('초기화 취소되었습니다.');
      		
    	}
    	
});
*/

$(".pwreset_modal_btn").click(function(e) {
	
	e.preventDefault();
 
      $(".userList_modal").show();
});
 
  $(document).mouseup(function (e){

    var modalClose = $('.userList_modal');

    if( modalClose.has(e.target).length === 0){

      modalClose.css('display','none');

    }

  });



  
