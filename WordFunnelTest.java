/**
 * Created by Benjamin Ehlers on 12/20/2018.
 */
public class WordFunnelTest {



    public WordFunnelTest() {

    }

    public static void main(String[] args) {
        WordFunnel wordFunnel = new WordFunnel("aash", 0);
        try {
            System.out.println(wordFunnel.maxWordFunnelCount(wordFunnel));
        } catch(Exception E) {
            System.out.println(E);
        }
    }
}
