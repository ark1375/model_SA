
package ku.cs.model.sa;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import java.util.Random;
import java.lang.Math;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.shape.random.RandomPointsBuilder;

/* Test this Class*/

public class OptimizedWalk {
    
    private Polygon poly;
    private int defaultK;
    private int movingThreshold;
    private double agentPace;
    private double deteriorationRate;
    private int monteCarloItterations;
    private int numberOfInitialPopulation;
    private int numberOfSelectedPopulation;
    private double monteCarloErrorThreshold ;
    public boolean showTextWhenRunning = false;

    private ArrayList<Agent> population = new ArrayList<>();

    public OptimizedWalk(
            Polygon poly,
            int defaultK,
            int movingThreshold,
            double agentPace,
            double deteriorationRate,
            int monteCarloItterations,
            int numberOfInitialPopulation,
            int numberOfSelectedPopulation,
            double monteCarloErrorThreshold,
            boolean showTextWhenRunning){
        
        this.poly = poly;
        this.defaultK = defaultK;
        this.movingThreshold = movingThreshold;
        this.agentPace = agentPace;
        this.deteriorationRate = deteriorationRate;
        this.monteCarloItterations = monteCarloItterations;
        this.numberOfInitialPopulation = numberOfInitialPopulation;
        this.numberOfSelectedPopulation = numberOfSelectedPopulation;
        this.monteCarloErrorThreshold = monteCarloErrorThreshold;
        this.showTextWhenRunning = showTextWhenRunning;
        
        for(int i = 0; i < numberOfInitialPopulation ; i++){
            population.add(new Agent());
//            System.out.printf("Agent #%d Added\n",i);
        }
    }
    
    
    public OptimizedWalk(Polygon poly, OW_Config configs){
        
        this.poly = poly;
        this.defaultK = configs.getDefaultK();
        this.movingThreshold = configs.getMovingThreshold();
        this.agentPace = configs.getAgentPace();
        this.deteriorationRate = configs.getDeteriorationRate();
        this.monteCarloItterations = configs.getMonteCarloItterations();
        this.numberOfInitialPopulation = configs.getNumberOfInitialPopulation();
        this.numberOfSelectedPopulation = configs.getNumberOfSelectedPopulation();
        this.monteCarloErrorThreshold = configs.getMonteCarloErrorThreshold();
        this.showTextWhenRunning = configs.isShowTextWhenRunning();
        
        for(int i = 0; i < numberOfInitialPopulation ; i++){
            population.add(new Agent());
//            System.out.printf("Agent #%d Added\n",i);
        }
        
    }
    
    public void optimizePopulation(){
        population.sort(Comparator.comparing(OptimizedWalk.Agent::getCurrentFitness));
        Collections.reverse(population);
        
        if(showTextWhenRunning)
            System.out.println("Begin Optimization with OptimizedWalk");
        
        for (int i = 0 ; i < this.numberOfSelectedPopulation ; i++){
            
            if(showTextWhenRunning)
                System.out.printf("Optimizing Agent #%d\n  Starting fitness: %f" , i+1 ,population.get(i).currentFitness );
            
            population.get(i).optimize();
            
            if(showTextWhenRunning)
                System.out.printf(" -> End Fitness %f\n_________________________\n\n",population.get(i).currentFitness);            
        }
        
    }
    
    public ArrayList<Modem> getTopTen(){
        population.sort(Comparator.comparing(OptimizedWalk.Agent::getCurrentFitness));
        Collections.reverse(population);

        ArrayList<Modem> topTen = new ArrayList<>();
        
        for(int i=0 ; i < 10 ; i++)
            topTen.add(population.get(i).toModem());
        
        return topTen;
        
    }
    
    public ArrayList<Agent> getTopTenAgents(){
        population.sort(Comparator.comparing(OptimizedWalk.Agent::getCurrentFitness));
        Collections.reverse(population);

        ArrayList<Agent> topTen = new ArrayList<>();
        
        for(int i=0 ; i < 10 ; i++)
            topTen.add(population.get(i));
        
        return topTen;
        
    }

    public class Agent{
        
        Coordinate cord;
        double currentFitness = 0;
        int numberOfBadMoves = 0;
        boolean isActive = true;
        double currentPace = agentPace;
        
        ArrayList<Coordinate> history = new ArrayList<>();
        
        public Agent(){
            initialize();
        }
        
        private void initialize(){
            this.cord = poly.randomPoint();
            currentFitness = VPCalculator.monteCarloVP_MT(monteCarloItterations, poly, new Modem[]{new Modem(cord.x , cord.y , defaultK)}, 0);
            history.add(cord);
        }
       
        
        private void walk(){
            
            if (isActive){
                
                boolean validMove = false;
                
                while(!validMove){
                    double direction = new Random().nextDouble() * Math.PI;
                    direction *= new Random().nextInt(2) % 2 == 0 ? 1 : -1 ; 
                    double moveInX = currentPace * Math.cos(direction);
                    double moveInY = currentPace * Math.sin(direction);
                    
//                    System.out.println(Math.sin(direction));
//                    System.out.println(Math.cos(direction));
//                    System.out.printf("\nMove in X:%f , Move in Y:%f" ,moveInX,moveInY);
                    Coordinate newCord = new Coordinate(cord.x + moveInX , cord.y + moveInY);
                    
                    Point radnomPoint = new GeometryFactory().createPoint(newCord);
                    if( !poly.getPoly().contains(radnomPoint) ){
//                        System.out.printf("Finding random Point for %f , %f\n" , cord.x , cord.y);
                        continue;
                    }
                    
                    else{
                        validMove = true;
                        double movedFitness = VPCalculator.monteCarloVP_MT(
                            monteCarloItterations, poly, new Modem[]{new Modem(newCord.x , newCord.y , defaultK)}, 0);
                        
                        if (movedFitness - monteCarloErrorThreshold >= currentFitness || movedFitness + monteCarloErrorThreshold >= currentFitness){
                            currentFitness = movedFitness;
                            cord = newCord;
                            numberOfBadMoves = 0;
                            history.add(newCord);
                            deteriate();
//                            System.out.printf("%f   %f,\n" , cord.x , cord.y);
                        }
                        
                        else{
                            numberOfBadMoves ++;
//                            System.out.println("bad move");
                        }
                        
                        checkDeactivation();

                    }
                
                }
            }
            
        }
        
        public void optimize(){
            while(this.isActive)
                walk();
        }
        
        public void checkDeactivation(){
//            System.out.println(currentPace);
            if (isActive && numberOfBadMoves >= movingThreshold || isActive && this.currentPace <= 0.01 )
                isActive = false;
            
        }
        
        public void resetAgent(){
            history.clear();
            initialize();
        }
        
        private void deteriate(){
            this.currentPace -= deteriorationRate * this.currentPace;
        }
        
        public double getCurrentFitness(){
            return currentFitness;
        }
        
        public Modem toModem(){
            return new Modem(cord.x, cord.y, defaultK);
        }
        
    }
    




}


