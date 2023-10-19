package com.ch.car.car_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author chen
 * @since 2023-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CUser对象", description="")
public class CUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String userName;

    private String userPwd;

    private String userPhone;

    private String userEmail;

    private Integer userGrade;

    private Date userResTime;

    @Version
    private Integer version;


}
