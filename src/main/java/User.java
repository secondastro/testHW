import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String login;
    private String mail;

    public User(String login, String mail) {
        validMail(mail);
        this.login = login;
        this.mail = mail;
    }

    private void validMail (String mail) {
        if (mail == null) {
            throw new IllegalArgumentException("строка ничего не содержит");
        }
        if (mail.isBlank() || mail.isEmpty()) {
            throw new IllegalArgumentException("пустая строка");
        }
        if (!mail.contains("@") || !mail.contains(".")) {
            throw new IllegalArgumentException("email не валидный");
        }
    }
}


