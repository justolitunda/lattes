package ke.ac.egerton.quality.component;


import ke.ac.egerton.quality.entity.Evaluate;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class EvaluatinComputationComponent {

    private static DecimalFormat df2 = new DecimalFormat("#.###");

    public void computeAverage(Evaluate evaluate){

        List<Integer> rating = this.paramterValuesAsList(evaluate);

        double average = 0;
        int total = 0;
        int count = 0;

        //Find sum
        for(int i: rating){
            total +=i;
            count ++;
         }

        //compute average
        if(count > 0 && total > 0){
            double to =  total /count;
          System.out.println(to +" "+ count);
           average = to;
        }



        evaluate.setAverage(average);
        evaluate.setTotalScore(total);


    }


    // input parameters as a list
    public List<Integer> paramterValuesAsList(Evaluate evaluate){
        List<Integer> values = new ArrayList<>();

        values.add(evaluate.getAttendance());
        values.add(evaluate.getTimelyCoverageOfOutline());
        values.add(evaluate.getAvailableForConsultations());
        values.add(evaluate.getCatFeedBack());
        values.add(evaluate.getCourseClarity());
        values.add(evaluate.getCreativity());
        values.add(evaluate.getEncouragesTeamWork());
        values.add(evaluate.getEnhancesProblemSolving());
        values.add(evaluate.getIctIntegration());
        values.add(evaluate.getIllustrations());
        values.add(evaluate.getMasteryOfSubjectMatter());
        values.add(evaluate.getMotivateStudent());
        values.add(evaluate.getPresentation());
        values.add(evaluate.getPromptAssignmentandFeedback());
        values.add(evaluate.getPunctualityToClass());
        values.add(evaluate.getRelevantAssignments());
        values.add(evaluate.getRelevantCats());
        values.add(evaluate.getStudentParticipation());

        return values;
    }
}
