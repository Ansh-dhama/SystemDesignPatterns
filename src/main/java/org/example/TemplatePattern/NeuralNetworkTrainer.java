package org.example.TemplatePattern;

public class NeuralNetworkTrainer extends ModelTrainer {

    @Override
    protected void trainModel() {
        System.out.println("[Neural Network] Training model over 100 epochs with Backpropagation...");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[Neural Network] Evaluating validation accuracy and loss metrics...");
    }

    // Optional override: Neural Network uses custom binary format for saving
    @Override
    protected void saveModel() {
        System.out.println("[Neural Network] Saving model as PyTorch weights (.pt format)...");
    }
}