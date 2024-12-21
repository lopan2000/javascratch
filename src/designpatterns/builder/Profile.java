package designpatterns.builder;

import java.time.LocalDate;

public class Profile {

    private final String name;
    private final int age;
    private final LocalDate dob;
    private final String favoriteColor;
    private final String favoriteFood;

    private Profile(Builder builder) {
        name = builder.name;
        age = builder.age;
        dob = builder.dob;
        favoriteColor = builder.favoriteColor;
        favoriteFood = builder.favoriteFood;
    }

    /*
    Static inner classes don't require an instance of the outer class
    to be instantiated.
     */
    public static class Builder {
        //required
        private final String name;
        private final int age;
        private final LocalDate dob;
        //optional
        private String favoriteColor = "";
        private String favoriteFood = "";

        public Builder(String name, int age, LocalDate dob) {
            this.name = name;
            this.age = age;
            this.dob = dob;
        }

        public Builder favoriteColor(String val) {
            this.favoriteColor = val;
            return this;
        }

        public Builder favoriteFood(String val) {
            this.favoriteFood = val;
            return this;
        }

        public Profile build() {
            return new Profile(this);
        }
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", favoriteColor='" + favoriteColor + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }
}