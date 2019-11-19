package cn.cc.study.pojo;

import lombok.Data;

@Data
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 父主键
     */
    private Integer parentId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 角色别名
     */
    private String roleAlias;

    /**
     * 租户ID
     */
    private String tenantId;

}
