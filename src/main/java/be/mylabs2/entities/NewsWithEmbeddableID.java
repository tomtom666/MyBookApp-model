package be.mylabs2.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: News
 */
@Entity
public class NewsWithEmbeddableID implements Serializable {

	private static final long serialVersionUID = 1L;

	private NewsID id;

	private String content;

	public NewsWithEmbeddableID() {
		super();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@EmbeddedId
	public NewsID getId() {
		return id;
	}

	public void setId(NewsID id) {
		this.id = id;
	}
}
