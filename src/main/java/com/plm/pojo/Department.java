package com.plm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// getter/setter/equals/toString等方法
@Data
// 由参构造函数
@AllArgsConstructor
// 无参构造函数
@NoArgsConstructor
public class Department {

    private Integer id;
    private String deparmentName;
}
