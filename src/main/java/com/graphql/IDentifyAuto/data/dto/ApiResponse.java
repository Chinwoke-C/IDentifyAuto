package com.graphql.IDentifyAuto.data.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String vin;
    private String message;
    private boolean isSuccess;
}
