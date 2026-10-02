package org.example.TemplatePattern;

public class DecisionTreeTrainer extends ModelTrainer {

    @Override
    protected void trainModel() {
        System.out.println("[Decision Tree] Building decision tree with max depth = 10 & Gini Impurity...");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[Decision Tree] Computing confusion matrix & F1 score...");
    }

}