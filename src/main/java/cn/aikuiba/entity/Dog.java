package cn.aikuiba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by 蛮小满Sama at 2023/11/17 14:43
 *
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog implements Serializable {
    private Long id;

    private String name;

    private Boolean sex;
}
