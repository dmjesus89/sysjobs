package br.com.detec.sysjob.entity;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RatingDTO {

	public RatingDTO() {
		super();
	}

	@Min(0)
	@Max(5)
	private Long score;

	@Size(max = 255)
	private String comment;


	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	

}
