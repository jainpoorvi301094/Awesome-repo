package main.java.utils;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/resources/FrameworkConfig.properties")
public interface FrameworkConfig extends Config {

    String environment();
    /*For Kite Portal*/
    @Key("${environment}.kite")
    String kite();

    @Key("${environment}.email")
    String email();

    @Key("${environment}.pass")
    String pass();


    /*For Dart Portal*/

    @Key("${environment}.enterpriseId")
    String enterpriseId();

    @Key("${environment}.username")
    String username();

    @Key("${environment}.otp")
    String otp();

    @Key("${environment}.dart")
    String dart();
    @Key("${environment}.tablepath")
    String tablepath();

}
