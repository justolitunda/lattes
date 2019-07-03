package ke.ac.egerton.quality.controller;

import ke.ac.egerton.quality.EvaluationRepository;
import ke.ac.egerton.quality.component.EvaluatinComputationComponent;
import ke.ac.egerton.quality.entity.Evaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EvaluateController {

    @Autowired
    private EvaluatinComputationComponent evaluatinComputationComponent;

    @Autowired
    private EvaluationRepository evaluationRepository;


    @GetMapping(value = "/evaluate")
    public String evaluateStaff(Model model) {
        model.addAttribute("evaluateObject",new Evaluate());

        return "evaluate";
    }



    @PostMapping("/evaluate")
    public String saveEvaluateFeedBack(@ModelAttribute Evaluate evaluate, BindingResult result,Model model){

        evaluatinComputationComponent.computeAverage(evaluate);
        evaluationRepository.save(evaluate);

        model.addAttribute("evaluateObject",new Evaluate());
        return "evaluate";

    }


// Map to return evaluation levels
    @ModelAttribute("rates")
    public Map<Integer,String> getScore() {
        Map<Integer,String> score = new HashMap<>();

            score.put(5,"Very Good");
            score.put(4,"Good");
            score.put(3,"Fair");
            score.put(2,"Poor");
            score.put(1,"Very Poor");

        return score;
    }


    // To return keys used in Map in rates attributes for logical retrieval
    @ModelAttribute("keys")
    public List<Integer> getKeys(){
        List<Integer> keys = new ArrayList<>();
        keys.add(5);
        keys.add(4);
        keys.add(3);
        keys.add(2);
        keys.add(1);
        return keys;
    }




}
