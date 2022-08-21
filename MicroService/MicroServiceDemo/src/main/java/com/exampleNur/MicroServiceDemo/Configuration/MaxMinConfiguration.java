package com.exampleNur.MicroServiceDemo.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("firstmicroservice")
public class MaxMinConfiguration {
    public MaxMinConfiguration(){
    }
    public MaxMinConfiguration(float num1, float num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    private float num1,num2;

    public float getNum1(){
        return num1;
    }
    public void setNum1(float num1){
        this.num1 = num1;
    }
    public float getNum2(){
        return num2;
    }
    public void setNum2(float num2){
        this.num2 = num2;
    }

    public float getMaxValue(){
        return Math.max(num1,num2);
    }
    public float getMinValue(){
        return Math.min(num1,num2);

    }

}
