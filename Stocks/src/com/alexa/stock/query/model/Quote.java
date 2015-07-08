
package com.alexa.stock.query.model;

import java.util.HashMap;
import java.util.Map;


import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;


@JsonPropertyOrder({
    "symbol",
    "Ask",
    "AverageDailyVolume",
    "Bid",
    "AskRealtime",
    "BidRealtime",
    "BookValue",
    "Change_PercentChange",
    "Change",
    "Commission",
    "Currency",
    "ChangeRealtime",
    "AfterHoursChangeRealtime",
    "DividendShare",
    "LastTradeDate",
    "TradeDate",
    "EarningsShare",
    "ErrorIndicationreturnedforsymbolchangedinvalid",
    "EPSEstimateCurrentYear",
    "EPSEstimateNextYear",
    "EPSEstimateNextQuarter",
    "DaysLow",
    "DaysHigh",
    "YearLow",
    "YearHigh",
    "HoldingsGainPercent",
    "AnnualizedGain",
    "HoldingsGain",
    "HoldingsGainPercentRealtime",
    "HoldingsGainRealtime",
    "MoreInfo",
    "OrderBookRealtime",
    "MarketCapitalization",
    "MarketCapRealtime",
    "EBITDA",
    "ChangeFromYearLow",
    "PercentChangeFromYearLow",
    "LastTradeRealtimeWithTime",
    "ChangePercentRealtime",
    "ChangeFromYearHigh",
    "PercebtChangeFromYearHigh",
    "LastTradeWithTime",
    "LastTradePriceOnly",
    "HighLimit",
    "LowLimit",
    "DaysRange",
    "DaysRangeRealtime",
    "FiftydayMovingAverage",
    "TwoHundreddayMovingAverage",
    "ChangeFromTwoHundreddayMovingAverage",
    "PercentChangeFromTwoHundreddayMovingAverage",
    "ChangeFromFiftydayMovingAverage",
    "PercentChangeFromFiftydayMovingAverage",
    "Name",
    "Notes",
    "Open",
    "PreviousClose",
    "PricePaid",
    "ChangeinPercent",
    "PriceSales",
    "PriceBook",
    "ExDividendDate",
    "PERatio",
    "DividendPayDate",
    "PERatioRealtime",
    "PEGRatio",
    "PriceEPSEstimateCurrentYear",
    "PriceEPSEstimateNextYear",
    "Symbol",
    "SharesOwned",
    "ShortRatio",
    "LastTradeTime",
    "TickerTrend",
    "OneyrTargetPrice",
    "Volume",
    "HoldingsValue",
    "HoldingsValueRealtime",
    "YearRange",
    "DaysValueChange",
    "DaysValueChangeRealtime",
    "StockExchange",
    "DividendYield",
    "PercentChange"
})
public class Quote {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("Ask")
    private String Ask;
    @JsonProperty("AverageDailyVolume")
    private String AverageDailyVolume;
    @JsonProperty("Bid")
    private String Bid;
    @JsonProperty("AskRealtime")
    private Object AskRealtime;
    @JsonProperty("BidRealtime")
    private Object BidRealtime;
    @JsonProperty("BookValue")
    private String BookValue;
    @JsonProperty("Change_PercentChange")
    private String ChangePercentChange;
    @JsonProperty("Change")
    private String Change;
    @JsonProperty("Commission")
    private Object Commission;
    @JsonProperty("Currency")
    private String Currency;
    @JsonProperty("ChangeRealtime")
    private Object ChangeRealtime;
    @JsonProperty("AfterHoursChangeRealtime")
    private Object AfterHoursChangeRealtime;
    @JsonProperty("DividendShare")
    private String DividendShare;
    @JsonProperty("LastTradeDate")
    private String LastTradeDate;
    @JsonProperty("TradeDate")
    private Object TradeDate;
    @JsonProperty("EarningsShare")
    private String EarningsShare;
    @JsonProperty("ErrorIndicationreturnedforsymbolchangedinvalid")
    private Object ErrorIndicationreturnedforsymbolchangedinvalid;
    @JsonProperty("EPSEstimateCurrentYear")
    private String EPSEstimateCurrentYear;
    @JsonProperty("EPSEstimateNextYear")
    private String EPSEstimateNextYear;
    @JsonProperty("EPSEstimateNextQuarter")
    private String EPSEstimateNextQuarter;
    @JsonProperty("DaysLow")
    private String DaysLow;
    @JsonProperty("DaysHigh")
    private String DaysHigh;
    @JsonProperty("YearLow")
    private String YearLow;
    @JsonProperty("YearHigh")
    private String YearHigh;
    @JsonProperty("HoldingsGainPercent")
    private Object HoldingsGainPercent;
    @JsonProperty("AnnualizedGain")
    private Object AnnualizedGain;
    @JsonProperty("HoldingsGain")
    private Object HoldingsGain;
    @JsonProperty("HoldingsGainPercentRealtime")
    private Object HoldingsGainPercentRealtime;
    @JsonProperty("HoldingsGainRealtime")
    private Object HoldingsGainRealtime;
    @JsonProperty("MoreInfo")
    private Object MoreInfo;
    @JsonProperty("OrderBookRealtime")
    private Object OrderBookRealtime;
    @JsonProperty("MarketCapitalization")
    private String MarketCapitalization;
    @JsonProperty("MarketCapRealtime")
    private Object MarketCapRealtime;
    @JsonProperty("EBITDA")
    private String EBITDA;
    @JsonProperty("ChangeFromYearLow")
    private String ChangeFromYearLow;
    @JsonProperty("PercentChangeFromYearLow")
    private String PercentChangeFromYearLow;
    @JsonProperty("LastTradeRealtimeWithTime")
    private Object LastTradeRealtimeWithTime;
    @JsonProperty("ChangePercentRealtime")
    private Object ChangePercentRealtime;
    @JsonProperty("ChangeFromYearHigh")
    private String ChangeFromYearHigh;
    @JsonProperty("PercebtChangeFromYearHigh")
    private String PercebtChangeFromYearHigh;
    @JsonProperty("LastTradeWithTime")
    private String LastTradeWithTime;
    @JsonProperty("LastTradePriceOnly")
    private String LastTradePriceOnly;
    @JsonProperty("HighLimit")
    private Object HighLimit;
    @JsonProperty("LowLimit")
    private Object LowLimit;
    @JsonProperty("DaysRange")
    private String DaysRange;
    @JsonProperty("DaysRangeRealtime")
    private Object DaysRangeRealtime;
    @JsonProperty("FiftydayMovingAverage")
    private String FiftydayMovingAverage;
    @JsonProperty("TwoHundreddayMovingAverage")
    private String TwoHundreddayMovingAverage;
    @JsonProperty("ChangeFromTwoHundreddayMovingAverage")
    private String ChangeFromTwoHundreddayMovingAverage;
    @JsonProperty("PercentChangeFromTwoHundreddayMovingAverage")
    private String PercentChangeFromTwoHundreddayMovingAverage;
    @JsonProperty("ChangeFromFiftydayMovingAverage")
    private String ChangeFromFiftydayMovingAverage;
    @JsonProperty("PercentChangeFromFiftydayMovingAverage")
    private String PercentChangeFromFiftydayMovingAverage;
    @JsonProperty("Name")
    private String Name;
    @JsonProperty("Notes")
    private Object Notes;
    @JsonProperty("Open")
    private String Open;
    @JsonProperty("PreviousClose")
    private String PreviousClose;
    @JsonProperty("PricePaid")
    private Object PricePaid;
    @JsonProperty("ChangeinPercent")
    private String ChangeinPercent;
    @JsonProperty("PriceSales")
    private String PriceSales;
    @JsonProperty("PriceBook")
    private String PriceBook;
    @JsonProperty("ExDividendDate")
    private String ExDividendDate;
    @JsonProperty("PERatio")
    private String PERatio;
    @JsonProperty("DividendPayDate")
    private String DividendPayDate;
    @JsonProperty("PERatioRealtime")
    private Object PERatioRealtime;
    @JsonProperty("PEGRatio")
    private String PEGRatio;
    @JsonProperty("PriceEPSEstimateCurrentYear")
    private String PriceEPSEstimateCurrentYear;
    @JsonProperty("PriceEPSEstimateNextYear")
    private String PriceEPSEstimateNextYear;
    @JsonProperty("Symbol")
    private String Symbol;
    @JsonProperty("SharesOwned")
    private Object SharesOwned;
    @JsonProperty("ShortRatio")
    private String ShortRatio;
    @JsonProperty("LastTradeTime")
    private String LastTradeTime;
    @JsonProperty("TickerTrend")
    private Object TickerTrend;
    @JsonProperty("OneyrTargetPrice")
    private String OneyrTargetPrice;
    @JsonProperty("Volume")
    private String Volume;
    @JsonProperty("HoldingsValue")
    private Object HoldingsValue;
    @JsonProperty("HoldingsValueRealtime")
    private Object HoldingsValueRealtime;
    @JsonProperty("YearRange")
    private String YearRange;
    @JsonProperty("DaysValueChange")
    private Object DaysValueChange;
    @JsonProperty("DaysValueChangeRealtime")
    private Object DaysValueChangeRealtime;
    @JsonProperty("StockExchange")
    private String StockExchange;
    @JsonProperty("DividendYield")
    private String DividendYield;
    @JsonProperty("PercentChange")
    private String PercentChange;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The symbol
     */
    @JsonProperty("symbol")
    public String getSymbolLower() {
        return symbol;
    }

