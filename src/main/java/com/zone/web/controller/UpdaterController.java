package com.zone.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zone.infrastructure.updater.IndexUpdater;

@Controller
public class UpdaterController {

  @Autowired
  IndexUpdater indexUpdater;

  @RequestMapping(value = "/refresh")
  public void getComponents(@RequestParam("refresh") String go, Model model) {
    if (go.equals("start")) {
      indexUpdater.startUpdater();
      model.addAttribute("refresh", "start");
    } else if (go.equals("stop")) {
      indexUpdater.stopUpdater();
      model.addAttribute("refresh", "stop");
    }
  }

}
