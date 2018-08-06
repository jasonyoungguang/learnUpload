package com.swj.api.demo.entity;

import com.swj.basic.annotation.Column;
import com.swj.basic.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Table("Demo")
public class DemoDO implements Serializable {

    @Column(isPK = true)
    private String id;

    private String username;

    private String name;

    private String password;

    private String description;

}
