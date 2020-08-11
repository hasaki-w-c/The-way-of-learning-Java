public class Test09tea {
    String name;
    int age;
    String major;
    String interests;

    public static void say() {

        Test09tea tea = new Test09tea();
        //修改数据
        tea.name = "王琛";
        tea.age = 20;
        tea.major = "计算机";
        tea.interests = "LOL";

        System.out.println("输出教师的个人信息");
        System.out.println("name: " + tea.name);
        System.out.println("age: " + tea.age);
        System.out.println("major: " + tea.major);
        System.out.println("interests: " + tea.interests);

    }
}
