package ch.zhaw.projekt2.projekt2;

import ai.djl.Model;
import ai.djl.ModelException;
import ai.djl.training.Trainer;
import ai.djl.training.TrainingConfig;
import ai.djl.training.TrainingResult;
import ai.djl.training.dataset.RandomAccessDataset;
import ai.djl.util.Progress;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class TrainMnist {

    private static final int EPOCHS = 10;

    private TrainMnist() {}

    public static void main(String[] args) throws IOException, ModelException {
        List<String> synset = new ArrayList<>();
        synset.add("0");
        synset.add("1");
        synset.add("2");
        synset.add("3");
        synset.add("4");
        synset.add("5");
        synset.add("6");
        synset.add("7");
        synset.add("8");
        synset.add("9");

        Model model = Models.getModel();
        if (model == null) {
            // Handle error when model loading fails
            System.err.println("Failed to load the model.");
            return;
        }

        TrainingConfig config = Models.getTrainingConfig();
        Trainer trainer = model.newTrainer(config);

        RandomAccessDataset[] datasets = MnistDataLoader.loadData();

        trainer.setMetrics(new ai.djl.metric.Metrics());
        trainer.initialize(Models.IMAGE_SHAPE);

        EasyTrain.fit(trainer, EPOCHS, datasets[0], datasets[1], new SimpleProgress());

        TrainingResult result = trainer.getTrainingResult();

        model.setProperty("Epoch", String.valueOf(EPOCHS));
        model.setProperty("Accuracy", String.format("%.5f", result.getValidateEvaluation("Accuracy")));
        model.setProperty("Loss", String.format("%.5f", result.getValidateLoss()));

        Path modelDir = Paths.get("build/model");
        model.save(modelDir, Models.MODEL_NAME);
    }
}
