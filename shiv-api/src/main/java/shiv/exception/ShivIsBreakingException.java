package shiv.exception;

public class ShivIsBreakingException extends ShivInternalException {

    public ShivIsBreakingException() {
        super(
                "[Shiv/Runtime/IsBreaking]\n\tError: If you are seeing this shiv has somehow converted one of your functions which provides a class of type [A] into a provider providing a class of type [B]. Shiv shoud have caught this at compile time, if you are seeing this you might want to choose a different framework."
        );
    }

}
