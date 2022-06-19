//MemberService.java
// 1. 회원가입 기능
// 2. 회원조회 기능
package hello.core.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
