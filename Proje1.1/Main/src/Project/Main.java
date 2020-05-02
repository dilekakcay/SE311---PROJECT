package Project;

import Helpers.Local.code.Local_Functions;
import Helpers.LDAP.code.LDAP_Functions;

public class Main {

    public static void main(String[] args) {

        Local_Functions local = new Local_Functions();
        local.getuid();

        LDAP_Functions ldap = new LDAP_Functions();
        ldap.print();
    }
}