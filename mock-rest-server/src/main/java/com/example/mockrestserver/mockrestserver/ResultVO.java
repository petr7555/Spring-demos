package com.example.mockrestserver.mockrestserver;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Petr Janik petr.janik@mavenir.com
 * @since 11/09/2019
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    @JsonProperty("class")
    private String clazz;
    private String instance;
    private String code;
    private String originator_timestamp_utc_millis;
}
