package com.ysshin.demo.member;

import com.ysshin.demo.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
        return memberService.signup(signupDto);
    }

    @GetMapping("/{id}")
    public ResponseDto getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }
}
