package br.com.detec.sysjob.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "product_ratting")
public class ProductRatting {

	public ProductRatting() {
		super();
	}

	@EmbeddedId
	private ProductRattingEntityPK pk;

	@Column(nullable = false)
	private Integer score;

	private String comment;

	public ProductRattingEntityPK getPk() {
		return pk;
	}

	public void setPk(ProductRattingEntityPK pk) {
		this.pk = pk;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
