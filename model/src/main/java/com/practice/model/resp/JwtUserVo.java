package com.practice.model.resp;

import lombok.Data;

/**
 * @author Mark Wang
 * @date 2021/10/17
 */
@Data
public class JwtUserVo {
    private Integer id;
    private String userName;
    private String token;
}
