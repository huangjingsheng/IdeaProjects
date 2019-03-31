import java.util.ArrayList;
import java.util.List;

public class User {
    private String token;
    private int id;

    public String getToken() {
        return token;
    }



    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        list.add("111");
        String s = list.get(0);
        System.out.println(s);
    }
}
