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
    public static final String NAME_PATH_VARIABLE_URL  = OPENING_CURLY_BRACE + NAME_PATH_VARIABLE
            + CLOSING_CURLY_BRACE ;
    public static final String TYPE_PATH_VARIABLE = "type";
    public static final String TYPE_PATH_VARIABLE_URL  = OPENING_CURLY_BRACE
            + TYPE_PATH_VARIABLE + CLOSING_CURLY_BRACE ;
    public static final String ALL_URL = SLASH + "all";
}
