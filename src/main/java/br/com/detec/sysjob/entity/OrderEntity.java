package br.com.detec.sysjob.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "orders")
public class OrderEntity {

	public OrderEntity() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private UserEntity userBuyer;

	@OneToOne
	private OrderStatusEntity orderStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUserBuyer() {
		return userBuyer;
	}

	public void setUserBuyer(UserEntity userBuyer) {
		this.userBuyer = userBuyer;
	}

	public OrderStatusEntity getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusEntity orderStatus) {
		this.orderStatus = orderStatus;
	}

}
