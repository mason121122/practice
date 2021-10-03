package com.practice.model.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Mark Wang
 * @date 2021/10/3
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class PageResponse<T> extends Base {

    // 当前页码
    private int pageIndex;

    // 总记录数
    private int totalSize;

    // 结果集
    private List<T> list;

}
