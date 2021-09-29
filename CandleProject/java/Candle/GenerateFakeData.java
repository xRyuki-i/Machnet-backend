package Candle;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GenerateFakeData {

    public static String generateSymbol(){
        String[] symbolsList = {"$", "£"};
        Random random=new Random();
        int symbolsListRandomNumber=random.nextInt(symbolsList.length);

        return symbolsList[symbolsListRandomNumber];
    }

    public static int generatePrice(int price){
        Random random= new Random();

        float randomValue = (random.nextInt(2)+1);
        if (Math.random()*2 < 1){
            price -= randomValue;
        }else{
            price += randomValue;
        }

        return price;
    }

    public static List<CandleSeriesData> GenerateData() {
        List<CandleSeriesData> data = new ArrayList<>();

        LocalDateTime present = LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.parse("10:00"));
        int price = new Random().nextInt(1000)+500;

        while (present.getDayOfMonth() < present.plusDays(1).getDayOfMonth()) {
            price = generatePrice(price);
            data.add(new CandleSeriesData(present, generateSymbol(), price));
            present = present.plusSeconds(1);
        }

        return  data;
    }

    public static List<CandleDTO> getCandles(String symbol, LocalDateTime startDate, LocalDateTime endDate, int granularity) {
        List<CandleSeriesData> data = GenerateData();

        List<CandleSeriesData> filteredData = data.stream()
                .filter(e -> e.getTime().isBefore(endDate) && e.getTime().isAfter(startDate))
                .collect(Collectors.toList());

        int start=0;
        int candelSize=filteredData.size()/granularity;
        List<CandleSeriesData> candle=null;
        List<CandleSeriesData> filteredCandle = null;
        List<CandleDTO> candleDTOList=new ArrayList<>();
        double closePrice=0;

        for(int i=0;i<candelSize;i++){

            candle = filteredData.stream().skip(start)
                    .limit(granularity).collect(Collectors.toList());

            filteredCandle=candle.stream().filter(e->e.getSymbol()==symbol).collect(Collectors.toList());

            List<Double> oneCandelPrice= filteredCandle.stream().map(e -> e.getPrice()).collect(Collectors.toList());

            List<LocalDateTime> oneCandelTime= filteredCandle.stream().map(e -> e.getTime()).collect(Collectors.toList());

            double lowPrice = Collections.min(oneCandelPrice);
            double highPrice = Collections.max(oneCandelPrice);
            double sumPrice = oneCandelPrice.stream().reduce(0d, (acc, element) -> acc + element);
            double openPrice;

            if(start==0){
                openPrice =oneCandelPrice.get(0);
                closePrice =oneCandelPrice.get(oneCandelPrice.size()-1);
            }
            else{
                openPrice=closePrice;
                closePrice =oneCandelPrice.get(oneCandelPrice.size()-1);
            }

            candleDTOList.add(new CandleDTO(oneCandelTime.get(0), lowPrice, highPrice, openPrice, closePrice, sumPrice));
            start+=granularity;
        }

        return candleDTOList ;
    }

    public static void main (String[] args){
        String symbol = generateSymbol();
        LocalDateTime startDate = LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.parse("10:00"));
        LocalDateTime endDate = startDate.plusHours(2);

        List<CandleDTO> candle = getCandles(symbol, startDate, endDate, 60);

        int count = 1;
        for(int i=0;i<candle.size();i++){
            System.out.println("Candel"+count+" time-> "+candle.get(i).getTime()+"  high->"+candle.get(i).getHigh()+"  low->"+candle.get(i).getLow()+"  open->"+candle.get(i).getOpen()+" close->"+candle.get(i).getClose()+ " Volume: "+candle.get(i).getVolume());
            count++;
        }
    }
}
