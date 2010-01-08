package com.zone.infrastructure.updater;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zone.domain.model.IndexComponent;
import com.zone.infrastructure.repository.IndexRepository;

@Service
public class IndexUpdater  {

  Updater updater = null;
  ScheduledThreadPoolExecutor executor = null;
  ScheduledFuture <Updater> scheduledFuture = null;


  @SuppressWarnings("unchecked")
  public void startUpdater () {
    if (scheduledFuture == null || scheduledFuture.isCancelled() || scheduledFuture.isDone()) {
      scheduledFuture = (ScheduledFuture<Updater>) executor.scheduleAtFixedRate(updater, 0L, 900L, TimeUnit.MILLISECONDS);
    }
  }

  public void stopUpdater () {
    if (scheduledFuture != null && !scheduledFuture.isCancelled() && !scheduledFuture.isDone()) {
      scheduledFuture.cancel(true);
    }
  }

  @Autowired
  public IndexUpdater (IndexRepository indexRepository) {
    updater = new Updater (indexRepository);
    executor = new ScheduledThreadPoolExecutor(1);
  }

}

class Updater implements Runnable {

  IndexRepository indexRepository;
  Random randomGenerator = new Random();

  public Updater (IndexRepository indexRepository) {
    if (null == indexRepository)
      throw new IllegalArgumentException("IndexRepository can not be null");
    this.indexRepository = indexRepository;
  }

  public void run() {
    updateComponents ();
  }

  private void updateComponents () {

    Double valueChange;
    Double percentChange;
    Double price;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    for (IndexComponent indexComponent : indexRepository.findAll()) {
      percentChange = Double.valueOf (decimalFormat.format((400 - randomGenerator.nextInt(1000))/100.0));
      if (percentChange > -2 && percentChange < 2 && percentChange != 0.0) {
        valueChange = Double.valueOf (decimalFormat.format( indexComponent.getPrice()*(percentChange/100.0)));
        price =  indexComponent.getPrice() + valueChange;
        if (price > 5.0) {
          indexRepository.updateComponent(new IndexComponent (indexComponent.getSymbol(), indexComponent.getName(),
            price, valueChange, percentChange, new Date()));
        }
      }
    }
  }

}
