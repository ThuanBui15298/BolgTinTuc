package me.manaki.deepup.dto.request;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Data
public class RegisterRequest {

    @Pattern(regexp = "^[a-z0-9_-]{5,16}$", message = "Độ dài từ 5 đến 16, không có dấu cách")
    private String username;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[a-zA-Z]).{8,}$", message="Độ dài hơn 8, ít nhất 1 chữ số")
    private String password;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[a-zA-Z]).{8,}$", message = "Nhập lại mật khẩu")
    private String repeatPassword;

    @NotBlank(message = "Không được để trống họ tên")
    private String fullName;

    @NotBlank(message = "Email bắt buộc")
    @Email(message = "email không đúng")
    private String email;

    @AssertTrue(message = "Mật khẩu nhập không đúng!")
    private boolean isValidPassword() {
        return Objects.nonNull(password) && password.equals(repeatPassword);
    }

}
