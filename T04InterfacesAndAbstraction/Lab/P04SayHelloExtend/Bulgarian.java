package T04InterfacesAndAbstraction.Lab.P04SayHelloExtend;

public class Bulgarian extends BasePerson{
    protected Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Zdr";
    }
}
