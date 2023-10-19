package com.ch.car.car_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="CarInfor对象", description="")
public class CarInfor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer carId;

    private String carBrand;

    private String carModel;

    private String carDetails;

    private String carImg;

    private String carGrade;

    private Double carPrice;

    private Integer carScore;

    private Integer carInventory;

    @Version
    private Integer version;


}
