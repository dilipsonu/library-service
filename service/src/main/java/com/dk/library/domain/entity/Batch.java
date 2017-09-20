package com.dk.library.domain.entity;

import com.dk.library.domain.enums.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@javax.persistence.Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table (name = "batch")
public class Batch {

    @NotNull
    @Id
    @GeneratedValue (generator = "uuid")
    @GenericGenerator (name = "uuid", strategy = "uuid2")
    @Type (type = "uuid-char")
    @Column (columnDefinition = "VARCHAR(36)", name = "id",nullable=false,
             updatable=false)
    private UUID id;

    @Column (name = "last_modified_user",nullable=false)
    private String lastModifiedUser;

    @Column (name = "last_modified_dtm", columnDefinition = "timestamp",nullable=false)
    private Date lastModifiedDateTime;

    @Version
    private Long version;

    @Column (name = "status",nullable=false)
    private String status;

    @Column (name = "start_dtm", columnDefinition = "timestamp",
             nullable=false,updatable=false)
    private Date startDateTime;

    @Column (name = "end_dtm")
    private Date endDateTime;



    @PrePersist
    protected void onCreate() {
        startDateTime = new Date();
        lastModifiedDateTime = new Date();
        status = StatusCode.PENDING.getStatusCode();
        lastModifiedUser = "RS-PUBLISHER";
        endDateTime = null;
    }

    @PreUpdate
    protected void onUpdate() {
        lastModifiedDateTime = new Date();
    }


}
