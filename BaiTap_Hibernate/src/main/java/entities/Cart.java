package entities;
// Generated Aug 24, 2024, 4:49:54 PM by Hibernate Tools 4.3.6.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cart generated by hbm2java
 */
@Entity
@Table(name = "cart", catalog = "bai4_minishop")
public class Cart implements java.io.Serializable {

	private CartId id;
	private Product product;
	private User user;
	private int quantity;
	private Date addedDate;

	public Cart() {
	}

	public Cart(CartId id, Product product, int quantity, Date addedDate) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.addedDate = addedDate;
	}

	public Cart(CartId id, Product product, User user, int quantity, Date addedDate) {
		this.id = id;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.addedDate = addedDate;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "cartId", column = @Column(name = "CartId", nullable = false, length = 32)),
			@AttributeOverride(name = "productId", column = @Column(name = "ProductId", nullable = false)) })
	public CartId getId() {
		return this.id;
	}

	public void setId(CartId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProductId", nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "Quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "AddedDate", nullable = false, length = 19)
	public Date getAddedDate() {
		return this.addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

}
