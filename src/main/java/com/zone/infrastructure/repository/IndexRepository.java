package com.zone.infrastructure.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import com.zone.domain.model.IndexComponent;

@Repository
public class IndexRepository {
  private final ConcurrentMap<String, IndexComponent> indexComponents = new ConcurrentHashMap<String, IndexComponent> ();

  public IndexRepository () {
    synchronized(this) {
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      try {
        IndexComponent indexComponent = null;
        indexComponent = new IndexComponent("MMM", "3M Co ",60.46,0.12,0.2, dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("MMM", indexComponent);
        indexComponent = new IndexComponent("AA", "Alcoa Inc ",11.49,0.34,3.05,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("AA", indexComponent);
        indexComponent = new IndexComponent("AXP", "American Express Co ",26.69,-0.24,-0.89,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("AXP", indexComponent);
        indexComponent = new IndexComponent("T", "AT&T Inc ",24.28,0.07,0.29,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("T", indexComponent);
        indexComponent = new IndexComponent("BAC", "Bank of America Corp ",11.98,-0.08,-0.66,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("BAC", indexComponent);
        indexComponent = new IndexComponent("BA", "Boeing Co",52.3,-0.05,-0.1,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("BA", indexComponent);
        indexComponent = new IndexComponent("CAT", "Caterpillar Inc",37.62,-0.62,-1.62,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("CAT", indexComponent);
        indexComponent = new IndexComponent("CVX", "Chevron Corp",70.22,0.03,0.04,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("CVX", indexComponent);
        indexComponent = new IndexComponent("CSCO", "Cisco Systems Inc",19.95,-0.13,-0.65,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("CSCO", indexComponent);
        indexComponent = new IndexComponent("DD", "E I du Pont de Nemours and Co",26.77,-0.16,-0.59,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("DD", indexComponent);
        indexComponent = new IndexComponent("XOM", "Exxon Mobil Corp",73.84,0.72,0.98,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("XOM", indexComponent);
        indexComponent = new IndexComponent("GE", "General Electric Co",13.4,-0.17,-1.25,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("GE", indexComponent);
        indexComponent = new IndexComponent("HPQ", "Hewlett-Packard Co",36.79,-0.05,-0.14,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("HPQ", indexComponent);
        indexComponent = new IndexComponent("INTC", "Intel Corp",16.46,0.04,0.24,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("INTC", indexComponent);
        indexComponent = new IndexComponent("IBM", "International Business Machines Corp",108.35,0.21,0.19,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("IBM", indexComponent);
        indexComponent = new IndexComponent("JNJ", "Johnson & Johnson",55.66,-0.04,-0.07,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("JNJ", indexComponent);
        indexComponent = new IndexComponent("JPM", "JPMorgan Chase & Co",34.84,-0.42,-1.19,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("JPM", indexComponent);
        indexComponent = new IndexComponent("KFT", "Kraft Foods Inc",25.85,-0.36,-1.37,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("KFT", indexComponent);
        indexComponent = new IndexComponent("MCD", "McDonald's Corp",58.36,-0.72,-1.22,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("MCD", indexComponent);
        indexComponent = new IndexComponent("MRK", "Merck & Co Inc",25.59,-0.13,-0.51,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("MRK", indexComponent);
        indexComponent = new IndexComponent("MSFT", "Microsoft Corp",22.55,0.47,2.13,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("MSFT", indexComponent);
        indexComponent = new IndexComponent("PFE", "Pfizer Inc",14.05,-0.08,-0.57,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("PFE", indexComponent);
        indexComponent = new IndexComponent("KO", "Coca-Cola Co",48.41,-0.68,-1.39,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("KO", indexComponent);
        indexComponent = new IndexComponent("HD", "The Home Depot Inc",24.39,0.04,0.16,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("HD", indexComponent);
        indexComponent = new IndexComponent("PG", "Procter & Gamble Co",52.08,-0.33,-0.63,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("PG", indexComponent);
        indexComponent = new IndexComponent("UTX", "United Technologies Corp",55.5,-0.02,-0.04,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("UTX", indexComponent);
        indexComponent = new IndexComponent("TRV", "Travelers Companies Inc",43.77,-0.27,-0.61,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("TRV", indexComponent);
        indexComponent = new IndexComponent("VZ", "Verizon Communications Inc",29.53,0.11,0.37,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("VZ", indexComponent);
        indexComponent = new IndexComponent("WMT", "Wal-Mart Stores Inc",50.06,-0.55,-1.09,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("WMT", indexComponent);
        indexComponent = new IndexComponent("DIS", "Walt Disney Co",25.1,-0.23,-0.91,dateFormat.parse("24/12/2009 15:00:00"));indexComponents.put("DIS", indexComponent);
      } catch (ParseException e) {
      }
    }
  }

  public IndexComponent getComponent(String symbol) {
    if (!indexComponents.containsKey(symbol)) {
      throw new IllegalArgumentException("invalid component symbol: " + symbol);
    }
    return new IndexComponent(indexComponents.get(symbol));
  }

  public void updateComponent (IndexComponent indexComponent) {
    if ( null == indexComponents.replace(indexComponent.getSymbol(), indexComponent) ) {
      throw new IllegalArgumentException("invalid component symbol: " + indexComponent.getSymbol());
    }
  }

  public Collection<IndexComponent> findAll() {
    List<IndexComponent> componentList = new LinkedList<IndexComponent> ();
    for (String symbol : indexComponents.keySet()) {
      componentList.add(new IndexComponent(indexComponents.get(symbol)));
    }
    return Collections.unmodifiableList(componentList);
  }

}
