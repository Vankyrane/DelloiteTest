package com.deloitte.deloitte.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.NotNull;

@Entity
public class ToDoItems {
	
	@Id
	private String id;
	
	@NotNull
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@NotNull
	private String userId;
	
	private boolean isDone;
	
	@Column(name = "createdOn", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdOn;

	@Column
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "ToDoItems [id=" + id + ", title=" + title + ", description=" + description + ", userId=" + userId
				+ ", isDone=" + isDone + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
	
	
}
