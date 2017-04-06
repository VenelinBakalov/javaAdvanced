package p05_security_system;

public class KeyCardCheck extends SecurityCheck {

    private SecurityUI securityUI;

    public KeyCardCheck(SecurityUI securityUI) {
        this.securityUI = securityUI;
    }

    @Override
    public boolean validateUser() {
        String code = securityUI.requestKeyCard();
        if (isValid(code)) {
            return true;
        }

        return false;
    }

    private boolean isValid(String code) {
        return true;
    }
}
