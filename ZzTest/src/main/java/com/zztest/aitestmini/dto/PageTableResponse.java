package com.zztest.aitestmini.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhangcheng
 * @Description: 分页响应对象
 * @Date: 2021/3/24/024 15:13
 * @Version: 1.0
 */
@Data
public class PageTableResponse<T>  implements Serializable {

    private static final long serialVersionUID = 620421858510718076L;

    private Integer recordsTotal;
    private List<T> data;

}
