//submit 버튼 클릭시
$("#submit").click(function(){
	
	$(".admin").submit();

});

//이메일 중복검사
function checkId(){
	var id = $('#id').val(); //id값이 "id"인 입력란의 값을 저장
	//console.log(id);
	
		$.ajax({
		    url:'/idCheck', //Controller에서 요청 받을 주소
		    type:'post', //POST 방식으로 전달
		    data:{id:id},
		    
		    success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
		    
		        if(cnt == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
		        	var emailCheck = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
		        	
		        	if(!emailCheck.test(id)){
						$('.id_form').css("display","inline-block"); 
			            $('.id_ok').css("display", "none");
			            $('.id_already').css("display", "none");
					} else {
			            $('.id_ok').css("display","inline-block"); 
			            $('.id_form').css("display", "none");
			            $('.id_already').css("display", "none");
						
					}
		        	
		            
		        } else { //cnt가 1일 경우 -> 이미 존재하는 아이디
		            $('.id_already').css("display","inline-block");
		            $('.id_ok').css("display", "none");
		            $('.id_form').css("display", "none");
		            //$('#id').val('');
		        }
		    },
		    
		    error:function(){
		        alert("에러입니다");
		    }
		});
};

//비밀번호 중복확인
function passConfirm() {
	
	var passwdCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\'",.<>\/?]).{8,16}$/);
	
	var password = $('#password').val();
	var passwordConfirm = $('#passwordConfirm').val();
 	
	//console.log(password);
	//console.log(passwordConfirm);
	
	if(password == passwordConfirm){
		
		if(!passwdCheck.test($("#passwordConfirm").val())){
			
			$('.pw_form').css("display","inline-block"); 
	        $('.pw_ok').css("display", "none"); 
	        $('.pw_no').css("display", "none"); 
			
		}else{
			
			$('.pw_ok').css("display","inline-block"); 
	        $('.pw_form').css("display", "none"); 
	        $('.pw_no').css("display", "none"); 
			
		}
        
	}else{
		 $('.pw_no').css("display","inline-block");
         $('.pw_ok').css("display", "none");
	     $('.pw_form').css("display", "none"); 
	}
}  

//이름 확인
function checkName(){
	
	var nameCheck = RegExp(/^[가-힣]{2,6}$/);
	
	if(!nameCheck.test($("#name").val())){
		 $('.name_form').css("display","inline-block");
		
	} else{
	     $('.name_form').css("display", "none"); 
		
	}
}

//핸드폰번호 확인
function checkNum(){
	
	var phonNumberCheck = RegExp(/^01[0179][0-9]{7,8}$/);
	
	if(!phonNumberCheck.test($("#phoneNum").val())){
		 $('.num_form').css("display","inline-block");
		 
    }else {
		 $('.num_form').css("display", "none"); 	
	}
}



function Check(){
	
	var userEmail = $("#id").val();
	var userPw = $("#password").val();
	var userPwconfirm = $("#passwordConfirm").val();
	var userName = $("#name").val();
	var phoneNum = $("#phoneNum").val();
	var role = $("#role").val();
	
	var emailCheck = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
	var passwdCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\'",.<>\/?]).{8,16}$/);
 	var nameCheck = RegExp(/^[가-힣]{2,6}$/);
	var phonNumberCheck = RegExp(/^01[0179][0-9]{7,8}$/);
	
	//이메일공백
	console.log(userEmail);
	if(userEmail == ""){
		alert("이메일을 입력해주세요.");
	    $("#id").focus();
	    return false;
	}
	 
	 //이메일 유효성검사
      if(!emailCheck.test($("#id").val())){
		  alert("이메일 형식에 맞게 입력해주세요.");
        $("#id").val("");
        $("#id").focus();
        return false;
      }
	 
	 //비밀번호공백
	 if(userPw == ""){
		alert("비밀번호를 입력해주세요.");
	    $("#id").focus();
	    return false;
	 }
	 
	 //비밀번호 유효성검사
	 if(!passwdCheck.test($("#password").val())){
		alert("비밀번호는 8~16자의 영문 대소문자, 숫자,특수문자만 가능합니다.");
        $("#password").val("");
        $("#password").focus();
        return false;
      }
	 
	 //비밀번호확인 공백
	 if(userPwconfirm == ""){
		alert("비밀번호 확인창을 입력해주세요.");
	    $("#id").focus();
	    return false;
	 }
	 
	 //비밀번호확인 유효성검사
	 if(!passwdCheck.test($("#passwordConfirm").val())){
		alert("비밀번호는 8~16자의 영문 대소문자, 숫자,특수문자만 가능합니다.");
        $("#passwordConfirm").val("");
        $("#passwordConfirm").focus();
        return false;
      }

      //비밀번호 중복확인
      if($("#password").val() != ($("#passwordConfirm").val())){ 
		  alert("비밀번호가 불일치합니다.");
	      $("#password").val("");
	      $("#passwordConfirm").val("");
	      $("#password").focus();
	      return false;
     }
	 
	 //이름공백
	 if(userName == ""){
		alert("이름을 입력해주세요.");
	    $("#id").focus();
	    return false;
	 }
	 
	 //이름 유효성검사
	 if(!nameCheck.test($("#name").val())){
		 alert("이름형식에 맞게 입력해주세요.");
        $("#name").val("");
        $("#name").focus();
        return false;
      }
	 
	 //핸드폰번호공백
	 if(phoneNum == ""){
		 alert("핸드폰번호를 입력해주세요.");
	    $("#id").focus();
	    return false;
	 }
	 
	 //핸드폰번호 유효성검사
	 if(!phonNumberCheck.test($("#phoneNum").val())){
		 alert("핸드폰 번호형식에 맞게 입력해주세요.");
        $("#phoneNum").val("");
        $("#phoneNum").focus();
        return false;
      }
      
      //권한체크박스
	  if (!role.attr("checked")){
		  alert("관리자권한 체크박스를 선택해주세요.");
		return false;
	  }
      
};	 
	 
