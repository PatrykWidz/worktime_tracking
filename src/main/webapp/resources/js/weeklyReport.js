document.addEventListener("DOMContentLoaded", function(){
	
	var divElems = document.querySelectorAll(".with-border");
	console.log(divElems);
	
	divElems.forEach( elem => elem.addEventListener("mouseover", function() {
		
		this.classList.add('hovered');
	}));
	
	divElems.forEach( elem => elem.addEventListener("mouseleave", function() {
		
		this.classList.remove('hovered');
	}));
});