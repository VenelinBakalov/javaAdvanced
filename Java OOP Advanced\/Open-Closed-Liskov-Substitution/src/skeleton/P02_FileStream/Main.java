package skeleton.P02_FileStream;

/**
 * Created by Venelin on 4.4.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        StreamProgressInfo info = new StreamProgressInfo(new File(2048, 512, "Java Video"));
        System.out.println(info.calculateCurrentPercent());

     //   StreamProgressInfo infoFromWeb = new StreamProgressInfo(new Music());
    }

}
