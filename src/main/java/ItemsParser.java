import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ItemsParser {
    private int countErrors=0;
    public int getErrorCount(){
        return countErrors;
    }
    private String fieldPattern = "([A-Za-z0-9.]+)";
    private String stringSplitPattern = "([;:^@%*!])";
    private String itemSplitPattern = "((##))";

}
