import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemsParser {
    private String rawData;
    private List<String> parsedData;
    private HashMap<String, List<Items>> items;
    private int errorCount;

    public ItemsParser(String rawData) {
        this.rawData = rawData;
        this.parsedData = new ArrayList<String>(Arrays.asList(rawData.split("##")));
        this.items = new HashMap<>();
        this.errorCount = 0;
        createItems();
    }
    public void createItems(){
        for(String pd :parsedData){
//            List<String> temp = new ArrayList<>(Arrays.asList(pd.split(";")));
            Pattern pattern = Pattern.compile("(?i)([a-zA-Z]+):([^;@^*%#!]+)(?:[;@^*%!])?");
            Matcher matcher = pattern.matcher(pd);
//            System.out.println(pd);
            String itemName = null;
            String itemPrice = null;
            String itemType = null;
            String itemExp = null;


            while (matcher.find()) {
                String key = matcher.group(1);
                key = key.substring(0, 1).toUpperCase() + key.substring(1).toLowerCase();
                String value = matcher.group(2);
                value = value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
//                System.out.println(key);
//                System.out.println(value);
                if(key.equals("Name")){
                    itemName = value;
                }
                if(key.equals("Price")){
                    itemPrice = value;
                }
                if(key.equals("Type")){
                    itemType = value;
                }
                if(key.equals("Expiration")){
                    itemExp = value;
                }


                if(itemName != null && itemPrice != null && itemType != null && itemExp != null){
                     Items items1 = new Items(itemName,itemPrice,itemType,itemExp);
                     List<Items> temp = items.get(itemName);
                     if(temp != null){
                         temp.add(items1);
                         items.put(itemName,temp);
                     }
                     else{
                         temp = new ArrayList<>();
                         temp.add(items1);
                         items.put(itemName,temp);
                     }

                }
                else{
                    errorCount++;
                }
            }


        }

    }
    public void formattedData() throws Exception{
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Items>> set : items.entrySet()) {
            String key = set.getKey();
            List<Items> value = set.getValue();
            int totalCount = value.size();
            sb.append("name:    ").append(key).append(" \t\t seen: ").append(totalCount).append(" times\n");
            HashMap<String, Integer> itemMap = new HashMap<>();
            for(Items i : value){
                String iPrice = i.getPrice();

                if(itemMap.get(iPrice) == null){
                    itemMap.put(iPrice,1);
                }
                else{
                    Integer tempCount = itemMap.get(iPrice);
                    itemMap.put(iPrice,tempCount++);
                }
            }
            for (Map.Entry<String, Integer> set2 : itemMap.entrySet()) {
                String keyPrice = set2.getKey();
                Integer valueCount = set2.getValue();
                sb.append("Price:    ").append(keyPrice).append(" \t\t seen: ").append(valueCount).append(" times\n");
            }
        }
        System.out.println(sb);

    }

}
