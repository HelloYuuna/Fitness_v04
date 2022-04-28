package net.scit.vo;

import java.io.Serializable;

/**
 * projectName     :Fitness_v04
 * fileName        :FitnessVO
 * author          :yuuna
 * since           :2022/04/27
 */
public class FitnessVO implements Serializable {
    /**
     * default ID
     */
    private static final long serialVersionUID = 1L;

    private String usrId;
    private String usrName;
    private double height;
    private double weight;

    private double bmi;
    private String result;

    public FitnessVO(String usrId, String usrName, double height, double weight){
        this.usrId = usrId;
        this.usrName = usrName;
        this.height = height;
        this.weight = weight;

        calcBmi();
    }

    private void calcBmi(){
        double tmp;
        tmp = (height * 0.01);
        bmi = weight/(tmp * tmp);

        setResult();
    }

    private void setResult(){
        if(bmi > 35){result = "고도비만";}
        else if (bmi > 30){result = "중도비만";}
        else if (bmi > 25){result = "경도비만";}
        else if (bmi > 23){result = "과체중";}
        else if (bmi > 18.5){result = "정상";}
        else {result = "저체중";}
    }

    public void setUsrId(String usrId){
        this.usrId = usrId;
    }

    public String getUsrId(){
        return usrId;
    }

    public void setUsrName(String usrName){
        this.usrName = usrName;
    }

    public String getUsrName(){
        return usrName;
    }

    public void setHeight(double height){
        this.height = height;
        calcBmi();
    }

    public double getHeight(double height){
        return height;
    }

    public void setWeight(double weight){
        this.weight = weight;
        calcBmi();
    }

    public double getWeight(double weight){
        return weight;
    }

    @Override
    public String toString() {
        String tmp = String.format("이름:%s 아이디:%s 키:%.1f 몸무게:%.1f bmi:%.2f (%3s)", usrName, usrId, height, weight, bmi, result);
        return tmp;
//		return "이름: " + usrName + "아이디:" + usrId + " 키:" + height + " 몸무게:" + weight + " BMI:" + bmi + " " + result;
    }
}

