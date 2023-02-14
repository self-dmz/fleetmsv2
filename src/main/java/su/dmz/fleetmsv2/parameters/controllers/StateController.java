package su.dmz.fleetmsv2.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import su.dmz.fleetmsv2.parameters.models.State;
import su.dmz.fleetmsv2.parameters.services.CountryService;
import su.dmz.fleetmsv2.parameters.services.StateService;

@Controller
public class StateController {

    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;

    public  Model addModelAttribute(Model model){
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return model;
    }

    //Get All States
    @GetMapping("/parameters/states")
    public String findAll(Model model){
        addModelAttribute(model);
        return "/parameters/states";
    }

    @GetMapping("/parameters/stateAdd")
    public String addState(Model model){
        addModelAttribute(model);
        return "/parameters/stateAdd";
    }

    @GetMapping("/parameters/state/{op}/{id}")
    public String editState(@PathVariable Integer id, @PathVariable String op, Model model){
        addModelAttribute(model);
        model.addAttribute("state", stateService.findById(id));
        return "/parameters/state" + op;
    }

    //Add State
    @PostMapping(value="/parameters/states")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/parameters/states";
    }

    @RequestMapping(value="/parameters/states/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        stateService.delete(id);
        return "redirect:/parameters/states";
    }



//    @GetMapping("/states")
//    public String getAll(Model model) {
//        List<State> states = stateService.findAll();
//        model.addAttribute("states", states);
//        return "parameters/stateList";
//    }
//
//    @GetMapping("/stateAdd")
//    public String addCState() {  return "parameters/stateAdd";  }
//
//    @GetMapping("/stateEdit/{id}")
//    public String editState(@PathVariable Integer id, Model model) {
//        State state = stateService.findById(id);
//        model.addAttribute("state", state);
//        return "parameters/stateEdit";
//    }
//
//    @PostMapping("/states")
//    public String save(State state) {
//        stateService.save(state);
//        return "redirect:/states";
//    }
//
//    @RequestMapping(value = "/states/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE} )
//    public String delete(@PathVariable Integer id) {
//        stateService.delete(id);
//        return "redirect:/states";
//    }
//
//    @RequestMapping(value = "/states/update/{id}", method = { RequestMethod.GET, RequestMethod.PUT} )
//    public String delete(State state) {
//        stateService.save(state);
//        return "redirect:/states";
//    }



}










