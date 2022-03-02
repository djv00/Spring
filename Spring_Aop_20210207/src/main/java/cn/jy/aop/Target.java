package cn.jy.aop;

public class Target implements TargetInterface {


    public void save() {
        System.out.println("save runing..........");
        //int i = 1 / 0;
    }


}
