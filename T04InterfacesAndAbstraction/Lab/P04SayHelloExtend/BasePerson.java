package T04InterfacesAndAbstraction.Lab.P04SayHelloExtend;

public abstract class BasePerson implements Person{
    private String name;
    protected BasePerson(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
