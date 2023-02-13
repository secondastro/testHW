import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private String login1 = "victor";
    private String mail1 = "victor@mail.ru";

    @Test
    @DisplayName("when Login and Mail Passed To Constructor Then New User creates")
    public void correctCreating() {
        User user = new User(login1, mail1);
        String actualUserLogin = user.getLogin();
        assertEquals(actualUserLogin, login1);
        String actualUserMail = user.getMail();
        assertEquals(actualUserMail, mail1);
    }

    @Test
    @DisplayName("When login and mail aren't passed to constructor then user's login and password are null")
    public void correctCreatingWithNoParameters() {
        User user = new User();
        Assertions.assertNull(user.getLogin());
        Assertions.assertNull(user.getMail());
        //Здесь не совсем понял зачем нужна такая проверка, зачем создавать пользователя без параметров
        //Пришлось создать пустой конструктор, иначе идея ругается
        //Возможно нужна была проверка на пустые строки, а не на создание объекта без параметров
    }

    @Test
    @DisplayName("When passed mail contains '@' and '.' then user's mail is correct")
    public void correctMail() {
        User user = new User(login1, mail1);
        String actualMail = user.getMail();
        Assertions.assertNotNull(actualMail);
        Assertions.assertTrue(actualMail.contains("@") && actualMail.contains("."));
    }

    @Test
    @DisplayName("When passed login isn't equal passed mail then parameters are correct")
    public void notEqualsParameters(){
        User user = new User(login1, mail1);
        String actualLogin = user.getLogin();
        String actualMail = user.getMail();
        Assertions.assertNotEquals(actualLogin, actualMail);
    }
}
