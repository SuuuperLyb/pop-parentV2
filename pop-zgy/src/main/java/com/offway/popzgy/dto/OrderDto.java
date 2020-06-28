package com.offway.popzgy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String oNum;
    private int oType;
    private Date oCreateTime;
}
