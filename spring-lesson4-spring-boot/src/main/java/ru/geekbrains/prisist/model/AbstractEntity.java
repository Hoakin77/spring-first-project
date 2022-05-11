package ru.geekbrains.prisist.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    // @Temporal(TemporalType.TIMESTAMP) // не требуется в Hibernate 5.x
    @Column(name = "timestamp_create", updatable = false)
    private Date timestampCreate;

    @UpdateTimestamp
    @Column(name = "timestamp_modify")
    private Date timestampModify;
}
