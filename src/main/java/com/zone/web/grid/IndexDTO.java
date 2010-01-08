package com.zone.web.grid;

import java.util.LinkedList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zone.domain.model.IndexComponent;

@XStreamAlias("djia")
public class IndexDTO {

  private int totalRecords;
  private LinkedList <IndexComponent> indexComponents;

  public void setTotalRecords(int totalRecords) {
    this.totalRecords = totalRecords;
  }
  public void setComponents(LinkedList <IndexComponent> indexComponents) {
    this.indexComponents = indexComponents;
  }

  public int getTotalRecords() {
    return totalRecords;
  }
  public LinkedList <IndexComponent> getComponents() {
    return indexComponents;
  }

}
