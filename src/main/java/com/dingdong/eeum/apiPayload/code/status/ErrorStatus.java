package com.dingdong.eeum.apiPayload.code.status;

import com.dingdong.eeum.apiPayload.code.dto.ErrorReasonDTO;
import com.dingdong.eeum.apiPayload.code.base.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // Map Error
    MAP_COORDINATES_INVALID(HttpStatus.BAD_REQUEST, "MAP400_1", "유효하지 않은 좌표 범위입니다."),
    MAP_RADIUS_INVALID(HttpStatus.BAD_REQUEST, "MAP400_2", "유효하지 않은 반경 범위입니다."),

    // Place Error
    PLACE_NOT_FOUND(HttpStatus.NOT_FOUND, "PLACE404_1", "존재하지 않는 장소입니다."),
    PLACE_INVALID_CATEGORY(HttpStatus.BAD_REQUEST, "PLACE400_1", "유효하지 않은 카테고리입니다."),
    PLACE_INVALID_STATUS(HttpStatus.BAD_REQUEST, "PLACE400_2", "유효하지 않은 상태값입니다."),
    PLACE_SEARCH_KEYWORD_EMPTY(HttpStatus.BAD_REQUEST, "PLACE400_3", "검색어를 입력해주세요."),
    PLACE_COORDINATES_REQUIRED(HttpStatus.BAD_REQUEST, "PLACE400_4", "위치 정보(경도, 위도)가 필요합니다."),
    PLACE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "PLACE403_1", "해당 장소에 접근 권한이 없습니다."),
    PLACE_ALREADY_EXISTS(HttpStatus.CONFLICT, "PLACE409_1", "이미 존재하는 장소입니다."),
    PLACE_REVIEW_NOT_ALLOWED(HttpStatus.BAD_REQUEST, "PLACE400_5", "해당 장소에 리뷰를 작성할 권한이 없습니다."),
    PLACE_SEARCH_NAME_EMPTY(HttpStatus.BAD_REQUEST, "PLACE400_6", "해당 장소 이름이 없습니다."),
    INVALID_SEARCH_MODE(HttpStatus.BAD_REQUEST, "PLACE400_6", "유효하지 않은 검색 모드입니다."),
    INVALID_PARAMETERS(HttpStatus.BAD_REQUEST, "PLACE400_7", "검색에 필요한 필수 파라미터가 누락되었습니다."),

    // Review Error
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW404_1", "존재하지 않는 리뷰입니다."),
    REVIEW_CONTENT_REQUIRED(HttpStatus.BAD_REQUEST, "REVIEW400_1", "리뷰 내용은 필수입니다."),
    REVIEW_CONTENT_TOO_LONG(HttpStatus.BAD_REQUEST, "REVIEW400_2", "리뷰 내용은 500자 이내로 작성해주세요."),
    REVIEW_RATING_INVALID(HttpStatus.BAD_REQUEST, "REVIEW400_3", "평점은 1-5 사이의 값이어야 합니다."),
    REVIEW_QUESTION_ID_INVALID(HttpStatus.BAD_REQUEST, "REVIEW400_4", "유효하지 않은 질문 ID입니다."),
    REVIEW_RATINGS_REQUIRED(HttpStatus.BAD_REQUEST, "REVIEW400_5", "최소 하나 이상의 평점이 필요합니다."),
    REVIEW_ACCESS_DENIED(HttpStatus.FORBIDDEN, "REVIEW403_1", "해당 리뷰에 접근 권한이 없습니다."),
    REVIEW_ALREADY_EXISTS(HttpStatus.CONFLICT, "REVIEW409_1", "이미 리뷰를 작성한 장소입니다."),
    REVIEW_MODIFY_NOT_ALLOWED(HttpStatus.FORBIDDEN, "REVIEW403_2", "리뷰를 수정할 권한이 없습니다."),
    REVIEW_DELETE_NOT_ALLOWED(HttpStatus.FORBIDDEN, "REVIEW403_3", "리뷰를 삭제할 권한이 없습니다."),

    // QUESTION Error
    QUESTION_NOT_FOUND(HttpStatus.NOT_FOUND, "QUESTION404_1", "존재하지 않는 질문입니다."),

    // IMAGE Error
    IMAGE_COUNT_EXCEEDED(HttpStatus.BAD_REQUEST, "IMAGE_001", "이미지는 최대 5개까지 업로드할 수 있습니다."),
    IMAGE_FORMAT_NOT_SUPPORTED(HttpStatus.BAD_REQUEST, "IMAGE_002", "지원되지 않는 이미지 형식입니다."),
    IMAGE_SIZE_EXCEEDED(HttpStatus.BAD_REQUEST, "IMAGE_003", "이미지 크기가 너무 큽니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
