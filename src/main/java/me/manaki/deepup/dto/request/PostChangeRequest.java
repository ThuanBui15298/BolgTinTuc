package me.manaki.deepup.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PostChangeRequest {

    private Integer id;

    @Min(value = 0, message = "Mời chọn chủ đề ")
    private Integer topicId;

    @NotBlank(message = "Tiêu đề không được để chống")
    private String title;

    @NotBlank(message = "Mời nhập mô tả")
    private String subtitle;

    @NotBlank(message = "Nội dung không được để trống")
    private String content;

    private MultipartFile image;

}
