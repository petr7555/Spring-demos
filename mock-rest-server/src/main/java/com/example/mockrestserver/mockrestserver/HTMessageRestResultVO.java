package com.example.mockrestserver.mockrestserver;

import lombok.*;

import java.util.List;

/**
 * @author Petr Janik petr.janik@mavenir.com
 * @since 11/09/2019
 */
@Getter
@Setter
@NoArgsConstructor
public class HTMessageRestResultVO {
    private List<HTMessageResultVO> results;
}
