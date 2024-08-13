package javaBean;

import java.io.Serializable;

/*
 * Java bean là một lớp java đơn giản thỏa 4 yêu cầu
 * 1. thực thi giao tiếp Serializable
 * 2. Các thành phần dữ liệu private
 * 3. có các phương thức getter và setter
 * 4. có một phương thức khởi tạo không tham số
 * */

public class LoaiSua implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maLoai;
	private String tenLoai;
	public LoaiSua() {
		super();
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
}
