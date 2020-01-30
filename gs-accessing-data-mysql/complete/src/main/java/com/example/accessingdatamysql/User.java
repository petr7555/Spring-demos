package com.example.accessingdatamysql;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String name;

	private String email;

	@Column(name = "deleted")
	private boolean deleted;

	@Column(name = "deleted_for_indexing")
	private Boolean deletedForIndexing;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
		if (deleted) {
			this.deletedForIndexing = true;
		} else {
			this.deletedForIndexing = null;
		}
	}

	public Boolean getDeletedForIndexing() {
		return deletedForIndexing;
	}
}
