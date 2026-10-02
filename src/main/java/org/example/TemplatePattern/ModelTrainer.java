package org.example.TemplatePattern;

public abstract class ModelTrainer {

    // 1. TEMPLATE METHOD (Enforces the execution pipeline)
    // Marked 'final' so subclasses cannot alter the sequence of steps
    public final void trainPipeline(String dataPath) {
        loadData(dataPath);
        preprocessData();
        trainModel();
        evaluateModel();
        saveModel();
    }

    // 2. Concrete/Default Implementations (Common to all models)
    protected void loadData(String dataPath) {
        System.out.println("[Common] Loading dataset from: " + dataPath);
    }

    protected void preprocessData() {
        System.out.println("[Common] Preprocessing: Splitting train/test data & normalizing.");
    }

    protected void saveModel() {
        System.out.println("[Common] Saving trained model to default disk storage.");
    }

    // 3. Abstract Methods (Subclasses MUST implement these specific steps)
    protected abstract void trainModel();
    protected abstract void evaluateModel();
}