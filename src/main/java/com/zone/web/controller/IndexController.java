package com.zone.web.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zone.domain.model.IndexComponent;
import com.zone.infrastructure.repository.IndexRepository;
import com.zone.web.grid.IndexDTO;

@Controller
public class IndexController {

  @Autowired
  IndexRepository indexRepository;

  @RequestMapping(value = "/djia")
  public void getComponents(@RequestParam("start") int start, @RequestParam("limit") int limit, Model model) {

    List <IndexComponent> indexComponents= (List<IndexComponent>) indexRepository.findAll();
    IndexDTO indexDTO = new IndexDTO ();

    indexDTO.setTotalRecords(indexComponents.size());
    indexDTO.setComponents(new LinkedList<IndexComponent> (indexComponents.subList(start, start+limit > indexComponents.size() ? indexComponents.size() : start+limit)));

    model.addAttribute("indexDTO", indexDTO);
  }

}
