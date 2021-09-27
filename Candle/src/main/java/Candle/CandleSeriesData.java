package Candle;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class CandleSeriesData {
    private LocalDateTime time;
    private String symbol;
    private double price;

    public CandleSeriesData(LocalDateTime time, String symbol, double price){
        this.time =time;
        this.symbol=symbol;
        this.price=price;
    }

    public LocalDateTime getTime(){
        return time;
    }

    public double getPrice(){
        return price;
    }

    public String getSymbol(){
        return symbol;
    }

    public static String generateSymbol(){
        String[] symbolsList = {"$", "£"};
        Random random=new Random();
        int symbolsListRandomNumber=random.nextInt(symbolsList.length);

        return symbolsList[symbolsListRandomNumber];
    }

    public static int generatePrice(int price){
        Random random= new Random();
        float randomPercent = random.nextInt(21) + 10 ;
        price += (int) (Math.random() * 2) == 1
                ? (randomPercent / 100.0f)
                : -(randomPercent / 100.0f);

        return price;
    }

    public static void getCandles(String symbol, LocalDateTime startDate, LocalDateTime endDate, int granularity) {
        List<CandleSeriesData> data = new ArrayList<>();

        LocalDateTime nowTime = startDate;

        int price = new Random().nextInt(1000) + 500;

        while (nowTime.getDayOfMonth() < endDate.getDayOfMonth()) {
            if (nowTime.getMinute() != 0 && nowTime.getHour() < 15 && nowTime.getHour() >= 10) {
                price = generatePrice(price);
            }

            Calendar cal = Calendar.getInstance();

            if (nowTime.getDayOfMonth() == cal.getActualMaximum(Calendar.DATE) && nowTime.getHour() == 15 && nowTime.getMinute() == 0) {
                nowTime = nowTime.plusMonths(1);

                if (nowTime.getMonthValue() == 12) {
                    nowTime = nowTime.plusYears(1);
                }
            }

            if (nowTime.getHour() == 15 && nowTime.getMinute() == 0) {
                nowTime = nowTime.plusDays(1);
                nowTime = nowTime.minusHours(5);
            }

            if (nowTime.getHour() < 15 && nowTime.getHour() >= 10 && nowTime.getYear() != 2022) {
                data.add(new CandleSeriesData(nowTime, symbol, price));
            }
            nowTime = nowTime.plusMinutes(5);
        }

        List<List<CandleSeriesData>> candles = new ArrayList<>();

        while (startDate.getHour() != endDate.getHour() && startDate.getDayOfMonth() != endDate.getDayOfMonth()) {
            LocalDateTime startPoint = startDate.plusYears(0);
            LocalDateTime granulatedTime = startPoint.plusSeconds(granularity);

            List<CandleSeriesData> candle = data.stream()
                    .filter(e -> e.time.isBefore(granulatedTime) && e.time.isAfter(startPoint))
                    .collect(Collectors.toList());

            candles.add(candle);
            startDate = startDate.plusSeconds(granularity);
            if (startDate.getHour() == 15 && startDate.getMinute() == 0) {
                startDate = startDate.plusDays(1);
                startDate = startDate.minusHours(5);
            }
        }

        List<List<Double>> candlePrice = candles.stream()
                .map(e -> e.stream()
                        .map(a -> a.price).collect(Collectors.toList())).collect(Collectors.toList());

        System.out.println(candlePrice);

        List<Optional<Double>> low = candlePrice.stream()
                .map(e -> e.stream()
                        .min(Double::compareTo)).collect(Collectors.toList());
        System.out.println(low);

        List<Optional<Double>> high = candlePrice.stream()
                .map(e -> e.stream()
                        .max(Double::compareTo)).collect(Collectors.toList());
        System.out.println(high);

        List<Double> startPrice = candlePrice.stream()
                .map(e -> e.get(0)).collect(Collectors.toList());
        System.out.println(startPrice);

        List<Double> endPrice = candlePrice.stream()
                .map(e -> e.get(e.size() - 1)).collect(Collectors.toList());
        System.out.println(endPrice);

//        CandleDTO candleDTO = new CandleDTO();
    }

    @Override
    public String toString() {
        return "Data{" +
                "Date='" + time + '\'' +
                ", symbol=" + symbol +
                ", price=" + price +
                '}';
    }


    public static void main(String[] args) {

        String symbol = generateSymbol();
        LocalDateTime startDate = LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.parse("10:00"));
        LocalDateTime endDate = LocalDateTime.of(LocalDateTime.now().toLocalDate().plusDays(2), LocalTime.parse("03:00"));

        getCandles(symbol,startDate, endDate, 3600);
    }
}
