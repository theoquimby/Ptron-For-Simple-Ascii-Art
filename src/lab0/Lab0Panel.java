package lab0;

import io.MyReader;
import io.MyWriter;
import java.io.File;
import java.util.ArrayList;
import lists.Pattern;
import lists.PatternList;

/**
 * Solution to Lab0
 *
 * @author levenick
 */
public class Lab0Panel extends javax.swing.JPanel {

    static final boolean DEBUG = false;
    // empty pattern list to be populated with patterns 
    PatternList patternsList;
    // temp array to hold inpit connversion
    int[][] input;
    //checksum stored temporarily for each pattern
    int t;
    int tries;
    int correct;
    int incorrect;
    int dimensions;
    pTron myPiTron;
    pTron myZTron;
    pTron myWTron;

    public Lab0Panel() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        theTA = new javax.swing.JTextArea();
        inputButton = new javax.swing.JButton();
        outputButton = new javax.swing.JButton();
        readPI = new javax.swing.JButton();
        readW = new javax.swing.JButton();
        readZ = new javax.swing.JButton();
        predict = new javax.swing.JButton();

        theTA.setColumns(20);
        theTA.setRows(5);
        jScrollPane1.setViewportView(theTA);

        inputButton.setText("input");
        inputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputButtonActionPerformed(evt);
            }
        });

        outputButton.setText("output");
        outputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputButtonActionPerformed(evt);
            }
        });

        readPI.setText("Read PI");
        readPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readPIActionPerformed(evt);
            }
        });

        readW.setText("Read W");
        readW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readWActionPerformed(evt);
            }
        });

        readZ.setText("Read Z");
        readZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readZActionPerformed(evt);
            }
        });

        predict.setText("Predict");
        predict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predictActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(outputButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addComponent(readW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(readPI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(readZ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(predict)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(readZ)
                            .addComponent(readPI)
                            .addComponent(readW)
                            .addComponent(predict)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(inputButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputButton)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputButtonActionPerformed
        emit("in!");
        //call file dialoug for input
        emit(readFile());
    }//GEN-LAST:event_inputButtonActionPerformed

    private void outputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputButtonActionPerformed
        emit("out!");
        //call file dialoug for output
        writeFile();
    }//GEN-LAST:event_outputButtonActionPerformed

    private void readPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readPIActionPerformed
        //read in PI directory and learn
        myPiTron = new pTron();
        beginLearningProc("pi", myPiTron);

    }//GEN-LAST:event_readPIActionPerformed

    private void readWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readWActionPerformed
        myWTron = new pTron();
        beginLearningProc("w", myWTron);
    }//GEN-LAST:event_readWActionPerformed

    private void readZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readZActionPerformed
        myZTron = new pTron();
        beginLearningProc("z", myZTron);
    }//GEN-LAST:event_readZActionPerformed

    private void predictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predictActionPerformed
        predict();
    }//GEN-LAST:event_predictActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inputButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton outputButton;
    private javax.swing.JButton predict;
    private javax.swing.JButton readPI;
    private javax.swing.JButton readW;
    private javax.swing.JButton readZ;
    private javax.swing.JTextArea theTA;
    // End of variables declaration//GEN-END:variables

    /**
     * Reads and echoes all the files in the src/lists directory + the given
     * extension, in the current project. Uses the instance variable PatternList
     * patterns spews each pattern into the text area sends each pattern to be
     * converted
     */
    void beginLearningProc(String extension, pTron currentTron) {
        String projectRoot = System.getProperty("user.dir");

        //input data from each directory
        inputData(new File(projectRoot + "/src/ptronData/" + extension));
        //myTron.initWeights(21);
        debug("PatternList size = " + (patternsList.size() / 2));

        //output all read in data and send each pattern to convert
        for (Pattern p : patternsList) {
            //output to the text area
            spew(p);
            //convert each pattern p into inputs 
            convert(p, currentTron);
            //debug(p.toString());
        }
    }

    /**
     * Reads all the files from the parameter, and makes a pattern out of any
     * which is a regular file and not hidden. The others are cheerfully
     * ignored!
     *
     * @param directory
     */
    public void inputData(File directory) {
        patternsList = new PatternList();

        debug("\n " + directory + "\n");

        File[] list = directory.listFiles();
        if (list == null) {
            System.out.println("This directory could not be opened!! => " + directory);
            System.exit(234);   // goodbye...
        }
        for (int i = 0; i < list.length; i++) {
            debug("reading... " + list[i]);

            if (list[i].isFile() && !list[i].isHidden()) {
                if (list[i].length() != 0) {
                    patternsList.add(new Pattern(list[i].getAbsolutePath()));
                }
            }
        }
    }

    //convert char input to 1's and 0's
    void convert(Pattern currentPattern, pTron currentPtron) {
        Pattern nuPattern = currentPattern;
        debug("current parttern = " + nuPattern.toString());

        int[][] convertedInput = new int[nuPattern.list.size()][nuPattern.list.size()];

        for (int i = 0; i < nuPattern.list.size(); i++) {
            debug("pattern[i] = " + nuPattern.list.get(i));
            for (int j = 0; j < nuPattern.list.get(i).length(); j++) {
                if (nuPattern.list.get(i).charAt(j) == '-') {
                    convertedInput[i][j] = 0;
                } else if (nuPattern.list.get(i).charAt(j) == '*') {
                    convertedInput[i][j] = 1;
                } else if (nuPattern.list.get(i).charAt(j) == 'y') {
                    convertedInput[i][j] = 0;
                    System.out.println("TRUE");
                    t = 1;
                } else if (nuPattern.list.get(i).charAt(j) == 'n') {
                    convertedInput[i][j] = 0;
                    t = 0;
                    System.out.println("FALSE");
                }

            }

        }
        
        debug("t= " + t);
        currentPtron.catagorize(convertedInput, t);
        System.out.println("double checking..");
        spewArray(convertedInput);
        System.out.println("back fo the next one !");

    }

    /**
     * Reads a file from wherever the user chooses, concatenates it into one
     * giant String and returns it.
     *
     * @return
     */
    private String readFile() {
        String returnMe = "\n\nThe contents of the file is:\n";
        MyReader mr = new MyReader();
        while (mr.hasMoreData()) {
            String s = mr.giveMeTheNextLine();
            returnMe += s + "\n";
        }

        mr.close();
        return returnMe;
    }

    private void writeFile() {
        MyWriter mr = new MyWriter();
        mr.println(theTA.getText());
        mr.close();
    }

    void loopDirs() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("pi");
        //list.add("w");
        //list.add("z");
        //loop through directories       
        for (int i = 0; i < list.size(); i++) {
            //beginLearningProc(list.get(i));
        }

    }

    /**
     * emits the Pattern!
     *
     * @param p -- the Pattern
     */
    void spew(Pattern p) {
        emit(p.toString() + "\n");
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

    private void getData() {

    }

    /**
     * Convenience method so I don't have to type theTA.append and ... + "\n"
     * over and over ...and so if I want to direct the output somewhere else I
     * can easily.
     *
     * @param s
     */
    private void emit(String s) {
        theTA.append(s + "\n");
    }

    void spewArray(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print("" + input[i][j]);
            }
            System.out.println("");

        }
        System.out.println("");
    }

    private void predict() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
