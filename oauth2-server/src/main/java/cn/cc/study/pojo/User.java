package cn.cc.study.pojo;

import lombok.Data;


@Data
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String name;

    /**
     * 真名
     */
    private String realName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String phone;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 部门id
     */
    private String orgId;

}
