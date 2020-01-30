package com.example.demo.entitites;

import com.example.demo.entitites.PingLogEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String name;
    @OneToMany
    List<PingLogEntity> pingLogList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PingLogEntity> getPingLogList() {
        return pingLogList;
    }

    public void setPingLogList(List<PingLogEntity> pingLogList) {
        this.pingLogList = pingLogList;
    }
}
