package repo.impl;

import model.Member;

import java.util.List;

public interface MemberRepo {
    boolean add_member(Member member);
    List<Member> find_member();
    boolean update_departure(String fin, int departure);
    boolean gym_decrement(String fin);

}
