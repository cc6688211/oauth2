package cn.cc.study.pojo;

import lombok.Data;

@Data
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 菜单父主键
     */
    private Integer parentId;

    /**
     * 菜单编号
     */
    private String code;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单别名
     */
    private String alias;

    /**
     * 请求地址
     */
    private String path;

    /**
     * 菜单资源
     */
    private String source;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 菜单类型
     */
    private Integer category;

    /**
     * 操作按钮类型
     */
    private Integer action;

    /**
     * 是否打开新页面
     */
    private Integer isOpen;

}
