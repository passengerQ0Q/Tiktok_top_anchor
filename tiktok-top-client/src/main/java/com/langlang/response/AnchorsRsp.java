package com.langlang.response;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AnchorsRsp implements Serializable {
//    @ApiModelProperty("主播名称")
    private String userName;
//    @ApiModelProperty("性别")
    private String gender;
//    @ApiModelProperty("主播名称")
    private String accountTags;
//    @ApiModelProperty("粉丝量级")
    private String followersCount;
    // 更新时间
    private Date updatedAt;

    private Integer phone;
}
