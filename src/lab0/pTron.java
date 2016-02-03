/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab0;

import static lab0.Lab0Panel.DEBUG;

/**
 *
 * @author tquimby
 */
public class pTron {
//global varbiables
    boolean DEBUG = false;
    int[][] weights;
    int threshold = 700;
    boolean error;
    int category;
    int learningInc = 1;
    int o;
    int pos;
    int neg;
    int tries;
    int numPats;

    // ptron constructor
    public pTron() {
        initWeights(21);
        numPats = 0;

    }

    //catagorize based on weights times inputs against the threshold
    public void catagorize(int[][] inputsArray, int t) {

        numPats++;
        debug("Hello from catagorize ");
        //put the parameter into a local variable
        int[][] inputs = inputsArray;
        int nuT = t;
        System.out.println("inputs array =");
        spew(inputs);

        //assume the pattern is incorrect
        error = true;
        debug("error = " + error);

        //initilize tries to zero before entering the while loop with the next pattern
        tries = 0;

        //while loop used to categorize
        while (error) {

            //re initialize the sum to 0 for the next pattern
            System.out.println("hello from the while ");
            o = 0;
            System.out.println("new o = " + o);

            //leaves erroes set to false if the pattern is true, preventing further learning
            error = false;

            //debug code to check loop iteration lengths
            debug("inputs length = " + inputs.length);
            debug("weights length = " + weights.length);

            // nested for loop to calculate the sum of the inputs * weights
            for (int i = 0; i < inputs.length; i++) {
                for (int j = 0; j < inputs.length; j++) {
                    //spew(weights);
                    //spew(inputs);
                    //o = the sum of inputs*weights
                    o += inputs[i][j] * weights[i][j];

                    //System.out.println("in the for o = " + o);
                }
            }

            System.out.println("o finshed = " + o + " threshold = " + threshold);

            if (o > threshold) {
                category = 1;
            } else {
                //System.out.println("time to learn!");
                category = 0;
                //error = true;

            }
            debug("category =  " + category + " t = " + t );
            
            if(category==1 && t==1){
                pos++; 
                System.out.println("its a pos match");
            }
            else if(category==0 && t==0){
                neg++; 
                System.out.println("its a neg match");
            }
            
            else {
                System.out.println("time to learn!");
                error = true;
                learn(weights, inputs, nuT);
            }
               

        }
        System.out.println("Number of Pos Correct Pi's = " + pos + " Number of Patterns = " + numPats);
        System.out.println("Number of Neg Correct Pi's = " + neg + " Number of Patterns = " + numPats);
    }
    
//initialize all weights in table to zero each time a pattern is sent
    public void initWeights(int inputs) {
        weights = new int[inputs][inputs];
        debug("wight first element = " + weights[0][0]);

    }

    //adjusts weights according to learning rule
    private void learn(int[][] weights, int[][] inputs, int t) {
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights.length; j++) {
                weights[i][j] += (t - category) * inputs[i][j] * learningInc;
                debug("in learning");
                debug("learning inc = " + learningInc + "t = " + t + "category = " + category + "inputs[i][j] = " + inputs[i][j]);
                debug("weight inc = " + ((t - category) * inputs[i][j]) * learningInc);
                

            }
        }
        tries++;
        System.out.println("weights after learning loop = ");
        format(weights);
    }

    /**
     * souts the passed String, s, only if the DEBUG flag is on (saves typing!)
     *
     * @param s - the String to print if we are still debugging
     */
    void debug(String s) {
        if (DEBUG) {
            System.out.println(s);
        }
    }

    //output an inputed array list to the output window
    void spew(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print("" + input[i][j]);
            }
            System.out.println("");

        }
        System.out.println("");
    }

   
    //formates output to account for multiple didgets 
    private static void format(int [][] toFormat) {
        int[][] formatted = toFormat;
        for (int i = 0; i < formatted.length; i++) {
            for (int j = 0; j < formatted.length; j++) {
                formatted[i][j] = rand();
            }
            }
        
        for (int i = 0; i < formatted.length; i++) {
            for (int j = 0; j < formatted.length; j++) {
                System.out.print(" " + five(formatted[i][j]));
            }
            System.out.println("");
        }    }

    //rand method 
    private static int rand() {
        return (int) (Math.random() * 100) - 50;
    }

    
    //format spacing
    private static String five(int x) {
        String returnMe = ""+x;
        
        for (int  i= 5-returnMe.length(); i>0; i--)
            returnMe = " " + returnMe;
        return returnMe;
    }

    
    
    
}