    /**
     * 
     * @param symbol
     *     The symbol
     */
    @JsonProperty("symbol")
    public void setSymbolLower(String symbol) {
        this.symbol = symbol;
    }

    /**
     * 
     * @return
     *     The Ask
     */
    @JsonProperty("Ask")
    public String getAsk() {
        return Ask;
    }

    /**
     * 
     * @param Ask
     *     The Ask
     */
    @JsonProperty("Ask")
    public void setAsk(String Ask) {
        this.Ask = Ask;
    }

    /**
     * 
     * @return
     *     The AverageDailyVolume
     */
    @JsonProperty("AverageDailyVolume")
    public String getAverageDailyVolume() {
        return AverageDailyVolume;
    }

    /**
     * 
     * @param AverageDailyVolume
     *     The AverageDailyVolume
     */
    @JsonProperty("AverageDailyVolume")
    public void setAverageDailyVolume(String AverageDailyVolume) {
        this.AverageDailyVolume = AverageDailyVolume;
    }

    /**
     * 
     * @return
     *     The Bid
     */
    @JsonProperty("Bid")
    public String getBid() {
        return Bid;
    }

    /**
     * 
     * @param Bid
     *     The Bid
     */
    @JsonProperty("Bid")
    public void setBid(String Bid) {
        this.Bid = Bid;
    }

    /**
     * 
     * @return
     *     The AskRealtime
     */
    @JsonProperty("AskRealtime")
    public Object getAskRealtime() {
        return AskRealtime;
    }

    /**
     * 
     * @param AskRealtime
     *     The AskRealtime
     */
    @JsonProperty("AskRealtime")
    public void setAskRealtime(Object AskRealtime) {
        this.AskRealtime = AskRealtime;
    }

    /**
     * 
     * @return
     *     The BidRealtime
     */
    @JsonProperty("BidRealtime")
    public Object getBidRealtime() {
        return BidRealtime;
    }

    /**
     * 
     * @param BidRealtime
     *     The BidRealtime
     */
    @JsonProperty("BidRealtime")
    public void setBidRealtime(Object BidRealtime) {
        this.BidRealtime = BidRealtime;
    }

    /**
     * 
     * @return
     *     The BookValue
     */
    @JsonProperty("BookValue")
    public String getBookValue() {
        return BookValue;
    }

