package com.zone.domain.model;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("component")
public class IndexComponent {

  private String symbol;
  private String name;
  private Double price;
  @XStreamAlias("valChange")
  private Double valueChange;
  @XStreamAlias("pctChange")
  private Double percentChange;
  private Date lastUpdate;

  public IndexComponent () {
    super ();
  }

  public IndexComponent(String symbol, String name, Double price, Double valueChange, Double percentChange, Date lastUpdate) {
    super();
    this.symbol = symbol;
    this.name = name;
    this.price = price;
    this.valueChange = valueChange;
    this.percentChange = percentChange;
    this.lastUpdate = lastUpdate;
  }

  public IndexComponent(IndexComponent indexComponent) {
    super();
    this.symbol = indexComponent.symbol;
    this.name = indexComponent.name;
    this.price = indexComponent.price;
    this.valueChange = indexComponent.valueChange;
    this.percentChange = indexComponent.percentChange;
    this.lastUpdate = new Date(indexComponent.lastUpdate.getTime());
  }

  public String getSymbol() {
    return symbol;
  }
  public String getName() {
    return name;
  }
  public Double getPrice() {
    return price;
  }
  public Double getValueChange() {
    return valueChange;
  }
  public Double getPercentChange() {
    return percentChange;
  }
  public Date getLastUpdate() {
    return lastUpdate;
  }

}
