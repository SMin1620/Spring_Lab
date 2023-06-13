package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;
    @Column(name = "name", nullable = false, updatable = false)    // not null
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;

    // 기본적으로 DB와 매핑을 안하게 해주는 어노테이션 : 서버 내의 메모리 단에서만 사용하기 위함.
    @Transient
    private int temp;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    //Getter, Setter...

    public Member() {}

    public Member(Long id, String username, Integer age, RoleType roleType, Date createdDate, Date lastModifiedDate, String description) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.roleType = roleType;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.description = description;
    }
}
