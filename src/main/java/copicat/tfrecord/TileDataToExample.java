package copicat.tfrecord;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import copicat.proto.BytesList;
import copicat.proto.Example;
import copicat.proto.Feature;
import copicat.proto.Features;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TileDataToExample {
    public static byte[] serializeToExample(byte[] tiledata) throws InvalidProtocolBufferException {
        BytesList.Builder bytesListBuilder = BytesList.newBuilder();
        bytesListBuilder.addValue(ByteString.copyFrom(tiledata));
        Feature.Builder featureBuilder = Feature.newBuilder();
        featureBuilder.setBytesList(bytesListBuilder);
        Features.Builder featuresBuilder = Features.newBuilder();
        featuresBuilder.putFeature("raw_tile_data", featureBuilder.build());
        Example.Builder exampleBuilder = Example.newBuilder();
        exampleBuilder.setFeatures(featuresBuilder.build());
        return exampleBuilder.build().toByteArray();
    }

    public static void writeToTFRecord(byte[] serialized) throws IOException {

        File file = new File("test.tfrecord");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        TFRecordWriter writer = new TFRecordWriter(dataOutputStream);
        writer.write(serialized);
        dataOutputStream.flush();
        dataOutputStream.close();
    }
}
