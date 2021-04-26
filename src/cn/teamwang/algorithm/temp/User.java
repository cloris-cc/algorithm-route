package cn.teamwang.algorithm.temp;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class User {
    String name;
    Integer age;


    public User(String name, Integer age) {
        this.name= name;
        this.age = age;
    }

    public User(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
