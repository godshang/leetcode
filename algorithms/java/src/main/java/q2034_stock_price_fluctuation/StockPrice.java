package q2034_stock_price_fluctuation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPrice {

    private int currentTimestamp;
    private Map<Integer, Integer> timestampToPriceMap;
    private TreeMap<Integer, Integer> priceToCountMap;

    public StockPrice() {
        timestampToPriceMap = new HashMap<>();
        priceToCountMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        currentTimestamp = Math.max(timestamp, currentTimestamp);
        if (timestampToPriceMap.containsKey(timestamp)) {
            int oldPrice = timestampToPriceMap.get(timestamp);
            int count = priceToCountMap.get(oldPrice);
            if (count == 1) {
                priceToCountMap.remove(oldPrice);
            } else {
                priceToCountMap.put(oldPrice, count - 1);
            }
        }
        timestampToPriceMap.put(timestamp, price);
        priceToCountMap.put(price, priceToCountMap.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timestampToPriceMap.get(currentTimestamp);
    }

    public int maximum() {
        return priceToCountMap.lastKey();
    }

    public int minimum() {
        return priceToCountMap.firstKey();
    }
}
