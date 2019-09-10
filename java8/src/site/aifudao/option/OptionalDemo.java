package site.aifudao.option;

import site.aifudao.model.User;

import java.util.Optional;

/**
 * optional 测试
 *
 * @author shenjg
 * @date 2019/09/10
 **/
public class OptionalDemo {
    public static void main(String[] args) {
        User user = getUser(null);
        System.out.println(user);

        User user1 = getUser(new User("admin", "11" ));
        System.out.println(user1);

    }

    public static User getUser(User user) {
        Optional<User> opt = Optional.ofNullable(user);
        opt.ifPresent(item -> {
            System.out.println(item.getAge());
        });

        return opt.isPresent() ? opt.get():null;
    }
}
