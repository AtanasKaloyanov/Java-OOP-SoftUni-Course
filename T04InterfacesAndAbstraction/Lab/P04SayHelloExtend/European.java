package T04InterfacesAndAbstraction.Lab.P04SayHelloExtend;

public class European extends BasePerson{
    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
