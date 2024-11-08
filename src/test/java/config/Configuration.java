package config;

public class Configuration {
    public String url ="https://app-uat.klink.cloud/";;
    public String username ="saw@klink.cloud";
    public String password = "password1";

    public Configuration(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