    /**
     * 
     * @param BookValue
     *     The BookValue
     */
    @JsonProperty("BookValue")
    public void setBookValue(String BookValue) {
        this.BookValue = BookValue;
    }

    /**
     * 
     * @return
     *     The ChangePercentChange
     */
    @JsonProperty("Change_PercentChange")
    public String getChangePercentChange() {
        return ChangePercentChange;
    }

    /**
     * 
     * @param ChangePercentChange
     *     The Change_PercentChange
     */
    @JsonProperty("Change_PercentChange")
    public void setChangePercentChange(String ChangePercentChange) {
        this.ChangePercentChange = ChangePercentChange;
    }

    /**
     * 
     * @return
     *     The Change
     */
    @JsonProperty("Change")
    public String getChange() {
        return Change;
    }

    /**
     * 
     * @param Change
     *     The Change
     */
    @JsonProperty("Change")
    public void setChange(String Change) {
        this.Change = Change;
    }

    /**
     * 
     * @return
     *     The Commission
     */
    @JsonProperty("Commission")
    public Object getCommission() {
        return Commission;
    }

    /**
     * 
     * @param Commission
     *     The Commission
     */
    @JsonProperty("Commission")
    public void setCommission(Object Commission) {
        this.Commission = Commission;
    }

    /**
     * 
     * @return
     *     The Currency
     */
    @JsonProperty("Currency")
    public String getCurrency() {
        return Currency;
    }

    /**
     * 
     * @param Currency
     *     The Currency
     */
    @JsonProperty("Currency")
    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    /**
     * 
     * @return
     *     The ChangeRealtime
     */
    @JsonProperty("ChangeRealtime")
    public Object getChangeRealtime() {
        return ChangeRealtime;
    }

    /**
     * 
     * @param ChangeRealtime
     *     The ChangeRealtime
     */
    @JsonProperty("ChangeRealtime")
    public void setChangeRealtime(Object ChangeRealtime) {
        this.ChangeRealtime = ChangeRealtime;
    }

    /**
     * 
     * @return
     *     The AfterHoursChangeRealtime
     */
    @JsonProperty("AfterHoursChangeRealtime")
    public Object getAfterHoursChangeRealtime() {
        return AfterHoursChangeRealtime;
    }

    /**
     * 
     * @param AfterHoursChangeRealtime
     *     The AfterHoursChangeRealtime
     */
    @JsonProperty("AfterHoursChangeRealtime")
    public void setAfterHoursChangeRealtime(Object AfterHoursChangeRealtime) {
        this.AfterHoursChangeRealtime = AfterHoursChangeRealtime;
    }

    /**
     * 
     * @return
     *     The DividendShare
     */
    @JsonProperty("DividendShare")
    public String getDividendShare() {
        return DividendShare;
    }

    /**
     * 
     * @param DividendShare
     *     The DividendShare
     */
    @JsonProperty("DividendShare")
    public void setDividendShare(String DividendShare) {
        this.DividendShare = DividendShare;
    }

    /**
     * 
     * @return
     *     The LastTradeDate
     */
    @JsonProperty("LastTradeDate")
    public String getLastTradeDate() {
        return LastTradeDate;
    }

    /**
     * 
     * @param LastTradeDate
     *     The LastTradeDate
     */
    @JsonProperty("LastTradeDate")
    public void setLastTradeDate(String LastTradeDate) {
        this.LastTradeDate = LastTradeDate;
    }

    /**
     * 
     * @return
     *     The TradeDate
     */
    @JsonProperty("TradeDate")
    public Object getTradeDate() {
        return TradeDate;
    }

    /**
     * 
     * @param TradeDate
     *     The TradeDate
     */
    @JsonProperty("TradeDate")
    public void setTradeDate(Object TradeDate) {
        this.TradeDate = TradeDate;
    }

    /**
     * 
     * @return
     *     The EarningsShare
     */
    @JsonProperty("EarningsShare")
    public String getEarningsShare() {
        return EarningsShare;
    }

    /**
     * 
     * @param EarningsShare
     *     The EarningsShare
     */
    @JsonProperty("EarningsShare")
    public void setEarningsShare(String EarningsShare) {
        this.EarningsShare = EarningsShare;
    }

    /**
     * 
     * @return
     *     The ErrorIndicationreturnedforsymbolchangedinvalid
     */
    @JsonProperty("ErrorIndicationreturnedforsymbolchangedinvalid")
    public Object getErrorIndicationreturnedforsymbolchangedinvalid() {
        return ErrorIndicationreturnedforsymbolchangedinvalid;
    }

    /**
     * 
     * @param ErrorIndicationreturnedforsymbolchangedinvalid
     *     The ErrorIndicationreturnedforsymbolchangedinvalid
     */
    @JsonProperty("ErrorIndicationreturnedforsymbolchangedinvalid")
    public void setErrorIndicationreturnedforsymbolchangedinvalid(Object ErrorIndicationreturnedforsymbolchangedinvalid) {
        this.ErrorIndicationreturnedforsymbolchangedinvalid = ErrorIndicationreturnedforsymbolchangedinvalid;
    }

    /**
     * 
     * @return
     *     The EPSEstimateCurrentYear
     */
    @JsonProperty("EPSEstimateCurrentYear")
    public String getEPSEstimateCurrentYear() {
        return EPSEstimateCurrentYear;
    }

    /**
     * 
     * @param EPSEstimateCurrentYear
     *     The EPSEstimateCurrentYear
     */
    @JsonProperty("EPSEstimateCurrentYear")
    public void setEPSEstimateCurrentYear(String EPSEstimateCurrentYear) {
        this.EPSEstimateCurrentYear = EPSEstimateCurrentYear;
    }

    /**
     * 
     * @return
     *     The EPSEstimateNextYear
     */
    @JsonProperty("EPSEstimateNextYear")
    public String getEPSEstimateNextYear() {
        return EPSEstimateNextYear;
    }

