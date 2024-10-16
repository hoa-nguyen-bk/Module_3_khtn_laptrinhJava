package entities;
// Generated Aug 24, 2024, 5:17:33 PM by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * HoaDon generated by hbm2java
 */
@Entity
@Table(name = "hoa_don", catalog = "ql_bansua")
public class HoaDon implements java.io.Serializable {

	private String soHoaDon;
	private Date ngayHd;
	private String maKhachHang;
	private double triGia;
	private Set<CtHoadon> ctHoadons = new HashSet<CtHoadon>(0);

	public HoaDon() {
	}

	public HoaDon(String soHoaDon, Date ngayHd, String maKhachHang, double triGia) {
		this.soHoaDon = soHoaDon;
		this.ngayHd = ngayHd;
		this.maKhachHang = maKhachHang;
		this.triGia = triGia;
	}

	public HoaDon(String soHoaDon, Date ngayHd, String maKhachHang, double triGia, Set<CtHoadon> ctHoadons) {
		this.soHoaDon = soHoaDon;
		this.ngayHd = ngayHd;
		this.maKhachHang = maKhachHang;
		this.triGia = triGia;
		this.ctHoadons = ctHoadons;
	}

	@Id

	@Column(name = "So_hoa_don", unique = true, nullable = false, length = 5)
	public String getSoHoaDon() {
		return this.soHoaDon;
	}

	public void setSoHoaDon(String soHoaDon) {
		this.soHoaDon = soHoaDon;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Ngay_HD", nullable = false, length = 10)
	public Date getNgayHd() {
		return this.ngayHd;
	}

	public void setNgayHd(Date ngayHd) {
		this.ngayHd = ngayHd;
	}

	@Column(name = "Ma_khach_hang", nullable = false, length = 5)
	public String getMaKhachHang() {
		return this.maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	@Column(name = "Tri_gia", nullable = false, precision = 22, scale = 0)
	public double getTriGia() {
		return this.triGia;
	}

	public void setTriGia(double triGia) {
		this.triGia = triGia;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hoaDon")
	public Set<CtHoadon> getCtHoadons() {
		return this.ctHoadons;
	}

	public void setCtHoadons(Set<CtHoadon> ctHoadons) {
		this.ctHoadons = ctHoadons;
	}

}
