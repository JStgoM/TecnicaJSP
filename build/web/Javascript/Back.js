/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function noBack(){
            window.addEventListener('popstate', function(event) {
	history.pushState(null, null, window.location.pathname);
	history.pushState(null, null, window.location.pathname);
	}, false);
}
window.history.forward();
function noBackCMO(){
    window.history.forward();
}