    /**
     * 
     * @param EPSEstimateNextYear
     *     The EPSEstimateNextYear
     */
    @JsonProperty("EPSEstimateNextYear")
    public void setEPSEstimateNextYear(String EPSEstimateNextYear) {
        this.EPSEstimateNextYear = EPSEstimateNextYear;
    }

    /**
     * 
     * @return
     *     The EPSEstimateNextQuarter
     */
    @JsonProperty("EPSEstimateNextQuarter")
    public String getEPSEstimateNextQuarter() {
        return EPSEstimateNextQuarter;
    }

    /**
     * 
     * @param EPSEstimateNextQuarter
     *     The EPSEstimateNextQuarter
     */
    @JsonProperty("EPSEstimateNextQuarter")
    public void setEPSEstimateNextQuarter(String EPSEstimateNextQuarter) {
        this.EPSEstimateNextQuarter = EPSEstimateNextQuarter;
    }

    /**
     * 
     * @return
     *     The DaysLow
     */
    @JsonProperty("DaysLow")
    public String getDaysLow() {
        return DaysLow;
    }

    /**
     * 
     * @param DaysLow
     *     The DaysLow
     */
    @JsonProperty("DaysLow")
    public void setDaysLow(String DaysLow) {
        this.DaysLow = DaysLow;
    }

    /**
     * 
     * @return
     *     The DaysHigh
     */
    @JsonProperty("DaysHigh")
    public String getDaysHigh() {
        return DaysHigh;
    }

    /**
     * 
     * @param DaysHigh
     *     The DaysHigh
     */
    @JsonProperty("DaysHigh")
    public void setDaysHigh(String DaysHigh) {
        this.DaysHigh = DaysHigh;
    }

    /**
     * 
     * @return
     *     The YearLow
     */
    @JsonProperty("YearLow")
    public String getYearLow() {
        return YearLow;
    }

    /**
     * 
     * @param YearLow
     *     The YearLow
     */
    @JsonProperty("YearLow")
    public void setYearLow(String YearLow) {
        this.YearLow = YearLow;
    }

    /**
     * 
     * @return
     *     The YearHigh
     */
    @JsonProperty("YearHigh")
    public String getYearHigh() {
        return YearHigh;
    }

    /**
     * 
     * @param YearHigh
     *     The YearHigh
     */
    @JsonProperty("YearHigh")
    public void setYearHigh(String YearHigh) {
        this.YearHigh = YearHigh;
    }

    /**
     * 
     * @return
     *     The HoldingsGainPercent
     */
    @JsonProperty("HoldingsGainPercent")
    public Object getHoldingsGainPercent() {
        return HoldingsGainPercent;
    }

    /**
     * 
     * @param HoldingsGainPercent
     *     The HoldingsGainPercent
     */
    @JsonProperty("HoldingsGainPercent")
    public void setHoldingsGainPercent(Object HoldingsGainPercent) {
        this.HoldingsGainPercent = HoldingsGainPercent;
    }

    /**
     * 
     * @return
     *     The AnnualizedGain
     */
    @JsonProperty("AnnualizedGain")
    public Object getAnnualizedGain() {
        return AnnualizedGain;
    }

    /**
     * 
     * @param AnnualizedGain
     *     The AnnualizedGain
     */
    @JsonProperty("AnnualizedGain")
    public void setAnnualizedGain(Object AnnualizedGain) {
        this.AnnualizedGain = AnnualizedGain;
    }

    /**
     * 
     * @return
     *     The HoldingsGain
     */
    @JsonProperty("HoldingsGain")
    public Object getHoldingsGain() {
        return HoldingsGain;
    }

    /**
     * 
     * @param HoldingsGain
     *     The HoldingsGain
     */
    @JsonProperty("HoldingsGain")
    public void setHoldingsGain(Object HoldingsGain) {
        this.HoldingsGain = HoldingsGain;
    }

    /**
     * 
     * @return
     *     The HoldingsGainPercentRealtime
     */
    @JsonProperty("HoldingsGainPercentRealtime")
    public Object getHoldingsGainPercentRealtime() {
        return HoldingsGainPercentRealtime;
    }

    /**
     * 
     * @param HoldingsGainPercentRealtime
     *     The HoldingsGainPercentRealtime
     */
    @JsonProperty("HoldingsGainPercentRealtime")
    public void setHoldingsGainPercentRealtime(Object HoldingsGainPercentRealtime) {
        this.HoldingsGainPercentRealtime = HoldingsGainPercentRealtime;
    }

    /**
     * 
     * @return
     *     The HoldingsGainRealtime
     */
    @JsonProperty("HoldingsGainRealtime")
    public Object getHoldingsGainRealtime() {
        return HoldingsGainRealtime;
    }

    /**
     * 
     * @param HoldingsGainRealtime
     *     The HoldingsGainRealtime
     */
    @JsonProperty("HoldingsGainRealtime")
    public void setHoldingsGainRealtime(Object HoldingsGainRealtime) {
        this.HoldingsGainRealtime = HoldingsGainRealtime;
    }

    /**
     * 
     * @return
     *     The MoreInfo
     */
    @JsonProperty("MoreInfo")
    public Object getMoreInfo() {
        return MoreInfo;
    }

    /**
     * 
     * @param MoreInfo
     *     The MoreInfo
     */
    @JsonProperty("MoreInfo")
    public void setMoreInfo(Object MoreInfo) {
        this.MoreInfo = MoreInfo;
    }

    /**
     * 
     * @return
     *     The OrderBookRealtime
     */
    @JsonProperty("OrderBookRealtime")
    public Object getOrderBookRealtime() {
        return OrderBookRealtime;
    }

    /**
     * 
     * @param OrderBookRealtime
     *     The OrderBookRealtime
     */
    @JsonProperty("OrderBookRealtime")
    public void setOrderBookRealtime(Object OrderBookRealtime) {
        this.OrderBookRealtime = OrderBookRealtime;
    }

    /**
     * 
     * @return
     *     The MarketCapitalization
     */
    @JsonProperty("MarketCapitalization")
    public String getMarketCapitalization() {
        return MarketCapitalization;
    }

