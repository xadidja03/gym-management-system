package model;

import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
@Builder
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member {
    int id;
    String name;
    String surname;
    String fin;
    String passport;
    int departure;
    double amount;
    LocalDate register_date;
    LocalDate expiration_date;
    LocalDate update_date;

}
