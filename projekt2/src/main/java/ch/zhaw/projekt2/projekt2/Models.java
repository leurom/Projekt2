package ch.zhaw.projekt2.projekt2;

import ai.djl.Model;
import ai.djl.ModelException;
import ai.djl.basicmodelzoo.cv.classification.ResNetV1;
import ai.djl.ndarray.types.Shape;
import ai.djl.nn.Block;
import ai.djl.training.DefaultTrainingConfig;
import ai.djl.training.TrainingConfig;
import ai.djl.training.evaluator.Accuracy;
import ai.djl.training.listener.TrainingListener;
import ai.djl.training.loss.Loss;

public class Models {
    public static final String MODEL_NAME = "classifier";
    public static final int NUM_OF_OUTPUT = 10;
    public static final int IMAGE_WIDTH = 224;
    public static final int IMAGE_HEIGHT = 224;
    public static Shape IMAGE_SHAPE;

    public static TrainingConfig getTrainingConfig() {
        Loss loss = Loss.softmaxCrossEntropyLoss();;
        return new DefaultTrainingConfig(loss)
                .addEvaluator(new Accuracy())
                .addTrainingListeners(TrainingListener.Defaults.logging());
    }

    public static Model getModel() throws ModelException {
        // create new instance of an empty model
        Model model = Model.newInstance(MODEL_NAME);
        Block resNet50 = ResNetV1.builder()
                .setImageShape(new Shape(3, IMAGE_HEIGHT, IMAGE_WIDTH))
                .setNumLayers(50)
                .setOutSize(NUM_OF_OUTPUT)
                .build();
        // set the neural network to the model
        model.setBlock(resNet50);
        return model;
    }

}
