/**
 * 
 */
function chao() {
	let ten = document.getElementById("ten").value;
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let loiChao = this.responseText;
			document.getElementById("loiChao").innerHTML = loiChao;
			console.log("loiChao: "+loiChao);
		}
	}
	xhr.open("POST", "Vd5Servlet");//không kèm tham số vì method post
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("ten=" + ten);


}