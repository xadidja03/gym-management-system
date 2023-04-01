package repo.impl;
import model.Member;
import query.MemberQuery;
import repo.DbConnection;
import repo.MemberRepo;
import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
public class MemberRepoImpl extends DbConnection implements MemberRepo {
    @Override
    public boolean add_member(Member member) {
        try (Connection connect = connect()) {
            PreparedStatement preparedStatement = connect.prepareStatement(MemberQuery.ADD_MEMBER);
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getSurname());
            preparedStatement.setString(3, member.getFin());
            preparedStatement.setString(4, member.getPassport());
            preparedStatement.setDouble(5, member.getAmount());
            preparedStatement.setInt(6, member.getDeparture());
            preparedStatement.setDate(7, Date.valueOf(member.getExpiration_date()));
            int count = preparedStatement.executeUpdate();
            return count > 0;

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Member> find_member() {
        try (Connection connect = connect()) {
            PreparedStatement preparedStatement = connect.prepareStatement(MemberQuery.FIND_MEMBER);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Member> members = new LinkedList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String fin = resultSet.getString("fin");
                String passport = resultSet.getString("passport");
                int departure = resultSet.getInt("departure");
                Double amount = resultSet.getDouble("amount");
                LocalDate register_date = resultSet.getDate("register_date").toLocalDate();
                LocalDate expiration_date = resultSet.getDate("expiration_date").toLocalDate();
                LocalDate update_date = resultSet.getDate("update_date").toLocalDate();
                members.add(new Member(id, name, surname, fin, passport, departure, amount, register_date, expiration_date, update_date));
            }
            return members;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }@Override
    public boolean update_departure(String fin, int departure) {
        try (Connection connect = connect()) {
            PreparedStatement preparedStatement = connect.prepareStatement(MemberQuery.UPDATE_DEPARTURE);
            preparedStatement.setInt(1, departure);
            preparedStatement.setString(2, fin);
            int count = preparedStatement.executeUpdate();
            return count > 0;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }}
    @Override
    public boolean gym_decrement(String fin) {
        try (Connection connect = connect()) {
            PreparedStatement preparedStatement = connect.prepareStatement(MemberQuery.DECREMENT_GYM);
            preparedStatement.setString(1, fin);
            int count = preparedStatement.executeUpdate();
            return count > 0;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
