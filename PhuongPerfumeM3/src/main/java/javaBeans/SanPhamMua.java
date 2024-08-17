package javaBeans;

// chỉ là sản phẩm mà có thêm cột số lượng mua
public class SanPhamMua extends SanPham {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int soLuongMua;

	public SanPhamMua() {
		super();
	}

	public int getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public double thanhTien() {
		return soLuongMua * getDonGiaKM();
	}
}
