//modal 켜기
$(".adminAdd_btn").click(function(e) {

	e.preventDefault();

 	$(".adminModal").show();
});

//modal 이외 부분 누르면 닫히기
$(document).mouseup(function (e){

  var modalClose = $(".adminModal");

  if( modalClose.has(e.target).length === 0){

    modalClose.css('display','none');
  }
  
});
