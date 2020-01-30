package com.example.mockrestserver.mockrestserver;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Petr Janik 485122
 * @since 11/09/2019
 */
@Getter
@Setter
@NoArgsConstructor
public class HTMessageResultVO extends ResultVO{
    private List<HTMessageVO> data;

//    @Builder
//    public HTMessageResultVO(String clazz, String instance, String code, String originator_timestamp_utc_millis, List<HTMessageVO> data) {
//        super(clazz, instance, code, originator_timestamp_utc_millis);
//        this.data = data;
//    }
}
