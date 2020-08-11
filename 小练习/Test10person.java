public class Test10person {
    String name;
    int age;
    String sex;

    public void study(){
        System.out.println("studying");
    }

    /*public void showage(int age){
        System.out.println("age = " + age);    //就近原则：这里的age调用的是形参
    }
    */
    public void showage() {
        System.out.println("age = " + age);
    }

    public int addage(int a){
        age = age + a;
        return age;
    }
}
