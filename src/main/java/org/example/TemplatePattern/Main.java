package org.example.TemplatePattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Training Neural Network ===");
        ModelTrainer nnTrainer = new NeuralNetworkTrainer();
        nnTrainer.trainPipeline("/data/images_dataset.csv");

        System.out.println("\n=== Training Decision Tree ===");
        ModelTrainer dtTrainer = new DecisionTreeTrainer();
        dtTrainer.trainPipeline("/data/tabular_dataset.csv");
    }
}