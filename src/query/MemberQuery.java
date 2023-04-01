package query;

public class MemberQuery {
    public static String ADD_MEMBER="INSERT INTO member (name,surname,fin,passport,amount,departure,expiration_date,register_date,update_date)" + " VALUES (?,?,?,?,?,?,?,now(),now())";
    public static final String FIND_MEMBER="SELECT* from member";
    public static final String DECREMENT_GYM="UPDATE member set departure=departure-1 WHERE fin=?";
    public static final String UPDATE_DEPARTURE ="UPDATE member SET departure=departure+?, update_date= now() where fin=?";

    }

