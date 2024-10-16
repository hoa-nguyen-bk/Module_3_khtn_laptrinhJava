package entities;
// Generated Aug 24, 2024, 5:17:33 PM by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * LoaiSua generated by hbm2java
 */
@Entity
@Table(name = "loai_sua", catalog = "ql_bansua")
public class LoaiSua implements java.io.Serializable {

	private String maLoaiSua;
	private String tenLoai;
	private Set<Sua> suas = new HashSet<Sua>(0);

	public LoaiSua() {
	}

	public LoaiSua(String maLoaiSua, String tenLoai) {
		this.maLoaiSua = maLoaiSua;
		this.tenLoai = tenLoai;
	}

	public LoaiSua(String maLoaiSua, String tenLoai, Set<Sua> suas) {
		this.maLoaiSua = maLoaiSua;
		this.tenLoai = tenLoai;
		this.suas = suas;
	}

	@Id

	@Column(name = "Ma_loai_sua", unique = true, nullable = false, length = 3)
	public String getMaLoaiSua() {
		return this.maLoaiSua;
	}

	public void setMaLoaiSua(String maLoaiSua) {
		this.maLoaiSua = maLoaiSua;
	}

	@Column(name = "Ten_loai", nullable = false, length = 50)
	public String getTenLoai() {
		return this.tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiSua")
	public Set<Sua> getSuas() {
		return this.suas;
	}

	public void setSuas(Set<Sua> suas) {
		this.suas = suas;
	}

}
