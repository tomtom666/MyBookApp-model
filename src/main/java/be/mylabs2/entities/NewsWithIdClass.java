package be.mylabs2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Entity implementation class for Entity: NewsWithIdClass
 */
@Entity
@IdClass(value = NewIDClass.class)
public class NewsWithIdClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private String lang;

	private String title;

	private String content;

	public NewsWithIdClass() {
		super();
	}

	@Id
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Id
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
