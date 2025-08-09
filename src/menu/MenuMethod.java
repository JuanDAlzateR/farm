package menu;

import interfaces.Run;

public class MenuMethod implements Run{
    private String option;
    private Run method;

    public MenuMethod(){
        this.option ="New option";
        SimpleMethod simpleMethod = new SimpleMethod();
        this.method = simpleMethod;
    }

    public MenuMethod(String option){
        this.option =option;
        SimpleMethod simpleMethod = new SimpleMethod();
        this.method = simpleMethod;
    }

    public MenuMethod(String option,Run method){
        this.option =option;
        this.method = method;
    }

    public String getOption() {
        return option;
    }
    public Run getMethod() {
        return method;
    }

    public void setOption(String option) {
        this.option=option;
    }
    public void setMethod(Run method) {
        this.method = method;
    }

    @Override
    public void run(Object... args){
        this.method.run(args);
    }

    public static ExitMethod exitMethod(){
        ExitMethod exitMethod = new ExitMethod();
        return exitMethod;
    }
    public static SimpleMethod simpleMethod(){
        SimpleMethod simpleMethod = new SimpleMethod();
        return simpleMethod;
    }

}

class SimpleMethod implements Run {
    @Override
    public void run(Object... args){
        System.out.println("Running simple Method");
    }
}
class ExitMethod implements Run {
    @Override
    public void run(Object... args){
        System.out.println("Good bye");
        System.exit(0);
    }
}