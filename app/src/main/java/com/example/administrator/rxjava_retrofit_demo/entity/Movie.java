package com.example.administrator.rxjava_retrofit_demo.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/5/18.
 */

public class Movie {
    private String title;
    private List<Subjects> subjects;

    public String getTitle() {
        return title;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public class Subjects {
        private String title, year, id ;
        private Images images;

        public Subjects(String title, String year, String id ,Images images) {
            this.title = title;
            this.year = year;
            this.id = id;
            this.images = images;
        }

        public String getTitle() {
            return title;
        }

        public String getYear() {
            return year;
        }

        public String getId() {
            return id;
        }

        public Images getImages() {return images;}

        public class Images{
            private String large;

            public Images(String large){
                this.large = large;
            }

            public String getLarge() {return large;}
        }

    }
}
