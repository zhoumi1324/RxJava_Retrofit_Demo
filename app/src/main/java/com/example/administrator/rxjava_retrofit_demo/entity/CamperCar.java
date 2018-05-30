package com.example.administrator.rxjava_retrofit_demo.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/5/19.
 */

public class CamperCar {

    public int res_code;
    public String res_msg;
    public List<Camper> data;

    public class Camper{
        public String MotorHomesLeaseTitle ;//": "宇通依维柯房车",
        public String PlateNumber ;//": "湘A7KL52",
    }
}
