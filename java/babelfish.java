import java.util.HashMap;

public class babelfish {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        String s;
        HashMap<String, String> map = new HashMap<>();
        boolean translate = false;
        while((s = katt.getLine()) != null){
            if(s.equals("")){
                translate = true;
                continue;
            }
            if(!translate) {
                String[] split = s.split(" ");
                map.put(split[1], split[0]);
            } else {
                System.out.println(map.getOrDefault(s, "eh"));
            }
        }
    }
}
