package com.xiang.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("annotationUser")
public class AnnotationUser {
    private String username;
    private Integer password;
}