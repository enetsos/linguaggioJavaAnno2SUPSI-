package testProva.es2;

class Autorun {
    public Autorun() {
        System.out.println("Constructor");
    }

    public String autorunString() {
        System.out.println("Should be executed returning a string ");
        return "defaultString";
    }

    public String autorunString(final String input) {
        System.out.println("Should be executed receiving a string '"+input+"'");
        return input;
    }

    public Integer autorunInteger(final Integer i) {
        System.out.println("Should be executed receiving and integer: " + i);
        return Integer.sum(i,  i);
    }

    public void noRun() {
        System.out.println("Should not be executed");
    }

    public void autorun(final Autorun theClass, String data) {
        System.out.println("Should be executed, passing an instance of Autorun: " + theClass + " and string data: " + data);
    }
}