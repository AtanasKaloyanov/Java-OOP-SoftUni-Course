package fairyShop.models;

public class ShopImpl implements Shop {
    @Override
    public void craft(Present present, Helper helper) {

        for (Instrument instrument : helper.getInstruments()) {
            boolean isBroken = instrument.isBroken();
            while (present.isDone()) {
                if (!isBroken && helper.canWork()) {
                    helper.work();
                } else {
                    break;
                }
            }
        }
        boolean isntBroken = helper.getInstruments().stream()
                .anyMatch(instrument -> !instrument.isBroken());

        if (helper.canWork() && isntBroken) {

            helper.work();
        }


    }
}

