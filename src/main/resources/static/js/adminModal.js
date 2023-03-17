  
  const modal = document.querySelector('.adminModal');
      
	const btnOpenPopup = document.querySelector('.adminAdd_btn');

    btnOpenPopup.addEventListener('click', () => {
    	modal.style.display = 'block';
    });
    
    btnOpenPopup.addEventListener('click', (e) => {
    	if(e.target.classList.contains('.adminModal')) {
      	document.style.overflow = "visible";
      	modal.style.display = "none";
    	}
    });