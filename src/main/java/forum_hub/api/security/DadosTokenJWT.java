package forum_hub.api.security;

public class DadosTokenJWT {
    private String token;

    public DadosTokenJWT(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
