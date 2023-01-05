package com.wzl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author weiZhiLin
 * @version 1.0
 * @date 2023/1/4 16:56
 */
@Data
@AllArgsConstructor
@Builder
public class BookVO {
    private String fullName;
    private String simpleName;
    private String middleName;
}
