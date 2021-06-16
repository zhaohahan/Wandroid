package com.mr.tengyu.wandroid.data.entity;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Bean {

    @Id(autoincrement = true)
    private Long id;
    @Property
    @NotNull
    private String name;
    @Generated(hash = 722830244)
    public Bean(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 80546095)
    public Bean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}