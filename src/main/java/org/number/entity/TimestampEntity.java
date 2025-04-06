package org.number.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.TimeZone;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimestampEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@CreatedDate
	@Column(name = "create_date", insertable = true, updatable = false)
	@JsonFormat(timezone = "GMT+1", pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createDate;

	@LastModifiedDate
	@Column(name = "update_date", nullable = true)
	@JsonFormat(timezone = "GMT+1", pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateDate;

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	@PrePersist
	void onPrePersist() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
		this.setCreateDate(LocalDateTime.now());
		this.setUpdateDate(null);
	}

	@PreUpdate
	void onPreUpdate() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
		this.setUpdateDate(LocalDateTime.now());
	}

}
