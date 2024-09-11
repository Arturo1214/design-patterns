package bo.com.ahosfot.patterns.structural.decorator.decorators;

import lombok.Getter;
import lombok.Setter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator {
    @Getter @Setter
    private int compressionLevel = 6;

    public CompressionDecorator(DataSource wrappedDataSource) {
        super(wrappedDataSource);
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String stringData) {
        byte[] data = stringData.getBytes(StandardCharsets.UTF_8);
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(512);
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream, new Deflater(compressionLevel));
            deflaterOutputStream.write(data);
            deflaterOutputStream.close();
            outputStream.close();
            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (IOException e) {
            System.out.println("Error compressing data: " + e.getMessage());
            return null;
        }
    }

    private String decompress(String stringData) {
        byte[] data = Base64.getDecoder().decode(stringData);
        try {
            InputStream inputStream = new ByteArrayInputStream(data);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(512);
            int bytesRead = 0;
            while ((bytesRead = inflaterInputStream.read()) != -1) {
                outputStream.write(bytesRead);
            }
            inputStream.close();
            inflaterInputStream.close();
            outputStream.close();
            return new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Error decompressing data: " + e.getMessage());
            return null;
        }
    }
}
