package com.gyt.fittrainer;

import lombok.*;

import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/03/25 16:06
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyResult {
    private int code;
    private String message;
    private List<?> list;
    private Object object;
    private String token;

}
