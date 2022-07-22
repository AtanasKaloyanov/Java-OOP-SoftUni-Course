package T04InterfacesAndAbstraction.Lab.P02CarShopExtend;

public interface Rentable extends Car{
    Integer getMinRentDay();
    Double getPricePerDay();
}
