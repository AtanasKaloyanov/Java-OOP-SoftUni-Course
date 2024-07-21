package T04InterfacesAndAbstraction.Lab.P04SayHelloExtend;

public class Chinese extends BasePerson{
    protected Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
