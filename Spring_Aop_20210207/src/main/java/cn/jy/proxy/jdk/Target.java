package cn.jy.proxy.jdk;

public class Target implements TargetInterface{
    @Override
    public void save() {
        System.out.println("save runing..........");
    }
}
