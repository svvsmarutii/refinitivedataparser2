package com.leftlane.refinitivdataparser.repository.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "CROSS_REFERENCE_CODES", schema = "reference_data")
@Subselect("select * from reference_data.CROSS_REFERENCE_CODES")
public class CrossRefCodes {
    @Id
    @Column(name = "CROSS_REF_TYPE_ID")
    private Integer crossRefTypeId;

    @Column(name = "CROSS_REF_TYPE_NAME")
    private String crossRefTypeName;

    @Column(name = "DEFINITION")
    private String definition;

    @Column(name = "XPATH")
    private String xpath;

    @Column(name = "CREATE_TIMESTAMP")
    private Date createTimestamp;

    @Column(name = "UPDATE_TIMESTAMP")
    private Date updateTimestamp;

    @Column(name = "STATUS")
    private Boolean status;
}