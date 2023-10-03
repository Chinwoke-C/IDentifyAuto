package com.graphql.IDentifyAuto.data.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private Long id;
    private String message;
    private boolean isSuccess;
}
