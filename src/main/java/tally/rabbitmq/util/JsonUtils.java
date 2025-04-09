package tally.rabbitmq.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 객체를 JSON 문자열로 변환하고 그 반대 작업을 수행하는 유틸리티 클래스
 */
public class JsonUtils {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 객체를 JSON 문자열로 변환합니다.
     *
     * @param object 변환할 객체
     * @return JSON 문자열. 변환 실패 시 null 반환
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("Failed to convert object to JSON: {}", e.getMessage(), e);
            return null;
        }
    }

    /**
     * JSON 문자열을 지정된 클래스 타입의 객체로 변환합니다.
     *
     * @param json JSON 문자열
     * @param clazz 변환할 객체 타입의 클래스
     * @param <T> 변환할 객체 타입
     * @return 변환된 객체. 변환 실패 시 null 반환
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            logger.error("Failed to convert JSON to object: {}", e.getMessage(), e);
            return null;
        }
    }
}