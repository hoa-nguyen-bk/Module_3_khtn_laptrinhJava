package businessLogics;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javaBeans.SanPham;
import javaBeans.SanPhamMua;

public class GioHang {
	private Hashtable<Integer, Integer> danhSachHang; // key: id sản phẩm -> từ id sản phẩm ra tất cả thông tin sản phẩm
														// luôn, value: số lượng mua
	public List<SanPhamMua> layDanhSachSanPhamMua(){
		List<SanPhamMua> danhSachSanPhamMua = new ArrayList<SanPhamMua>();
		// từ cái id mình lấy ra cái keySet
		for(int idSanPham:danhSachHang.keySet()) {
			SanPham sp  = SanPhamBL.docTheoId(idSanPham);
			SanPhamMua spm = new SanPhamMua();
			
			spm.setId(sp.getId());
			spm.setIdLoai(sp.getIdLoai());
			spm.setIdThuongHieu(sp.getIdThuongHieu());
			spm.setHienThi(sp.getHienThi());
			spm.setNgayTao(sp.getNgayTao());
			spm.setDonGia(sp.getDonGia());
			spm.setDonGiaKM(sp.getDonGiaKM());
			spm.setHinhAnh(sp.getHinhAnh());
			spm.setMoTa(sp.getMoTa());
			spm.setTenSanPham(sp.getTenSanPham());
			spm.setSoLuong(sp.getSoLuong());
			
			spm.setSoLuongMua(danhSachHang.get(idSanPham));
			
			danhSachSanPhamMua.add(spm);
			
		}
		return danhSachSanPhamMua;
	}

	public GioHang() {
		danhSachHang = new Hashtable<Integer, Integer>();
	}

	public void them(int idSanPham, int soLuongMua) {
		/*
		 * có 2 chiện xảy ra: 1. id đã có trong giỏ hàng: +1 số lượng 2. id chưa có
		 * trong giỏ hàng
		 */
		if (danhSachHang.containsKey(idSanPham)) {
			danhSachHang.replace(idSanPham, danhSachHang.get(idSanPham) + soLuongMua);
		} else {
			danhSachHang.put(idSanPham, soLuongMua);
		}
	}

	public int tinhSoMatHang() {
		return danhSachHang.size();
	}

	public double tongTien() {
		double sum = 0;
		// keyset lấy bộ khóa
		for (int idsp : danhSachHang.keySet()) {
			SanPham sp = SanPhamBL.docTheoId(idsp);
			sum += danhSachHang.get(idsp) * sp.getDonGiaKM();
		}
		return sum;
	}

	public static void main(String[] args) {
		GioHang gioHang = new GioHang();
		gioHang.them(1, 1);
		gioHang.them(2, 1);
		gioHang.them(1, 1);
		System.out.println("Số mặt hàng: " + gioHang.tinhSoMatHang());
		System.out.println("tổng tiền: " + gioHang.tongTien());
		for (int id : gioHang.danhSachHang.keySet()) {
			System.out.println("Cái mặt hàng thứ " + id + " thì có số lượng là -> " + gioHang.danhSachHang.get(id));
		}
		
		List<SanPhamMua> ds = gioHang.layDanhSachSanPhamMua();
		ds.forEach(spm->System.out.println(spm.getTenSanPham()+" - "+spm.getSoLuongMua() + " - "+spm.getDonGiaKM()+" - "+ spm.thanhTien()) );
	}
}
