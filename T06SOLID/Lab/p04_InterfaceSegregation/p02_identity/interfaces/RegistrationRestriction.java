package T06SOLID.Lab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface RegistrationRestriction {
    boolean getRequireUniqueEmail();
    int getMinRequiredPasswordLength();
    int getMaxRequiredPasswordLength();
}
