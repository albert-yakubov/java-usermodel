package com.lambdaschool.usermodel.models;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
//listens to these fields.
@EntityListeners(AuditingEntityListener.class)
abstract public class Auditable {
        //add these field to all classes by extending model classes to this class
    @CreatedBy
    protected String createdby;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP) // gives you time stamp of changes
    protected Date createddate;
    @LastModifiedBy
    protected String lastmodifiedby;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastmodifieddate;
}
