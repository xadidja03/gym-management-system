package service.impl;
import model.Member;
import repo.MemberRepo;
import repo.impl.MemberRepoImpl;
import service.MemberService;
import util.InputUtil;
import java.time.LocalDate;
import java.util.List;

public class MemberServiceImpl implements MemberService {
    private final MemberRepo memberRepo;
    public MemberServiceImpl() {
        memberRepo = new MemberRepoImpl();
    }public Member fillMember() {
        String name = InputUtil.inputRequiredString("Enter the name: ");
        String surname = InputUtil.inputRequiredString("Enter the surname: ");
        String fin = InputUtil.inputRequiredString("Enter the fin: ");
        String passport = InputUtil.inputRequiredString("Enter the passport: ");
        int departure= InputUtil.inputRequiredInteger("Enter the departure: ");
        Double amount=InputUtil.inputRequiredDouble("Enter the amount:");
        LocalDate expiration_date= LocalDate.parse(InputUtil.inputRequiredString("Enter the expiration_date:"));
        System.out.println("Member successfully created!");
        return Member.builder()
                .name(name)
                .surname(surname)
                .fin(fin)
                .passport(passport)
                .departure(departure)
                .amount(amount)
                .expiration_date(expiration_date)
                .build();

    }
    @Override
    public void add_member() {
        memberRepo.add_member(fillMember());



    }

    @Override
    public void find_member() {
        List<Member>members=memberRepo.find_member();
        members.forEach(System.out::println);


    }

    @Override
    public void update_departure() {
        String fin = InputUtil.inputRequiredString("Enter the fin:");
        int departure = InputUtil.inputRequiredInteger("Enter the departure:");
        memberRepo.update_departure(fin,departure);
        memberRepo.find_member()
                .stream()
                .filter(member -> member.getFin().equals(fin))
                .forEach(member -> System.out.println(member.getName() + " " + member.getSurname() + " Member successfully updated!"));

    }


    @Override
    public void gym_decrement() {
        String fin = InputUtil.inputRequiredString("Enter the fin:");
        memberRepo.gym_decrement(fin);
        memberRepo.find_member()
                .stream()
                .filter(member -> member.getFin().equals(fin))
                .forEach(member -> {
                    if (member.getDeparture() == 0) {
                        System.out.println("Dear member, you are Rejected!");
                    } else {
                        System.out.println("Dear member, your remained departures are: " + member.getDeparture());
                    }
                });

    }
}
