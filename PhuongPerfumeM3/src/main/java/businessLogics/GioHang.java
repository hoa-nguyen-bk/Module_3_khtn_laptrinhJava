package businessLogics;

import java.util.Hashtable;

import javaBeans.SanPham;

public class GioHang {
	private Hashtable<Integer, Integer> danhSachHang; // key: id sản phẩm -> từ id sản phẩm ra tất cả thông tin sản phẩm
														// luôn, value: số lượng mua

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
			sum += danhSachHang.get(idsp) + sp.getDonGiaKM();
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
	}
}
