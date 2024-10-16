package entities;
// Generated Aug 24, 2024, 5:17:33 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * KhachHang generated by hbm2java
 */
@Entity
@Table(name = "khach_hang", catalog = "ql_bansua")
public class KhachHang implements java.io.Serializable {

	private String maKhachHang;
	private String tenKhachHang;
	private boolean phai;
	private String diaChi;
	private String dienThoai;
	private String email;

	public KhachHang() {
	}

	public KhachHang(String maKhachHang, String tenKhachHang, boolean phai, String diaChi, String dienThoai,
			String email) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.phai = phai;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
	}

	@Id

	@Column(name = "Ma_khach_hang", unique = true, nullable = false, length = 5)
	public String getMaKhachHang() {
		return this.maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	@Column(name = "Ten_khach_hang", nullable = false, length = 100)
	public String getTenKhachHang() {
		return this.tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	@Column(name = "Phai", nullable = false)
	public boolean isPhai() {
		return this.phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	@Column(name = "Dia_chi", nullable = false, length = 200)
	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Column(name = "Dien_thoai", nullable = false, length = 20)
	public String getDienThoai() {
		return this.dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	@Column(name = "Email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
