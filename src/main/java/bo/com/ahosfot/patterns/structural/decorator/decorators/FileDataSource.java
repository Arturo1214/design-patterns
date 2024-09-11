package bo.com.ahosfot.patterns.structural.decorator.decorators;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileDataSource implements DataSource {
    private String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);
        checkFile(file);
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(data.getBytes(StandardCharsets.UTF_8), 0, data.length());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String readData() {
        char[] buffer = new char[1024];
        File file = new File(name);
        try (FileReader fileReader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            fileReader.read(buffer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new String(buffer);
    }

    private void checkFile(File file) {
        if (!file.exists()) {
            try {
                System.out.println("Create directory: " + file.getParentFile().mkdirs());
                System.out.println("Create file: " + file.createNewFile());
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }
}