    /**
     * 
     * @param MarketCapitalization
     *     The MarketCapitalization
     */
    @JsonProperty("MarketCapitalization")
    public void setMarketCapitalization(String MarketCapitalization) {
        this.MarketCapitalization = MarketCapitalization;
    }

    /**
     * 
     * @return
     *     The MarketCapRealtime
     */
    @JsonProperty("MarketCapRealtime")
    public Object getMarketCapRealtime() {
        return MarketCapRealtime;
    }

    /**
     * 
     * @param MarketCapRealtime
     *     The MarketCapRealtime
     */
    @JsonProperty("MarketCapRealtime")
    public void setMarketCapRealtime(Object MarketCapRealtime) {
        this.MarketCapRealtime = MarketCapRealtime;
    }

    /**
     * 
     * @return
     *     The EBITDA
     */
    @JsonProperty("EBITDA")
    public String getEBITDA() {
        return EBITDA;
    }

    /**
     * 
     * @param EBITDA
     *     The EBITDA
     */
    @JsonProperty("EBITDA")
    public void setEBITDA(String EBITDA) {
        this.EBITDA = EBITDA;
    }

    /**
     * 
     * @return
     *     The ChangeFromYearLow
     */
    @JsonProperty("ChangeFromYearLow")
    public String getChangeFromYearLow() {
        return ChangeFromYearLow;
    }

    /**
     * 
     * @param ChangeFromYearLow
     *     The ChangeFromYearLow
     */
    @JsonProperty("ChangeFromYearLow")
    public void setChangeFromYearLow(String ChangeFromYearLow) {
        this.ChangeFromYearLow = ChangeFromYearLow;
    }

    /**
     * 
     * @return
     *     The PercentChangeFromYearLow
     */
    @JsonProperty("PercentChangeFromYearLow")
    public String getPercentChangeFromYearLow() {
        return PercentChangeFromYearLow;
    }

    /**
     * 
     * @param PercentChangeFromYearLow
     *     The PercentChangeFromYearLow
     */
    @JsonProperty("PercentChangeFromYearLow")
    public void setPercentChangeFromYearLow(String PercentChangeFromYearLow) {
        this.PercentChangeFromYearLow = PercentChangeFromYearLow;
    }

    /**
     * 
     * @return
     *     The LastTradeRealtimeWithTime
     */
    @JsonProperty("LastTradeRealtimeWithTime")
    public Object getLastTradeRealtimeWithTime() {
        return LastTradeRealtimeWithTime;
    }

    /**
     * 
     * @param LastTradeRealtimeWithTime
     *     The LastTradeRealtimeWithTime
     */
    @JsonProperty("LastTradeRealtimeWithTime")
    public void setLastTradeRealtimeWithTime(Object LastTradeRealtimeWithTime) {
        this.LastTradeRealtimeWithTime = LastTradeRealtimeWithTime;
    }

    /**
     * 
     * @return
     *     The ChangePercentRealtime
     */
    @JsonProperty("ChangePercentRealtime")
    public Object getChangePercentRealtime() {
        return ChangePercentRealtime;
    }

    /**
     * 
     * @param ChangePercentRealtime
     *     The ChangePercentRealtime
     */
    @JsonProperty("ChangePercentRealtime")
    public void setChangePercentRealtime(Object ChangePercentRealtime) {
        this.ChangePercentRealtime = ChangePercentRealtime;
    }

    /**
     * 
     * @return
     *     The ChangeFromYearHigh
     */
    @JsonProperty("ChangeFromYearHigh")
    public String getChangeFromYearHigh() {
        return ChangeFromYearHigh;
    }

    /**
     * 
     * @param ChangeFromYearHigh
     *     The ChangeFromYearHigh
     */
    @JsonProperty("ChangeFromYearHigh")
    public void setChangeFromYearHigh(String ChangeFromYearHigh) {
        this.ChangeFromYearHigh = ChangeFromYearHigh;
    }

    /**
     * 
     * @return
     *     The PercebtChangeFromYearHigh
     */
    @JsonProperty("PercebtChangeFromYearHigh")
    public String getPercebtChangeFromYearHigh() {
        return PercebtChangeFromYearHigh;
    }

    /**
     * 
     * @param PercebtChangeFromYearHigh
     *     The PercebtChangeFromYearHigh
     */
    @JsonProperty("PercebtChangeFromYearHigh")
    public void setPercebtChangeFromYearHigh(String PercebtChangeFromYearHigh) {
        this.PercebtChangeFromYearHigh = PercebtChangeFromYearHigh;
    }

    /**
     * 
     * @return
     *     The LastTradeWithTime
     */
    @JsonProperty("LastTradeWithTime")
    public String getLastTradeWithTime() {
        return LastTradeWithTime;
    }

    /**
     * 
     * @param LastTradeWithTime
     *     The LastTradeWithTime
     */
    @JsonProperty("LastTradeWithTime")
    public void setLastTradeWithTime(String LastTradeWithTime) {
        this.LastTradeWithTime = LastTradeWithTime;
    }

    /**
     * 
     * @return
     *     The LastTradePriceOnly
     */
    @JsonProperty("LastTradePriceOnly")
    public String getLastTradePriceOnly() {
        return LastTradePriceOnly;
    }

    /**
     * 
     * @param LastTradePriceOnly
     *     The LastTradePriceOnly
     */
    @JsonProperty("LastTradePriceOnly")
    public void setLastTradePriceOnly(String LastTradePriceOnly) {
        this.LastTradePriceOnly = LastTradePriceOnly;
    }

    /**
     * 
     * @return
     *     The HighLimit
     */
    @JsonProperty("HighLimit")
    public Object getHighLimit() {
        return HighLimit;
    }

    /**
     * 
     * @param HighLimit
     *     The HighLimit
     */
    @JsonProperty("HighLimit")
    public void setHighLimit(Object HighLimit) {
        this.HighLimit = HighLimit;
    }

