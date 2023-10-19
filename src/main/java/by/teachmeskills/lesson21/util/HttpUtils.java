package by.teachmeskills.lesson21.util;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpUtils {

//    public static Map<String, String> parseUriQueryParams(String queryParam) {
//        Map<String, String> paramMap = new HashMap<>();
//        String[] params = queryParam.split("&");
//        for (String param : params) {
//            String[] split = param.split("=");
//            String paramName = split[0];
//            String paramValue = split[1];
//            paramMap.put(paramName, paramValue);
//        }
//        return paramMap;
//    }

    public static Map<String, String> parseUriQueryParams(String queryParam) {
        return Arrays.stream(queryParam.split("&"))
                .map(str -> str.split("="))
                .collect(Collectors.toMap(it -> it[0], it -> it[1], (a, b) -> b));
    }
}
