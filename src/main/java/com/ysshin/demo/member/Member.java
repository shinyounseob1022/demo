package com.ysshin.demo.member;

import com.ysshin.demo.common.TimeStamp;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEMBER")
@Getter
@NoArgsConstructor
public class Member extends TimeStamp {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "MEMBER_ROLE")
    private RoleType role;

    @Builder
    public Member(String email, String password, RoleType role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
