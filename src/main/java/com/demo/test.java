package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) throws Exception {
        List<User> users = new ArrayList<>();
        List<User> users1 = new ArrayList<>();
        users.add(new User("qw", 2,1));
        users.add(new User("qq", 3,1));
        users.add(new User("ww", 4,1));
        users.add(new User("ee", 5,2));
        users.add(new User("rr", 6,2));

        users1.add(new User("ww", 2,1));
        users1.add(new User("fd", 3,1));
        users1.add(new User("qw", 4,1));
        users1.add(new User("hh", 5,1));
        users1.add(new User("jj", 6,1));
        List<User> collect = users
                .stream()
                .filter(item -> users1
                        .stream()
                        .anyMatch(it -> {
                            if (it.status == 1) {
                                return it.name.equals(item.name);
                            } else {
                                return it.age.equals(item.age);
                            }
                        }))
                .collect(Collectors.toList());


        collect.forEach(item -> System.out.println(item.toString()));

    }


    static class User {
        String name;
        Integer age;
        Integer status;

        public User(String name, Integer age, Integer status) {
            this.name = name;
            this.age = age;
            this.status = status;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", status=" + status +
                    '}';
        }
    }
}
