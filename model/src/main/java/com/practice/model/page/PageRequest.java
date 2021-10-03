package com.practice.model.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Mark Wang
 * @date 2021/10/3
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PageRequest extends Base {

    // 当前页码
    private Integer pageIndex;

    // 每页显示数量
    private Integer pageSize;

    public Integer getOffset() {
        if (pageIndex != null && pageSize != null) {
            return pageIndex * pageSize;
        } else {
            return null;
        }
    }

    // 分页参数初始化
    public PageRequest init() {
        if (pageIndex == null || pageIndex < 1) {
            pageIndex = 1;
        }
        if (pageSize == null || pageSize < 1 || pageSize > 100) {
            pageSize = 10;
        }
        return this;
    }
}