    /**
     * 
     * @return
     *     The LowLimit
     */
    @JsonProperty("LowLimit")
    public Object getLowLimit() {
        return LowLimit;
    }

    /**
     * 
     * @param LowLimit
     *     The LowLimit
     */
    @JsonProperty("LowLimit")
    public void setLowLimit(Object LowLimit) {
        this.LowLimit = LowLimit;
    }

    /**
     * 
     * @return
     *     The DaysRange
     */
    @JsonProperty("DaysRange")
    public String getDaysRange() {
        return DaysRange;
    }

    /**
     * 
     * @param DaysRange
     *     The DaysRange
     */
    @JsonProperty("DaysRange")
    public void setDaysRange(String DaysRange) {
        this.DaysRange = DaysRange;
    }

    /**
     * 
     * @return
     *     The DaysRangeRealtime
     */
    @JsonProperty("DaysRangeRealtime")
    public Object getDaysRangeRealtime() {
        return DaysRangeRealtime;
    }

    /**
     * 
     * @param DaysRangeRealtime
     *     The DaysRangeRealtime
     */
    @JsonProperty("DaysRangeRealtime")
    public void setDaysRangeRealtime(Object DaysRangeRealtime) {
        this.DaysRangeRealtime = DaysRangeRealtime;
    }

    /**
     * 
     * @return
     *     The FiftydayMovingAverage
     */
    @JsonProperty("FiftydayMovingAverage")
    public String getFiftydayMovingAverage() {
        return FiftydayMovingAverage;
    }

    /**
     * 
     * @param FiftydayMovingAverage
     *     The FiftydayMovingAverage
     */
    @JsonProperty("FiftydayMovingAverage")
    public void setFiftydayMovingAverage(String FiftydayMovingAverage) {
        this.FiftydayMovingAverage = FiftydayMovingAverage;
    }

    /**
     * 
     * @return
     *     The TwoHundreddayMovingAverage
     */
    @JsonProperty("TwoHundreddayMovingAverage")
    public String getTwoHundreddayMovingAverage() {
        return TwoHundreddayMovingAverage;
    }

    /**
     * 
     * @param TwoHundreddayMovingAverage
     *     The TwoHundreddayMovingAverage
     */
    @JsonProperty("TwoHundreddayMovingAverage")
    public void setTwoHundreddayMovingAverage(String TwoHundreddayMovingAverage) {
        this.TwoHundreddayMovingAverage = TwoHundreddayMovingAverage;
    }

    /**
     * 
     * @return
     *     The ChangeFromTwoHundreddayMovingAverage
     */
    @JsonProperty("ChangeFromTwoHundreddayMovingAverage")
    public String getChangeFromTwoHundreddayMovingAverage() {
        return ChangeFromTwoHundreddayMovingAverage;
    }

    /**
     * 
     * @param ChangeFromTwoHundreddayMovingAverage
     *     The ChangeFromTwoHundreddayMovingAverage
     */
    @JsonProperty("ChangeFromTwoHundreddayMovingAverage")
    public void setChangeFromTwoHundreddayMovingAverage(String ChangeFromTwoHundreddayMovingAverage) {
        this.ChangeFromTwoHundreddayMovingAverage = ChangeFromTwoHundreddayMovingAverage;
    }

    /**
     * 
     * @return
     *     The PercentChangeFromTwoHundreddayMovingAverage
     */
    @JsonProperty("PercentChangeFromTwoHundreddayMovingAverage")
    public String getPercentChangeFromTwoHundreddayMovingAverage() {
        return PercentChangeFromTwoHundreddayMovingAverage;
    }

    /**
     * 
     * @param PercentChangeFromTwoHundreddayMovingAverage
     *     The PercentChangeFromTwoHundreddayMovingAverage
     */
    @JsonProperty("PercentChangeFromTwoHundreddayMovingAverage")
    public void setPercentChangeFromTwoHundreddayMovingAverage(String PercentChangeFromTwoHundreddayMovingAverage) {
        this.PercentChangeFromTwoHundreddayMovingAverage = PercentChangeFromTwoHundreddayMovingAverage;
    }

    /**
     * 
     * @return
     *     The ChangeFromFiftydayMovingAverage
     */
    @JsonProperty("ChangeFromFiftydayMovingAverage")
    public String getChangeFromFiftydayMovingAverage() {
        return ChangeFromFiftydayMovingAverage;
    }

    /**
     * 
     * @param ChangeFromFiftydayMovingAverage
     *     The ChangeFromFiftydayMovingAverage
     */
    @JsonProperty("ChangeFromFiftydayMovingAverage")
    public void setChangeFromFiftydayMovingAverage(String ChangeFromFiftydayMovingAverage) {
        this.ChangeFromFiftydayMovingAverage = ChangeFromFiftydayMovingAverage;
    }

    /**
     * 
     * @return
     *     The PercentChangeFromFiftydayMovingAverage
     */
    @JsonProperty("PercentChangeFromFiftydayMovingAverage")
    public String getPercentChangeFromFiftydayMovingAverage() {
        return PercentChangeFromFiftydayMovingAverage;
    }

    /**
     * 
     * @param PercentChangeFromFiftydayMovingAverage
     *     The PercentChangeFromFiftydayMovingAverage
     */
    @JsonProperty("PercentChangeFromFiftydayMovingAverage")
    public void setPercentChangeFromFiftydayMovingAverage(String PercentChangeFromFiftydayMovingAverage) {
        this.PercentChangeFromFiftydayMovingAverage = PercentChangeFromFiftydayMovingAverage;
    }

    /**
     * 
     * @return
     *     The Name
     */
    @JsonProperty("Name")
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name
     *     The Name
     */
    @JsonProperty("Name")
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 
     * @return
     *     The Notes
     */
    @JsonProperty("Notes")
    public Object getNotes() {
        return Notes;
    }

    /**
     * 
     * @param Notes
     *     The Notes
     */
    @JsonProperty("Notes")
    public void setNotes(Object Notes) {
        this.Notes = Notes;
    }

