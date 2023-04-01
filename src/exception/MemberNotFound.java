package exception;

import enums.ExceptionEnum;

public class MemberNotFound extends RuntimeException {
    public MemberNotFound() {
        super(ExceptionEnum.MEMBER_NOT_FOUND.name());
    }

}
