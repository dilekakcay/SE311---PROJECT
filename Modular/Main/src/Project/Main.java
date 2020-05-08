package Project;

import Helpers.Local.code.Local_Functions;
import Helpers.LDAP.code.LDAP_Functions;
import Helpers.Kerberos.code.Kerberos_Functions;

class Ourclass { // Will be renamed

    static public void run(){ // Template

        Ourclass run_func = new Ourclass();

        String name = run_func.getusername();
        String pwd = run_func.getpassword();
        int rc = run_func.authenticate(name, pwd);
        if(rc == 0){ // success
            int uid = run_func.getuid(name);
            run_func.setuid(uid);
            System.out.println("run() goes success!");
        }
        else {
            int uid = run_func.getuid(name);
            run_func.setuid(uid);
            System.out.println("run() goes else!");
        }
    };

    public String getusername(){
        System.out.println("getusername() works!");
        return "name";
    };

    public String getpassword(){
        System.out.println("getpasswor() works!");
        return "pwd";
    };

    public int setuid(int uid){
        System.out.println("setuid() works!");
        return 0;
    };

    public int authenticate(String name, String pwd){

        // 1 means fail
        // 0 means success

        System.out.println("authenticate() works!");

        Local_Functions local = new Local_Functions();
        if(local.local_authenticate(name, pwd) == 0){ // if success avoid losing time by returning 0
            return 0;
        }

        LDAP_Functions ldap = new LDAP_Functions();
        if(ldap.LDAP_authenticate(name, pwd) == 0){
            return 0;
        }

        Kerberos_Functions kerberos = new Kerberos_Functions();
        return kerberos.krb_authenticate(name, pwd);
    };

    public int getuid(String name){

        Local_Functions local = new Local_Functions();
        local.local_getuid(name);

        LDAP_Functions ldap = new LDAP_Functions();
        ldap.LDAP_getuid(name);

        Kerberos_Functions kerberos = new Kerberos_Functions();
        kerberos.krb_getuid(name);

        return 0;
    };
}

public class Main {

    public static void main(String[] args) {

        Ourclass run_func = new Ourclass();
        run_func.run(); // Run template
    }
}