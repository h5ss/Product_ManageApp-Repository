package com.ssg.productapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long pno;
    @NotEmpty
    private String pname;
    @Min(value = 0)
    @Max(value = 1000000)
    private int pprice;
    @Min(value = 0)
    @Max(value = 99999)
    private int pstock;
}
