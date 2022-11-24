package cn.aidawone.atomtestingjavajunit5.controllers;


import cn.aidawone.atomtestingjavajunit5.fauxspring.Model;
import cn.aidawone.atomtestingjavajunit5.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
