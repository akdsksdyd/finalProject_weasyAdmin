/*
$(".management_modal_btn").click(function(e) {
	
	e.preventDefault();
 
      $(".management_modal").show();
});
 
  $(document).mouseup(function (e){

    var modalClose = $(".management_modal");

    if( modalClose.has(e.target).length === 0){

      modalClose.css('display','none');

    }

  });
*/


const modal = document.querySelector('.management_modal');
      
	const btnOpenPopup = document.querySelector('.management_modal_btn');

    btnOpenPopup.addEventListener('click', () => {
    	modal.style.display = 'block';
    });
    
    btnOpenPopup.addEventListener('click', (e) => {
    	if(e.target.classList.contains('.management_modal')) {
      	document.style.overflow = "visible";
      	modal.style.display = "none";
    	}
    });
  
     
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
 
	 modal.addEventListener("click", e => {
    if(e.target.classList.contains("management_modal")) {
      document.body.style.overflow = "visible";
      modalOff();
    }
  })
});
*/

/*
		

/*
 const modal = document.querySelector('.userList_modal');
      const btnOpenPopup = document.querySelector('.pwreset_modal_btn');

      btnOpenPopup.addEventListener('click', () => {
        modal.style.display = 'block';
      });

		
   		if (pwresetConfirm) {
	      	alert('초기화 완료되었습니다.');
	      	
	      	var resetOk = {pwresetConfirm}*1;
	      	console.log(resetOk);
	      	
	      	
	      	//var aaa = String(resetOk);
	      	
	      	
	      	var formData = new FormData();
	      	formData.append('resetOk', resetOk);
	      	console.log(formData.append());
	      	
		}
		});

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
			
			
	      	/*
	    	$('#formAction').submit();
	    	console.log($('#formAction').submit());
  		}
   		else {
      		alert('초기화 취소되었습니다.');
      		
    	}
    	
});
*/




  
