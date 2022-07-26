package T06SOLID.Lab.p04_InterfaceSegregation.p02_identity;

import T06SOLID.Lab.p04_InterfaceSegregation.p02_identity.interfaces.Account;
import T06SOLID.Lab.p04_InterfaceSegregation.p02_identity.interfaces.RegistrationRestriction;

public class AccountManager implements RegistrationRestriction{
    private boolean requireUniqueEmail;

    private int minRequiredPasswordLength;

    private int maxRequiredPasswordLength;


    @Override
    public boolean getRequireUniqueEmail() {
        return this.requireUniqueEmail;
    }

    @Override
    public int getMinRequiredPasswordLength() {
        return this.minRequiredPasswordLength;
    }

    @Override
    public int getMaxRequiredPasswordLength() {
        return this.maxRequiredPasswordLength;
    }

}
