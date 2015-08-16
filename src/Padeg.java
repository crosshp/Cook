import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Andrew on 27.06.2015.
 */
public class Padeg {

    public String revertToNormal(String word) {
        try {
            Document doc = Jsoup
                    .connect(
                            "http://phpmorphy.sourceforge.net/dokuwiki/demo?word="+word+"&dict_type=aot&enable_predict_by_suffix=1&enable_predict_by_db=1")
                    .get();
            return  doc.select("span.base-form").first().html().toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}