    /**
     * 
     * @return
     *     The Open
     */
    @JsonProperty("Open")
    public String getOpen() {
        return Open;
    }

    /**
     * 
     * @param Open
     *     The Open
     */
    @JsonProperty("Open")
    public void setOpen(String Open) {
        this.Open = Open;
    }

    /**
     * 
     * @return
     *     The PreviousClose
     */
    @JsonProperty("PreviousClose")
    public String getPreviousClose() {
        return PreviousClose;
    }

    /**
     * 
     * @param PreviousClose
     *     The PreviousClose
     */
    @JsonProperty("PreviousClose")
    public void setPreviousClose(String PreviousClose) {
        this.PreviousClose = PreviousClose;
    }

    /**
     * 
     * @return
     *     The PricePaid
     */
    @JsonProperty("PricePaid")
    public Object getPricePaid() {
        return PricePaid;
    }

    /**
     * 
     * @param PricePaid
     *     The PricePaid
     */
    @JsonProperty("PricePaid")
    public void setPricePaid(Object PricePaid) {
        this.PricePaid = PricePaid;
    }

    /**
     * 
     * @return
     *     The ChangeinPercent
     */
    @JsonProperty("ChangeinPercent")
    public String getChangeinPercent() {
        return ChangeinPercent;
    }

    /**
     * 
     * @param ChangeinPercent
     *     The ChangeinPercent
     */
    @JsonProperty("ChangeinPercent")
    public void setChangeinPercent(String ChangeinPercent) {
        this.ChangeinPercent = ChangeinPercent;
    }

    /**
     * 
     * @return
     *     The PriceSales
     */
    @JsonProperty("PriceSales")
    public String getPriceSales() {
        return PriceSales;
    }

    /**
     * 
     * @param PriceSales
     *     The PriceSales
     */
    @JsonProperty("PriceSales")
    public void setPriceSales(String PriceSales) {
        this.PriceSales = PriceSales;
    }

    /**
     * 
     * @return
     *     The PriceBook
     */
    @JsonProperty("PriceBook")
    public String getPriceBook() {
        return PriceBook;
    }

    /**
     * 
     * @param PriceBook
     *     The PriceBook
     */
    @JsonProperty("PriceBook")
    public void setPriceBook(String PriceBook) {
        this.PriceBook = PriceBook;
    }

    /**
     * 
     * @return
     *     The ExDividendDate
     */
    @JsonProperty("ExDividendDate")
    public String getExDividendDate() {
        return ExDividendDate;
    }

    /**
     * 
     * @param ExDividendDate
     *     The ExDividendDate
     */
    @JsonProperty("ExDividendDate")
    public void setExDividendDate(String ExDividendDate) {
        this.ExDividendDate = ExDividendDate;
    }

    /**
     * 
     * @return
     *     The PERatio
     */
    @JsonProperty("PERatio")
    public String getPERatio() {
        return PERatio;
    }

    /**
     * 
     * @param PERatio
     *     The PERatio
     */
    @JsonProperty("PERatio")
    public void setPERatio(String PERatio) {
        this.PERatio = PERatio;
    }

    /**
     * 
     * @return
     *     The DividendPayDate
     */
    @JsonProperty("DividendPayDate")
    public String getDividendPayDate() {
        return DividendPayDate;
    }

    /**
     * 
     * @param DividendPayDate
     *     The DividendPayDate
     */
    @JsonProperty("DividendPayDate")
    public void setDividendPayDate(String DividendPayDate) {
        this.DividendPayDate = DividendPayDate;
    }

    /**
     * 
     * @return
     *     The PERatioRealtime
     */
    @JsonProperty("PERatioRealtime")
    public Object getPERatioRealtime() {
        return PERatioRealtime;
    }

    /**
     * 
     * @param PERatioRealtime
     *     The PERatioRealtime
     */
    @JsonProperty("PERatioRealtime")
    public void setPERatioRealtime(Object PERatioRealtime) {
        this.PERatioRealtime = PERatioRealtime;
    }

    /**
     * 
     * @return
     *     The PEGRatio
     */
    @JsonProperty("PEGRatio")
    public String getPEGRatio() {
        return PEGRatio;
    }

    /**
     * 
     * @param PEGRatio
     *     The PEGRatio
     */
    @JsonProperty("PEGRatio")
    public void setPEGRatio(String PEGRatio) {
        this.PEGRatio = PEGRatio;
    }

    /**
     * 
     * @return
     *     The PriceEPSEstimateCurrentYear
     */
    @JsonProperty("PriceEPSEstimateCurrentYear")
    public String getPriceEPSEstimateCurrentYear() {
        return PriceEPSEstimateCurrentYear;
    }

    /**
     * 
     * @param PriceEPSEstimateCurrentYear
     *     The PriceEPSEstimateCurrentYear
     */
    @JsonProperty("PriceEPSEstimateCurrentYear")
    public void setPriceEPSEstimateCurrentYear(String PriceEPSEstimateCurrentYear) {
        this.PriceEPSEstimateCurrentYear = PriceEPSEstimateCurrentYear;
    }

    /**
     * 
     * @return
     *     The PriceEPSEstimateNextYear
     */
    @JsonProperty("PriceEPSEstimateNextYear")
    public String getPriceEPSEstimateNextYear() {
        return PriceEPSEstimateNextYear;
    }

    /**
     * 
     * @param PriceEPSEstimateNextYear
     *     The PriceEPSEstimateNextYear
     */
    @JsonProperty("PriceEPSEstimateNextYear")
    public void setPriceEPSEstimateNextYear(String PriceEPSEstimateNextYear) {
        this.PriceEPSEstimateNextYear = PriceEPSEstimateNextYear;
    }

    /**
     * 
     * @return
     *     The Symbol
     */
    @JsonProperty("Symbol")
    public String getSymbol() {
        return Symbol;
    }

