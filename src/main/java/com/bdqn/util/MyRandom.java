package com.bdqn.util;

import java.util.Random;
import java.util.UUID;

public class MyRandom {
    //生成随机数
    public static String UID(){
         return UUID.randomUUID().toString().replace("-", "");
    }

    //生成四位随机数
    public static String OID(){
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
            for(int i=1; i<=4-randLength; i++)
                fourRandom = "0" + fourRandom ;
        }
       return fourRandom;
    }
}
