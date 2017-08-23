package com.mars.test.guava;

import lombok.Data;

/**
 * Created by USER on 2017/8/23.
 */
@Data
public class IpConfig {
    private Integer id;
    private String ip;
    private Type type;
    private String remark;

    public enum Type {
        A,//allow
        D;//deny
    }

}
