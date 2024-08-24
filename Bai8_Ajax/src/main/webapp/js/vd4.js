/**
 * 
 */
function chao() {
	let ten = document.getElementById("ten").value;
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			//web server trả về
			let loiChao = this.responseText;
			document.getElementById("loiChao").innerHTML = loiChao;
		}
	}
	//kèm theo tham số trên địa chỉ
	xhr.open("GET", "Vd4Servlet?ten=" + ten);
	xhr.send();
}