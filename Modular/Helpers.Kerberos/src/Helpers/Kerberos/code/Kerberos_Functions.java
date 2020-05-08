package Helpers.Kerberos.code;

public class Kerberos_Functions {
    public int krb_getuid(String name) {
        System.out.println("krb_getuid() works!");
        return 1;
    }
    public int krb_authenticate(String name, String pwd) {
        System.out.println("krb_authenticate() works!");
        return 1;
    }
}
