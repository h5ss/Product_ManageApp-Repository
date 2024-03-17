package com.ssg.productapp.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;  // 가져오는 데이터 개수

    private String link;
    private String keyword;

    public int getSkip() {
        return (page - 1) * 10;     // limit 에서 사용하는 건너뛰기 (skip) 수를 위해
    }

    public String getLink() {
        if (link == null) {
            link = "page=" + this.page +
                    "&size=" + this.size;
        }
        return link;
    }


}
