package cn.henuer.stack;

public interface Friendly {
    void sayHello();

    void sayGoodbye();
}

class Cat implements Friendly {
    @Override
    public void sayHello() {

    }

    @Override
    public void sayGoodbye() {

    }

    public void eat() {

    }

    @Override
    protected void finalize() {

    }
}

class Dog {
    public void sayHello() {

    }

    @Override
    public String toString() {
        return "DOg";
    }
}

class CockerSpaniel extends Dog implements Friendly {

    @Override
    public void sayHello() {
        super.sayHello();
    }

    @Override
    public void sayGoodbye() {

    }

    public void count() {
       int i= count1();
    }

    public int count1() {
        return 1;
    }
}
