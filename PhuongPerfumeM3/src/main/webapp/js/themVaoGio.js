/**
 * 
 */
function themVaoGio(id,slm) {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(this.readyState==4&&this.status==200){
			let arrResponseText = this.responseText.split("/");
			console.log("arrResponseText = "+arrResponseText);
			let tongTien = arrResponseText[0];
			let soMatHang = arrResponseText[1];
			document.getElementById("tongTien").innerHTML=tongTien;
			document.getElementById("soMatHang").innerHTML=soMatHang;
		}
	}
	xhr.open("GET","ThemVaoGioServlet?idsp="+id+"&slm="+slm);
	xhr.send();
}