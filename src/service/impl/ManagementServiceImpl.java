package service.impl;

import exception.InvalidOptionException;
import exception.MemberNotFound;
import service.ManagementService;
import util.MenuUtil;

import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

public class ManagementServiceImpl implements ManagementService {

    @Override
    public void management() {
        MemberServiceImpl memberService = new MemberServiceImpl();
        while (true) {
            try {
                while (true) {
                    int option = MenuUtil.entryApp();
                    switch (option) {
                        case 0 -> {
                            System.out.println("Good bye!\n");
                            System.exit(-1);
                        }
                        case 1 -> memberService.add_member();
                        case 2 -> memberService.find_member();
                        case 3 -> memberService.gym_decrement();
                        case 4 -> memberService.update_departure();
                    }
                }
            }catch (DateTimeParseException | InvalidOptionException | InputMismatchException | MemberNotFound e) {

                System.out.println(e.getMessage());
            }
        }
    }
}
