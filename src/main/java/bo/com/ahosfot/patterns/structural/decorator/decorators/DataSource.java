package bo.com.ahosfot.patterns.structural.decorator.decorators;

public interface DataSource {
    void writeData(String data);
    String readData();
}
