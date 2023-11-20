package com.testproj.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long uid;
    @NotEmpty(message = "아이디는 필수입력.")
    @Size(min = 3, message = "아이디 길이는 최소 3자.")
    private String username;
    @NotEmpty(message = "닉네임은 필수입력.")
    @Size(min = 3, message = "닉네임 길이는 최소 3자.")
    private String nickname;
    @JsonIgnore
    @NotEmpty(message = "비밀번호는 필수입력.")
    @Size(min = 8, message = "비밀번호 길이는 최소 8자.")
    private String password;
    @ToString.Exclude
    @JsonIgnore
    @NotEmpty(message = "비밀번호확인은 필수입력.")
    private String repassword;
    @NotEmpty(message = "핸드폰번호 필수입력.")
    private String phonenumber;
    @NotEmpty(message = "이메일 필수입력.")
    @Email(message = "이메일 형식이 맞지않습니다.")
    private String email;
    @NotEmpty(message = "성별 필수입력.")
    private String gender;
    @JsonIgnore
    private LocalDateTime regDate;


}
