package com.graphql.IDentifyAuto.exception;

import java.util.Map;

public class VehicleExistsException extends AbstractGraphQLException {
    public VehicleExistsException(String message) {
            super(message);
        }

        public VehicleExistsException(String message, Map<String, Object> additionParams) {
            super(message, additionParams);
        }
}

