//MemberServiceImpl.java
// 1. 회원 가입 기능 : memberRepository에 member 저장하는 기능
// 2. 회원 조회 기능 : memberRepository에 memberId로 찾아서 Member 타입으로 반환하는 기능



package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
