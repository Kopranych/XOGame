package XOGame.modul;

import XOGame.view.Hello;

import javax.swing.*;

/**
 * Created by kopra on 16.06.2017.
 */
public class Computer implements Progressable {
    private final String name = "Компьютер";
    private FieldGame field;
    private Point point;
    private Hello hello;


    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public String getName() {
        return name;
    }

    public FieldGame getField() {
        return field;
    }

    public void setField(FieldGame field) {
        this.field = field;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void computerProgress(){
        boolean isBusy = true;

        do{
            point = point.getRandomPoint();
            if(field.fieldGame[point.getX()][point.getY()] != field.getCross()&&
                    field.fieldGame[point.getX()][point.getY()] != field.getToe()){
                field.fieldGame[point.getX()][point.getY()] = field.getToe();
                isBusy = false;
            }
        }while(isBusy);
    }

    @Override
    public Point getProgress() {
        return Point.getRandomPoint();
    }


}
