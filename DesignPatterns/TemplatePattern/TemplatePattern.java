package DesignPatterns.TemplatePattern;

// ───────────────────────────────────────────────────────────
// 1. Base class defining the template method
// ───────────────────────────────────────────────────────────
abstract class ModelTrainer {
    // The template method-final so subclasses can't change the sequence
    public final void trainPipeline(String dataPath) {
        loadData(dataPath);
        preprocessData();
        trainModel();
        evaluateModel();
        saveModel();
    }

    protected void loadData(String path) {
        System.out.println("[Common] Loading dataset from" + path);
    }

    protected void preprocessData() {
        System.out.println("[Common] Splitting into train/test and normalizing");
    }

    protected abstract void trainModel();

    protected abstract void evaluateModel();

    protected void saveModel() {
        System.out.println("[Common] Saving model to disk as default format");
    }
}

// ───────────────────────────────────────────────────────────
// 2. Concrete subclass: Neural Network
// ───────────────────────────────────────────────────────────
class NeuralNetworkTrainer extends ModelTrainer {
    @Override
    protected void trainModel() {
        System.out.println("[NeuralNet] Training Neural Network for 100 epochs");

    }

    @Override
    protected void evaluateModel() {
        System.out.println("[NeuralNet] Evaluating accuracy and loss on validation set");
    }

    @Override
    protected void saveModel() {
        System.out.println("[NeuralNet] Serializing Network weights to .h5 file");
    }
}

// ───────────────────────────────────────────────────────────
// 3. Concrete Subclass: Decision Tree
// ───────────────────────────────────────────────────────────
class DecisionTreeTrainer extends ModelTrainer {
    @Override
    protected void trainModel() {
        System.out.println("[DecisionTree] Building decision tree with max_depth=5");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[DecisionTree] Computing classification report (precision/recall)");
    }
}

// ───────────────────────────────────────────────────────────
// 4.Usage
// ───────────────────────────────────────────────────────────

public class TemplatePattern {
    public static void main(String[] args) {
        System.out.println("=== Neural Network Training ===");
        ModelTrainer NNTrainer = new NeuralNetworkTrainer();
        NNTrainer.trainPipeline("data/images/");

        System.out.println("\n=== Decision Tree Training ===");
        ModelTrainer DTTrainer = new DecisionTreeTrainer();
        DTTrainer.trainPipeline("data/iris.csv");
    }
}
