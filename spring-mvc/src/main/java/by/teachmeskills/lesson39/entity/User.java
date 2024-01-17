package by.teachmeskills.lesson39.entity;

import by.teachmeskills.lesson39.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
@NamedQueries(
        {
                @NamedQuery(name = "User.selectAll", query = "select user from User user"),
                @NamedQuery(name = "User.selectMaxId", query = "select max(user.id) from User user")
        }
)
@NamedNativeQueries(
        {
                @NamedNativeQuery(name = "User.selectOne", query = "select * from users limit 1"),
        }
)
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id = UUID.randomUUID();

//    @EmbeddedId
//    private UserId userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "login", unique = true)
    private String login; //should be unique

    @Transient
    private String password;

//    @Enumerated(EnumType.STRING)
//    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    private Authority authority;

    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true, mappedBy = "user")//(fetch = FetchType.EAGER)
    private List<Phone> phones = new ArrayList<>();

//    @CreationTimestamp
//    @UpdateTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    private boolean deletable = false;

    public User(UserDto userDto) {
        this.userName = userDto.getUserName();
        this.login = userDto.getLogin();
        this.password = userDto.getPassword();
        this.authority = new Authority(userDto.getRole().name(), "");
    }

    public User update(UserDto userDto) {
        this.setUserName(userDto.getUserName());
        this.setLogin(userDto.getLogin());
        this.setPassword(userDto.getPassword());
        this.setAuthority(new Authority(userDto.getRole().name(), ""));
        return this;
    }
}
