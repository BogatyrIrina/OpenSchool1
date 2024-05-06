package com.example.openschool1.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.example.openschool1.constant.SymbolConstant.CLOSING_CURLY_BRACE;
import static com.example.openschool1.constant.SymbolConstant.OPENING_CURLY_BRACE;
import static com.example.openschool1.constant.SymbolConstant.SLASH;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UrlConstant {
    public static final String PLANTS_URL = SLASH + "plants";
    public static final String NAME_PATH_VARIABLE = "name";
    public static final String NAME_URL = SLASH + NAME_PATH_VARIABLE;
    public static final String TYPE_PATH_VARIABLE = "type";
    public static final String TYPE_URL = SLASH + TYPE_PATH_VARIABLE;
    public static final String ALL_URL = SLASH + "all";
    public static final String EXECUTION_TIME_URL = SLASH + "execution_time";
    public static final String CLASS_NAME_PATH_VARIABLE = "className";
    public static final String METHOD_NAME_PATH_VARIABLE = "methodName";
    public static final String CLASS_NAME_PATH_VARIABLE_URL =
            SLASH + OPENING_CURLY_BRACE + CLASS_NAME_PATH_VARIABLE + CLOSING_CURLY_BRACE;
    public static final String METHOD_NAME_PATH_VARIABLE_URL =
            SLASH + OPENING_CURLY_BRACE + METHOD_NAME_PATH_VARIABLE + CLOSING_CURLY_BRACE;
    public static final String AVERAGE_URL = SLASH + "average";
    public static final String TOTAL_URL = SLASH + "total";
}

