/**
 * 
 */
function redirectToDetail(bookId, contentPath) {
       window.location.href = contentPath + "/product_detail/" + bookId;
   }

function redirectToDetail(bookId, contentPath) {
       window.location.href = contentPath + "/cart/add/" + bookId;
   }
   
      
   /// js Book_Detail
   // open tab comment
function getReviewsTrue(){
    	  let reviews_tab =  document.getElementById('reviews-tab');
    	  let description_tab =  document.getElementById('description-tab');
   	
    	  description_tab.classList.remove("active");
    	  description_tab.setAttribute('aria-selected', 'false');
    	  description_tab.removeAttribute("tabindex");
    	  document.getElementById("description").classList.remove("active", "show");
   	
    	  reviews_tab.classList.add("active");
    	  reviews_tab.setAttribute("aria-selected", 'true');
    	  reviews_tab.setAttribute("tabindex",'-1');
    	  document.getElementById("reviews").classList.add("active", "show");
    	    
  }
  
  // handle and send data to payment by [mua ngay] button
  
function sendRedirectToPayment( contentPath, bookId, actionUrl){
	let quantity = document.getElementById("quantity").value;
	window.location.href = contentPath + "/cart/add/" + bookId +"?actionUrl=" + actionUrl + "&quantity=" + quantity;
	console.log("Redirect add/cart");
  }
  
  
