// MemoryMemberRepository.java
// 회원을 저장하는 기능 : store Map에 id와 member 저장하는 기능
// 회원의 id로 회원 찾는 기능 : Store Map에서 memberId로 조회하는 기능

package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    }

