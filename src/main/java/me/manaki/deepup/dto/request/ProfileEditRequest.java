package me.manaki.deepup.dto.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class ProfileEditRequest {

    @Pattern(regexp = "^[a-z0-9_-]{5,16}$", message = "Độ dài từ 5 đến 16, không có dấu cách")
    private String nick;

    @NotBlank(message = "Mời nhập đầy đủ họ tên")
    private String fullName;

    @NotBlank(message = "Nhập email")
    @Email(message = "Phải là định dạng email")
    private String email;

    private MultipartFile avatar;

    private MultipartFile wallpaper;

    @Pattern(regexp = "^$|((?:(?:http|https):\\/\\/)?(?:www.)?facebook.com\\/(?:(?:\\w)*#!\\/)?(?:pages\\/)?(?:[?\\w\\-]*\\/)?(?:profile.php\\?id=(?=\\d.*))?([\\w\\-]*)?)",
            message = "Nhập đường Link Facebook")
    private String facebook;

    @Pattern(regexp = "^$|(^(http(s?):\\/\\/)?(www\\.)?github\\.([a-z])+\\/([A-Za-z0-9]{1,})+\\/?$)",
            message="Nhập đường Link git")
    private String github;

}
