package com.ysshin.demo.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member signup(SignupDto signupDto) {

        Member member = memberRepository.findByEmail(signupDto.getEmail()).orElse(null);

        if (member != null) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        member = Member.builder()
                .email(signupDto.getEmail())
                .password(passwordEncoder.encode(signupDto.getPassword()))
                .role(RoleType.USER)
                .build();
        memberRepository.save(member);

        return member;
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));
    }

}
