package cn.cc.study.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;


/**
 * 
 * @模块名:oauth2-server
 * @包名:cn.cc.study.pojo
 * @类名称: BaseEntity
 * @类描述:【类描述】基础实体类
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午2:55:57
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 状态[0:未删除,1:删除]
     */
    private Integer isDeleted = 0;

    /**
     * 创建人
     */
    private Integer createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime dateCreated;

    /**
     * 更新人
     */
    private Integer updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime dateUpdated;

    /**
     * 备注
     */
    private String remark;

}
