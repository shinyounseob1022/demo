package com.ysshin.demo.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Map<String, Object> signup(SignupDto signupDto) {

        Map<String, Object> resultMap = new HashMap<>();

        Member member = memberRepository.findByEmail(signupDto.getEmail()).orElse(null);

        if (member != null) {
            resultMap.put("회원 가입 실패, 이미 존재하는 이메일입니다.", null);
            return resultMap;
        }

        member = Member.builder()
                .email(signupDto.getEmail())
                .password(passwordEncoder.encode(signupDto.getPassword()))
                .role(RoleType.USER)
                .build();
        memberRepository.save(member);

        resultMap.put("회원 가입 성공.", member);
        return resultMap;

    }

    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
    }

}
