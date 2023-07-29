package com.nextroom.oescape.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class HintDto {
    private static final String HINT_CODE_REGEX = "[0-9]{4}";
    private static final String PROGRESS_REGEX = "(?:[0-9]|[1-9][0-9]|100)";

    @Getter
    @RequiredArgsConstructor
    @NoArgsConstructor(force = true)
    public static class AddHintRequest {
        @NotNull(message = "테마 ID를 입력해 주세요.")
        private final Long themeId;
        @NotBlank(message = "힌트 코드를 입력해 주세요.")
        @Pattern(regexp = HINT_CODE_REGEX, message = "힌트 코드는 4자리 숫자(0~9)만 허용됩니다.")
        private final String hintCode;
        @NotBlank(message = "힌트 내용을 입력해 주세요.")
        private final String contents;
        private final String answer;
        @Min(value = 0, message = "진행률은 0 이상이어야 합니다.")
        @Max(value = 100, message = "진행률은 100 이하여야 합니다.")
        private final int progress;
    }

    @Getter
    @Builder
    public static class HintListResponse {
        private final Long id;
        private final String hintCode;
        private final String contents;
        private final String answer;
        private final Integer progress;
        private final String createdAt;
        private final String modifiedAt;
    }

    @Getter
    @RequiredArgsConstructor
    @NoArgsConstructor(force = true)
    public static class EditHintRequest {
        @NotNull(message = "힌트 ID를 입력해 주세요.")
        private final Long id;
        @Pattern(regexp = HINT_CODE_REGEX, message = "힌트 코드는 4자리 숫자(0~9)만 허용됩니다.")
        @NotBlank(message = "힌트 코드를 입력해 주세요.")
        private final String hintCode;
        @NotBlank(message = "힌트 내용을 입력해 주세요.")
        private final String contents;
        private final String answer;
        @Min(value = 0, message = "진행률은 0 이상이어야 합니다.")
        @Max(value = 100, message = "진행률은 100 이하여야 합니다.")
        private final Integer progress;
    }

    @Getter
    @NoArgsConstructor
    public static class RemoveHintRequest {
        @NotNull(message = "힌트 ID를 입력해 주세요.")
        private Long id;
    }
}