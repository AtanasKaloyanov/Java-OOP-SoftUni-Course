package T07ReflectionAndAnnotation.Lab.Demos.Reflection;


 public class RefExample extends RefFather implements RefInt1, RefInt2 {
    public String publicField;
    private String name;
    private String secondName;
    private int age;

    public RefExample() {}

     public RefExample(String name, String secondName, int age) {
         this(secondName, age);
         this.name = name;
     }

     private RefExample(String secondName, int age) {
         this(secondName);
         this.age = age;
     }

     private RefExample(String secondName) {
         this.secondName = secondName;
     }

     public void do1() {

     }

     public void do2() {

     }

     private void do3() {

     }

     public String do4(String text) {
        return "b";
     }

     @Override
     public String toString() {
         return this.name + " " + this.secondName + " " + this.age;
     }
}
