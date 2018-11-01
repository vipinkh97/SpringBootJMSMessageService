package io.vipin.dtc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Email {
	
	@Id
	@Column
	private String id;
	@Column
	 private String to;
	@Column
	 private String body;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Email(String id, String to, String body) {
		super();
		this.id = id;
		this.to = to;
		this.body = body;
	}
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Email [id=" + id + ", to=" + to + ", body=" + body + "]";
	}
	 
	

}