    /**
     * 
     * @param Symbol
     *     The Symbol
     */
    @JsonProperty("Symbol")
    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    /**
     * 
     * @return
     *     The SharesOwned
     */
    @JsonProperty("SharesOwned")
    public Object getSharesOwned() {
        return SharesOwned;
    }

    /**
     * 
     * @param SharesOwned
     *     The SharesOwned
     */
    @JsonProperty("SharesOwned")
    public void setSharesOwned(Object SharesOwned) {
        this.SharesOwned = SharesOwned;
    }

    /**
     * 
     * @return
     *     The ShortRatio
     */
    @JsonProperty("ShortRatio")
    public String getShortRatio() {
        return ShortRatio;
    }

    /**
     * 
     * @param ShortRatio
     *     The ShortRatio
     */
    @JsonProperty("ShortRatio")
    public void setShortRatio(String ShortRatio) {
        this.ShortRatio = ShortRatio;
    }

    /**
     * 
     * @return
     *     The LastTradeTime
     */
    @JsonProperty("LastTradeTime")
    public String getLastTradeTime() {
        return LastTradeTime;
    }

    /**
     * 
     * @param LastTradeTime
     *     The LastTradeTime
     */
    @JsonProperty("LastTradeTime")
    public void setLastTradeTime(String LastTradeTime) {
        this.LastTradeTime = LastTradeTime;
    }

    /**
     * 
     * @return
     *     The TickerTrend
     */
    @JsonProperty("TickerTrend")
    public Object getTickerTrend() {
        return TickerTrend;
    }

    /**
     * 
     * @param TickerTrend
     *     The TickerTrend
     */
    @JsonProperty("TickerTrend")
    public void setTickerTrend(Object TickerTrend) {
        this.TickerTrend = TickerTrend;
    }

    /**
     * 
     * @return
     *     The OneyrTargetPrice
     */
    @JsonProperty("OneyrTargetPrice")
    public String getOneyrTargetPrice() {
        return OneyrTargetPrice;
    }

    /**
     * 
     * @param OneyrTargetPrice
     *     The OneyrTargetPrice
     */
    @JsonProperty("OneyrTargetPrice")
    public void setOneyrTargetPrice(String OneyrTargetPrice) {
        this.OneyrTargetPrice = OneyrTargetPrice;
    }

    /**
     * 
     * @return
     *     The Volume
     */
    @JsonProperty("Volume")
    public String getVolume() {
        return Volume;
    }

    /**
     * 
     * @param Volume
     *     The Volume
     */
    @JsonProperty("Volume")
    public void setVolume(String Volume) {
        this.Volume = Volume;
    }

    /**
     * 
     * @return
     *     The HoldingsValue
     */
    @JsonProperty("HoldingsValue")
    public Object getHoldingsValue() {
        return HoldingsValue;
    }

    /**
     * 
     * @param HoldingsValue
     *     The HoldingsValue
     */
    @JsonProperty("HoldingsValue")
    public void setHoldingsValue(Object HoldingsValue) {
        this.HoldingsValue = HoldingsValue;
    }

    /**
     * 
     * @return
     *     The HoldingsValueRealtime
     */
    @JsonProperty("HoldingsValueRealtime")
    public Object getHoldingsValueRealtime() {
        return HoldingsValueRealtime;
    }

    /**
     * 
     * @param HoldingsValueRealtime
     *     The HoldingsValueRealtime
     */
    @JsonProperty("HoldingsValueRealtime")
    public void setHoldingsValueRealtime(Object HoldingsValueRealtime) {
        this.HoldingsValueRealtime = HoldingsValueRealtime;
    }

    /**
     * 
     * @return
     *     The YearRange
     */
    @JsonProperty("YearRange")
    public String getYearRange() {
        return YearRange;
    }

    /**
     * 
     * @param YearRange
     *     The YearRange
     */
    @JsonProperty("YearRange")
    public void setYearRange(String YearRange) {
        this.YearRange = YearRange;
    }

    /**
     * 
     * @return
     *     The DaysValueChange
     */
    @JsonProperty("DaysValueChange")
    public Object getDaysValueChange() {
        return DaysValueChange;
    }

    /**
     * 
     * @param DaysValueChange
     *     The DaysValueChange
     */
    @JsonProperty("DaysValueChange")
    public void setDaysValueChange(Object DaysValueChange) {
        this.DaysValueChange = DaysValueChange;
    }

    /**
     * 
     * @return
     *     The DaysValueChangeRealtime
     */
    @JsonProperty("DaysValueChangeRealtime")
    public Object getDaysValueChangeRealtime() {
        return DaysValueChangeRealtime;
    }

    /**
     * 
     * @param DaysValueChangeRealtime
     *     The DaysValueChangeRealtime
     */
    @JsonProperty("DaysValueChangeRealtime")
    public void setDaysValueChangeRealtime(Object DaysValueChangeRealtime) {
        this.DaysValueChangeRealtime = DaysValueChangeRealtime;
    }

    /**
     * 
     * @return
     *     The StockExchange
     */
    @JsonProperty("StockExchange")
    public String getStockExchange() {
        return StockExchange;
    }

    /**
     * 
     * @param StockExchange
     *     The StockExchange
     */
    @JsonProperty("StockExchange")
    public void setStockExchange(String StockExchange) {
        this.StockExchange = StockExchange;
    }

    /**
     * 
     * @return
     *     The DividendYield
     */
    @JsonProperty("DividendYield")
    public String getDividendYield() {
        return DividendYield;
    }

    /**
     * 
     * @param DividendYield
     *     The DividendYield
     */
    @JsonProperty("DividendYield")
    public void setDividendYield(String DividendYield) {
        this.DividendYield = DividendYield;
    }

    /**
     * 
     * @return
     *     The PercentChange
     */
    @JsonProperty("PercentChange")
    public String getPercentChange() {
        return PercentChange;
    }

    /**
     * 
     * @param PercentChange
     *     The PercentChange
     */
    @JsonProperty("PercentChange")
    public void setPercentChange(String PercentChange) {
        this.PercentChange = PercentChange;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
