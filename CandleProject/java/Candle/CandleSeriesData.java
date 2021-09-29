package Candle;

import java.time.LocalDateTime;

public class CandleSeriesData {
    private LocalDateTime time;
    private String symbol;
    private double price;

    public CandleSeriesData(LocalDateTime time, String symbol, double price){
        this.time = time;
        this.symbol = symbol;
        this.price = price;
    }

    public LocalDateTime getTime(){
        return time;
    }

    public String getSymbol() {
        return symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
