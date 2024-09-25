package org.kosa.hello.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User", description = "User 관련 API 입니다.")
@RestController
@RequestMapping("/api/user")
public class HelloController {

	@Operation(
	    summary = "회원가입",
	    description = "회원가입을 합니다."
    )
    @ApiResponse(
        responseCode = "200",
        description = "회원가입에 성공하였습니다."
    )
    @GetMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody @Validated UserRequest userRequest) {
        try {
            return ResponseEntity.ok().body(Map.of("result", true, "result", "회원가입 성공"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("result", false, "result", e.getMessage()));
        }
    }

	@Operation(
	    summary = "로그인",
	    description = "로그인을 합니다."
    )
    @ApiResponse(
        responseCode = "200",
        description = "로그인에 성공하였습니다."
    )
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody @Validated Map<String, Object> param) {
        try {
            return ResponseEntity.ok().body(Map.of("result", true, "result", "로그인 성공"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("result", false, "result", e.getMessage()));
        }
    }
}
