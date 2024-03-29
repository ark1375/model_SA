
package ku.cs.model.sa;


public final class GA_Config {
    
    private int numberOfModems = 1;
    private int defaultKValue = 2;
    private int numberOfAllowedCollisions = 0;
    private int monteCarloItterations = 1000;
    private int geneticPopulation = 200;
    private int numberOfGenerations = 20;
    private double mutationRate = 0.1;
    private boolean multiThreading = false;
    public boolean showTextWhenRunning = false;
    
    GA_Config(
            int monteCarloItterations,
            int geneticPopulation,
            int numberOfGenerations,
            int numberOfModems,
            int defaultKValue,
            int numberOfAllowedCollisions,
            double mutationRate,
            boolean multiThreading ,
            boolean showTextWhenRunning){
        
        setNumberOfModems(numberOfModems);
        setDefaultKValue(defaultKValue);
        setNumberOfAllowedCollisions(numberOfAllowedCollisions);
        setMonteCarloItterations(monteCarloItterations);
        setGeneticPopulation(geneticPopulation);
        setNumberOfGenerations(numberOfGenerations);
        setMutationRate(mutationRate);
        setMultiThreading(multiThreading);
        setShowTextWhenRunning(showTextWhenRunning);
        
    }
    
    public GA_Config(){}
    
    
    public int getMonteCarloItterations() {
        return monteCarloItterations;
    }

    public void setMonteCarloItterations(int monteCarloItterations) {
        
        if ( monteCarloItterations >= 1 )
            this.monteCarloItterations = monteCarloItterations;
        
    }

    public int getGeneticPopulation() {
        return geneticPopulation;
    }

    public void setGeneticPopulation(int geneticPopulation) {
        if( geneticPopulation >= 10 )
            this.geneticPopulation = geneticPopulation;
    }

    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }

    public void setNumberOfGenerations(int numberOfGenerations) {
        if( numberOfGenerations >= 1 )
            this.numberOfGenerations = numberOfGenerations;
    }

    public int getNumberOfModems() {
        return numberOfModems;
    }

    public void setNumberOfModems(int numberOfModems) {
        if( numberOfModems >= 2 )
            this.numberOfModems = numberOfModems;
    }

    public int getDefaultKValue() {
        return defaultKValue;
    }

    public void setDefaultKValue(int defaultKValue) {
        
        if( defaultKValue >= 0 )
            this.defaultKValue = defaultKValue;
        
    }

    public int getNumberOfAllowedCollisions() {
        return numberOfAllowedCollisions;
    }

    public void setNumberOfAllowedCollisions(int numberOfAllowedCollisions) {
        if ( numberOfAllowedCollisions >= 0 && numberOfAllowedCollisions <= numberOfModems )
            this.numberOfAllowedCollisions = numberOfAllowedCollisions;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(double mutationRate) {
        if ( mutationRate >= 0 && mutationRate < 1 )
            this.mutationRate = mutationRate;
    }

    public boolean isMultiThreading() {
        return multiThreading;
    }

    public void setMultiThreading(boolean multiThreading) {
        this.multiThreading = multiThreading;
    }

    public boolean isShowTextWhenRunning() {
        return showTextWhenRunning;
    }

    public void setShowTextWhenRunning(boolean showTextWhenRunning) {
        this.showTextWhenRunning = showTextWhenRunning;
    }
    
    
    
    @Override
    public String toString(){
        return "Number of Modems: " + this.numberOfModems +
                "\nDefault Peneteration Value: " + this.defaultKValue +
                "\nNumber of Allowed Signal Collisions: " + this.numberOfAllowedCollisions +
                "\nMonte Carlo Itterations: " + this.monteCarloItterations +
                "\nGenetic Population: " + this.geneticPopulation +
                "\nNumber of Generations: " + this.numberOfGenerations +
                "\nMutation Rate: " + this.mutationRate +
                "\nUse Multi-Threading: " + this.multiThreading +
                "\nShow Text When Running: " + this.showTextWhenRunning;
    }
    
}
